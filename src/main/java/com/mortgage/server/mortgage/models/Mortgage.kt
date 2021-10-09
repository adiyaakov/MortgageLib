package com.mortgage.server.mortgage.models

import com.mortgage.server.mortgage.enums.LoanType
import com.mortgage.server.mortgage.loans.YEARLY_NUMBER_OF_MONTHS
import com.mortgage.server.mortgage.loans.oop.AbstractLoan
import com.mortgage.server.mortgage.loans.oop.ChangeAbleRateLoan

class Mortgage(var assetWorth: Double, var equity: Double, var refundCapability: Double) {
    public var monthlyNetIncomes: Double = 0.0
    public var yearlyMadadChange: Double = 0.0
        set(value) {
            field = value
            loansMix.filter { loan ->
                (loan.loanType == LoanType.STICKY_FIX_RATE_FIVE_YEARS) || loan.loanType == LoanType.STICKY_FIX_RATE
            }.forEach { item ->
                if (item is ChangeAbleRateLoan) {
                    item.monthlyMadad = yearlyMadadChange / YEARLY_NUMBER_OF_MONTHS
                }
            }
        }

    public var additionalInterestRateChangesPerJump: Double = 0.0
        set(value) {
            field = value
            loansMix.filter { loan ->
                (loan.loanType == LoanType.STICKY_FIX_RATE_FIVE_YEARS) || loan.loanType == LoanType.FIX_RATE_FIVE_YEARS
            }.forEach { item ->
                if (item is ChangeAbleRateLoan) {
                    item.interestRateChangesPerJump = value
                    item.overrideRate(item.initialRate)
                }
            }
        }

    public var additionalPrimeInterestRateChangesPerJump: Double = 0.0
        set(value) {
            field = value
            loansMix.filter { loan ->
                (loan.loanType == LoanType.PRIME)
            }.forEach { item ->
                if (item is ChangeAbleRateLoan) {
                    item.interestRateChangesPerJump = value
                    item.overrideRate(item.initialRate)
                }
            }
        }

    public var monthlyLoanExpenses: Double = 0.0


    fun availableMoneyPerMonth() : Double {
        return monthlyNetIncomes - monthlyLoanExpenses
    }

    var loansMix: ArrayList<AbstractLoan> = ArrayList()
        private set

    private val totalLoanAmount: Double
        get() {
            return assetWorth - equity
        }


    fun getFinancingPercentage() : Double {
        return totalLoanAmount / assetWorth
    }

    fun getDealBalance() : Double {
        return equity - assetWorth * 0.25
    }

    fun isValidFinancingPercentage() : Boolean {
        return getFinancingPercentage() <= 0.75
    }

    fun insertOrUpdateLoan(index: Int? , loan: AbstractLoan) {
        if (index != null) {
            loansMix.add(index, loan)
        } else {
            loansMix.add(loan)
        }
    }

    fun removeLoan(index: Int) {
        if (loansMix.size > index) {
            loansMix.removeAt(index)
        }
    }

    fun maximumValidRefundCapability() : Double {
        return availableMoneyPerMonth() * 0.4
    }

    fun minimumValidEquity() : Double {
        return assetWorth * 0.25
    }

    fun isValidDownPayment() : Boolean {
        val totalDownPayments = loansMix.sumByDouble { l -> l.getFirstPayment() }
        return maximumValidRefundCapability() > totalDownPayments

    }

    fun getMonthlyMortgageDownPayment() : List<LoanPayment> {
        loansMix.sortByDescending { it.monthsLength }
        if (loansMix.size == 0) {
            return emptyList()
        }

        val data: ArrayList<LoanPayment> = ArrayList()

        val flowChart = loansMix.map { it.calculatesPaymentsFlowChart() }

        for(n in 0 until loansMix[0].monthsLength){
            var initialPrinciple = 0.0
            var ratePayment: Double = 0.0
            var downPayment: Double = 0.0
            var madadPayment: Double = 0.0

            flowChart.forEachIndexed{index, payments ->
                if (payments.indices.contains(n)) {
                    initialPrinciple += payments[n].initialPrinciple
                    ratePayment += payments[n].ratePayment
                    downPayment += payments[n].downPayment
                    madadPayment += payments[n].madadPayment
                }
            }
            data.add(LoanPayment(initialPrinciple, ratePayment, downPayment, madadPayment))
        }
        return data;
    }

    fun getMortgageSummary() : MortgageSummary? {
        val requiredPrinciple = this.assetWorth - this.equity
        var downPaymentSum = 0.0
        var firstPayment = 0.0
        var loanMixes: ArrayList<LoanSummary> = ArrayList()
        loansMix.forEach { loan ->
            val loanSummary = loan.calculateLoanSummaryFor(requiredPrinciple)
            downPaymentSum += loanSummary.downPaymentSum
            firstPayment += loanSummary.firstPayment
            loanMixes.add(loanSummary)
        }
        val moneyPrice = downPaymentSum/requiredPrinciple
        return if (1 > moneyPrice) {
            //Calculation BUG!!!
            null
        } else {
            MortgageSummary(moneyPrice, firstPayment, loanMixes)
        }
    }

    fun optimizeLoans() {
        var firstPayment = getMortgageSummary()?.firstPayment

        if (firstPayment != null && firstPayment > refundCapability) {
            return
        }
        loansMix.sortBy { it.loanType.optimizePriority(it.monthsLength) }
        val paymentsMap = HashMap<Int, Double>()
        loansMix.forEachIndexed { index, abstractLoan ->
            paymentsMap[index] = abstractLoan.getFirstPayment()
        }

        loansMix.forEachIndexed { index, abstractLoan ->
            var clonedLoan = abstractLoan;

            while (refundCapability > optimizedFirstPayment(clonedLoan, paymentsMap, index)) {
                loansMix[index] = clonedLoan
                paymentsMap[index] = clonedLoan.getFirstPayment()
                println("[AY] Optimize loan ${clonedLoan.loanType} | numOfMonths: ${clonedLoan.monthsLength} ${paymentsMap.values.sum()}")
            }
        }
    }

    private fun optimizedFirstPayment(clonedLoan: AbstractLoan, paymentsMap: HashMap<Int, Double>, index: Int): Double {
        clonedLoan.monthsLength = clonedLoan.monthsLength - 1
        val firstPayment = clonedLoan.getFirstPayment()
        //Monthly payment
        return paymentsMap.filter { it.key != index }.values.sum() + firstPayment
    }
}
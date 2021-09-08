package com.mortgage.server.mortgage.models

import com.mortgage.server.mortgage.loans.oop.AbstractLoan

class Mortgage(var assetWorth: Double, var equity: Double, var refundCapability: Double) {
    public var monthlyNetIncomes: Double = 0.0
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
}
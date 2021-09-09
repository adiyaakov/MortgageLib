package com.mortgage.server.mortgage.loans.oop

import com.mortgage.server.mortgage.enums.LoanType
import com.mortgage.server.mortgage.enums.RateChangesJumps
import com.mortgage.server.mortgage.loans.fixeRate.FixedRate
import com.mortgage.server.mortgage.models.LoanPayment

open class ChangeAbleRateLoan(loanType: LoanType, monthlyMadadChanges: Double?, val interestRateChangesPerJump: Double = 0.0, principle: Double = 0.0, rate: Double = 0.0, monthsLength: Int = 0) : FixedRate(principle, rate, monthsLength, loanType, monthlyMadadChanges) {

    override fun prepareForRateChange(paymentNumber: Int) {
        when(rateChangesJump()) {
            RateChangesJumps.NONE -> return
            else -> {
                if (paymentNumber % rateChangesJump().getChangesPeriod() == 0) {
                    println("Updating rate at index " + paymentNumber)
                    updateRate()
                }
            }
        }
    }

    private fun updateRate() {
        this.rate += interestRateChangesPerJump;
    }

    override fun calculatesPaymentsFlowChart(limit: Int): List<LoanPayment> {
        println("Loan start")
        var currentPrinciple = calculatesPrincipleChanges(principle)
        val result = ArrayList<LoanPayment>()

        for (index in 0 until limit - 1) {
            if (principle == 0.0) {
                break
            }
            if (index != 0) {
                currentPrinciple = calculatesPrincipleChanges(currentPrinciple)
            }
            val ratePayment = getRateFor(currentPrinciple, index + 1)
            val downPayment = downPayment(currentPrinciple, monthsLength - index)

            if (index != 0) {
                currentPrinciple -= (downPayment - ratePayment)
            }

            val loanPayment = LoanPayment(currentPrinciple, ratePayment, downPayment)
            result.add(loanPayment)
        }
        return result
    }
}
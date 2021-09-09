package com.mortgage.server.mortgage.loans.oop

import com.mortgage.server.mortgage.enums.RateChangesJumps
import com.mortgage.server.mortgage.loans.fixeRate.FixedRate
import com.mortgage.server.mortgage.models.LoanPayment

open class ChangeAbleRateLoan(monthlyMadadChanges: Double?, val interestRateChangesPerJump: Double = 0.0) : FixedRate(monthlyMadadChanges) {

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

    override fun calculatesPaymentsFlowChart(limit: Int) {
        println("Loan start")
        var currentPrinciple = calculatesPrincipleChanges(principle)


        for (index in 0 until limit -1) {
            if (principle == 0.0) {
                return
            }
            if (index != 0) {
                currentPrinciple = calculatesPrincipleChanges(currentPrinciple)
            }
            val ratePayment = getRateFor(currentPrinciple, index + 1)
            val downPayment = downPayment(currentPrinciple, (12 * this.yearsLength) - index)

            currentPrinciple -= (downPayment - ratePayment)

            val loanPayment = LoanPayment(currentPrinciple, ratePayment, downPayment)
            loanPayment.print()
        }
    }
}
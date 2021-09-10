package com.mortgage.server.mortgage.loans.oop

import com.mortgage.server.mortgage.enums.LoanType
import com.mortgage.server.mortgage.enums.RateChangesJumps
import com.mortgage.server.mortgage.loans.fixeRate.FixedRate
import com.mortgage.server.mortgage.models.LoanPayment

open class ChangeAbleRateLoan(loanType: LoanType, monthlyMadadChanges: Double?, val interestRateChangesPerJump: Double = 0.0, principle: Double = 0.0, rate: Double = 0.0, monthsLength: Int = 0) : FixedRate(principle, rate, monthsLength, loanType, monthlyMadadChanges) {

    override fun prepareForRateChange(paymentNumber: Int) {
//        when(rateChangesJump()) {
//            RateChangesJumps.NONE -> return
//            else -> {
//                if (paymentNumber % rateChangesJump().getChangesPeriod() == 0) {
//                    println("Updating rate at index " + paymentNumber)
//                    updateRate()
//                }
//            }
//        }
    }

    private fun shouldPrepareForRateChange(paymentNumber: Int) : Boolean {
        return paymentNumber % rateChangesJump().getChangesPeriod() == 0
    }

    private fun updateRate() {
        this.rate += interestRateChangesPerJump;
    }

    override fun calculatesPaymentsFlowChart(limit: Int): List<LoanPayment> {
        val result = ArrayList<LoanPayment>()
        var downPayment = downPayment(principle, if (result.isEmpty()) monthsLength else monthsLength)
        for (index in 0 until limit) {
            val monthInitialPrinciple = if (result.isEmpty()) principle else result[index -1].afterPaymentPrinciple
            if (shouldPrepareForRateChange(index + 1)) {
                updateRate()
                downPayment = downPayment(monthInitialPrinciple, monthsLength - index)
            }
            val ratePayment = getRateFor(monthInitialPrinciple, index + 1)
            val loanPayment = LoanPayment(monthInitialPrinciple, ratePayment, downPayment)
            result.add(loanPayment)
        }
        return result
    }
}
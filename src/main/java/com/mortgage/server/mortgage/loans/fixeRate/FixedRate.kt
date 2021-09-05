package com.mortgage.server.mortgage.loans.fixeRate

import com.mortgage.server.mortgage.enums.RateChangesJumps
import com.mortgage.server.mortgage.loans.oop.AbstractLoan
import com.mortgage.server.mortgage.models.LoanPayment
import kotlin.math.pow

open class FixedRate(var monthlyMadad: Double? = null) : AbstractLoan() {
    override fun downPayment(currentPrinciple: Double, monthsRemains: Int): Double {
        val monthlyRate = rate / 12.0 / 100.0
        return currentPrinciple * monthlyRate * (1 + monthlyRate).pow(monthsRemains.toDouble()) /
                ((1 + monthlyRate).pow(monthsRemains.toDouble()) - 1)
    }

    protected fun getRateFor(currentPrinciple: Double, paymentNumber: Int): Double {
        prepareForRateChange(paymentNumber)
        return currentPrinciple * (rate / 12) / 100
    }

    override fun calculatesPaymentsFlowChart(limit: Int) {
        println("Loan start")
        var currentPrinciple = principle
        val downPayment = downPayment(principle, 12 * this.yearsLength)

        for (index in 0 until limit) {
            if (principle == 0.0) {
                return
            }
            val ratePayment = getRateFor(currentPrinciple, index + 1)

            currentPrinciple -= (downPayment - ratePayment)

            val loanPayment = LoanPayment(currentPrinciple, ratePayment, downPayment)
            loanPayment.print()
        }

    }

    override fun calculatesPrincipleChanges(monthlyPrinciple: Double) : Double {
        monthlyMadad?.let {it
            return monthlyPrinciple * (1 + (it/100.0))
        }. run {
            return monthlyPrinciple
        }
    }

    override fun prepareForRateChange(paymentNumber: Int) {
        //DO noting
    }

    override fun rateChangesJump(): RateChangesJumps {
        return RateChangesJumps.NONE
    }
}
package com.mortgage.server.mortgage.loans.fixeRate

import com.mortgage.server.mortgage.enums.LoanType
import com.mortgage.server.mortgage.enums.RateChangesJumps
import com.mortgage.server.mortgage.loans.oop.AbstractLoan
import com.mortgage.server.mortgage.models.LoanPayment
import kotlin.math.pow

open class FixedRate(principle: Double = 0.0, rate: Double = 0.0, monthsLength: Int = 0, loanType: LoanType = LoanType.FIX_RATE, var monthlyMadad: Double? = null) : AbstractLoan(loanType, principle, rate, monthsLength) {
    override fun downPayment(currentPrinciple: Double, monthsRemains: Int): Double {
        val monthlyRate = rate / 12.0 / 100.0
        return currentPrinciple * monthlyRate * (1 + monthlyRate).pow(monthsRemains.toDouble()) /
                ((1 + monthlyRate).pow(monthsRemains.toDouble()) - 1)
    }

    protected fun getRateFor(currentPrinciple: Double, paymentNumber: Int): Double {
        prepareForRateChange(paymentNumber)
        return currentPrinciple * (rate / 12) / 100
    }

    override fun calculatesPaymentsFlowChart(limit: Int) : List<LoanPayment> {
        println("Loan start")
        var currentPrinciple = principle
        val downPayment = downPayment(principle, monthsLength)
        val result = ArrayList<LoanPayment>()
        for (index in 0 until limit -1) {
            if (principle == 0.0) {
                break
            }
            val ratePayment = getRateFor(currentPrinciple, index + 1)

            if (index != 0) {
                currentPrinciple -= (downPayment - ratePayment)
            }

            val loanPayment = LoanPayment(currentPrinciple, ratePayment, downPayment)
            result.add(loanPayment)
        }
        return result

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
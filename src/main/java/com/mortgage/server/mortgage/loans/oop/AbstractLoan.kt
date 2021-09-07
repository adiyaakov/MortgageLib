package com.mortgage.server.mortgage.loans.oop

import com.mortgage.server.mortgage.enums.RateChangesJumps
import com.mortgage.server.mortgage.models.LoanPayment

abstract class AbstractLoan {
    var principle = 90000.0
    var yearsLength = 12
    var rate = 1.85
    fun totalMonths(): Int {
        return (yearsLength * 12)
    }

    abstract fun downPayment(currentPrinciple: Double, monthsRemains: Int): Double
    abstract fun calculatesPaymentsFlowChart(limit: Int = totalMonths()) : List<LoanPayment>
    abstract fun calculatesPrincipleChanges(monthlyPrinciple: Double) : Double
    abstract fun prepareForRateChange(paymentNumber: Int)
    abstract fun rateChangesJump() : RateChangesJumps

    fun getFinancingPercentage(totalLoanAmount: Double) : Double {
        return totalLoanAmount / principle
    }

    fun getFirstPayment() : Double {
        val value = calculatesPaymentsFlowChart(1).firstOrNull()?.downPayment
        return value ?: 0.0
    }

}
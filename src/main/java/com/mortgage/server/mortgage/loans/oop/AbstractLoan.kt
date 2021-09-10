package com.mortgage.server.mortgage.loans.oop

import com.mortgage.server.mortgage.enums.LoanType
import com.mortgage.server.mortgage.enums.RateChangesJumps
import com.mortgage.server.mortgage.models.LoanPayment

abstract class AbstractLoan(var loanType: LoanType, var principle: Double = 0.0, var rate: Double = 0.0, var monthsLength: Int = 0) {
    abstract fun downPayment(currentPrinciple: Double, monthsRemains: Int): Double
    abstract fun calculatesPaymentsFlowChart(limit: Int = monthsLength) : List<LoanPayment>
    abstract fun calculatesPrincipleChanges(monthlyPrinciple: Double) : Double
    abstract fun prepareForRateChange(paymentNumber: Int)
    abstract fun rateChangesJump() : RateChangesJumps

    fun getFinancingPercentage(totalLoanAmount: Double) : Double {
        return totalLoanAmount / principle
    }

    fun getFirstPayment() : Double {
        val value = calculatesPaymentsFlowChart(2).firstOrNull()?.downPayment
        return value ?: 0.0
    }

}
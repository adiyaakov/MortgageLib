package com.mortgage.server.mortgage

import com.mortgage.server.mortgage.enums.LoanType
import com.mortgage.server.mortgage.loans.fixeRate.FixedRate
import com.mortgage.server.mortgage.models.Mortgage

object MortgageApplication {
    @JvmStatic
    fun main(args: Array<String>) {
        printILoveYou()
    }

    fun printILoveYou() {
        val m = Mortgage(0.0, 0.0, 0.0)
        m.insertOrUpdateLoan(0, FixedRate(100000.0, 1.0, 120, LoanType.FIX_RATE, null))
        m.insertOrUpdateLoan(0, FixedRate(100000.0, 1.0, 360, LoanType.FIX_RATE, null))
        m.getMonthlyMortgageDownPayment()
    }
}
package com.mortgage.server.mortgage

import com.mortgage.server.mortgage.enums.LoanType
import com.mortgage.server.mortgage.loans.fixeRate.FixedRate
import com.mortgage.server.mortgage.loans.sticky.StickyFixedRateLoan
import com.mortgage.server.mortgage.models.Mortgage

object MortgageApplication {
    @JvmStatic
    fun main(args: Array<String>) {
        printILoveYou()
    }

    fun printILoveYou() {
        StickyFixedRateLoan(100000.0, 4.3, 360, 0.125).calculatesPaymentsFlowChart()
    }
}
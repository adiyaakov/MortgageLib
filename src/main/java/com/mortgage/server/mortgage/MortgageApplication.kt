package com.mortgage.server.mortgage

import com.mortgage.server.mortgage.enums.LoanType
import com.mortgage.server.mortgage.loans.fixeRate.FixedRate
import com.mortgage.server.mortgage.loans.fixeRate.FixedRateFiveYearsChangesLoan
import com.mortgage.server.mortgage.loans.sticky.StickyFixedRateLoan
import com.mortgage.server.mortgage.models.Mortgage

object MortgageApplication {
    @JvmStatic
    fun main(args: Array<String>) {
        FixedRateFiveYearsChangesLoan(300000.0, 4.3, 120, 0.0).calculatesPaymentsFlowChart()

    }


}
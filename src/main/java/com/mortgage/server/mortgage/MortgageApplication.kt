package com.mortgage.server.mortgage

import com.mortgage.server.mortgage.enums.LoanType
import com.mortgage.server.mortgage.loans.fixeRate.FixedRate
import com.mortgage.server.mortgage.loans.fixeRate.FixedRateFiveYearsChangesLoan
import com.mortgage.server.mortgage.loans.prime.PrimeLoan
import com.mortgage.server.mortgage.loans.sticky.StickyFixedRateLoan
import com.mortgage.server.mortgage.models.Mortgage

object MortgageApplication {
    @JvmStatic
    fun main(args: Array<String>) {
        val mort = Mortgage(1000000.0, 400000.0, 8000.0)
        mort.insertOrUpdateLoan(0, StickyFixedRateLoan(200000.0, 2.3, 360, 0.125))
        mort.insertOrUpdateLoan(0, PrimeLoan(400000.0, 1.3, 360, 0.0))
        mort.optimizeLoans()
        mort.getMortgageSummary()
    }


}
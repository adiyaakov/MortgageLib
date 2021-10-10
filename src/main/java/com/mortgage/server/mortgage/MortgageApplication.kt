package com.mortgage.server.mortgage

import com.mortgage.server.mortgage.enums.LoanType
import com.mortgage.server.mortgage.loans.fixeRate.FixedRate
import com.mortgage.server.mortgage.loans.fixeRate.FixedRateFiveYearsChangesLoan
import com.mortgage.server.mortgage.loans.prime.PrimeLoan
import com.mortgage.server.mortgage.loans.sticky.StickyFixedRateLoan
import com.mortgage.server.mortgage.loans.sticky.StickyFixedRateLoanFiveYearsChanges
import com.mortgage.server.mortgage.models.Mortgage

object MortgageApplication {
    @JvmStatic
    fun main(args: Array<String>) {
        val mort = Mortgage(1000000.0, 300000.0, 5450.0)
        mort.insertOrUpdateLoan(0, FixedRate(304500.0, 2.9, 360))
        mort.insertOrUpdateLoan(0, FixedRate(168000.0, 2.325, 360))
        mort.insertOrUpdateLoan(0, PrimeLoan(227500.0, 1.3, 360, 0.0))


        mort.optimizeLoans()
        mort.getMortgageSummary()

    }


}
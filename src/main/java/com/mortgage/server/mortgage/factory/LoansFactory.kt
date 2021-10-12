package com.mortgage.server.mortgage.factory

import com.mortgage.server.mortgage.enums.LoanType
import com.mortgage.server.mortgage.loans.fixeRate.FixedRate
import com.mortgage.server.mortgage.loans.fixeRate.FixedRateFiveYearsChangesLoan
import com.mortgage.server.mortgage.loans.fixeRate.FixedRateTwoAndHalfYearsChangesLoan
import com.mortgage.server.mortgage.loans.fixeRate.OgenMakamOneYearChangesLoan
import com.mortgage.server.mortgage.loans.oop.AbstractLoan
import com.mortgage.server.mortgage.loans.prime.PrimeLoan
import com.mortgage.server.mortgage.loans.sticky.StickyFixedRateLoan
import com.mortgage.server.mortgage.loans.sticky.StickyFixedRateLoanFiveYearsChanges
import com.mortgage.server.mortgage.loans.sticky.StickyFixedRateLoanTwoAndHalfYearsChanges

class LoansFactory {
    companion object {
        public fun buildLoan(loanType: LoanType, principle: Double = 0.0, rate: Double = 0.0, monthsLength: Int = 0, monthlyMadad: Double = 0.0, interestRateChangesPerJump: Double = 0.0) : AbstractLoan {
            return when(loanType) {
                LoanType.FIX_RATE -> FixedRate(principle, rate, monthsLength)
                LoanType.STICKY_FIX_RATE -> StickyFixedRateLoan(principle, rate, monthsLength, monthlyMadad)
                LoanType.FIX_RATE_FIVE_YEARS -> FixedRateFiveYearsChangesLoan(principle, rate, monthsLength, interestRateChangesPerJump)
                LoanType.STICKY_FIX_RATE_FIVE_YEARS -> StickyFixedRateLoanFiveYearsChanges(principle, rate, monthsLength, monthlyMadad, interestRateChangesPerJump)
                LoanType.PRIME -> PrimeLoan(principle, rate, monthsLength, interestRateChangesPerJump)
                LoanType.FIX_RATE_TWO_AND_HALF_YEARS -> FixedRateTwoAndHalfYearsChangesLoan(principle, rate, monthsLength, interestRateChangesPerJump)
                LoanType.STICKY_FIX_RATE_TWO_AND_HALF_YEARS -> StickyFixedRateLoanTwoAndHalfYearsChanges(principle, rate, monthsLength, monthlyMadad, interestRateChangesPerJump)
                LoanType.MAKAM_OGEN_1_YEAR -> OgenMakamOneYearChangesLoan(principle, rate, monthsLength, interestRateChangesPerJump)
            }
        }
    }
}
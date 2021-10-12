package com.mortgage.server.mortgage.loans.fixeRate

import com.mortgage.server.mortgage.enums.LoanType
import com.mortgage.server.mortgage.enums.RateChangesJumps
import com.mortgage.server.mortgage.loans.oop.ChangeAbleRateLoan

class FixedRateTwoAndHalfYearsChangesLoan(principle: Double = 0.0, rate: Double = 0.0, monthsLength: Int = 0, interestRateChangesPerJump: Double) : ChangeAbleRateLoan(LoanType.FIX_RATE_TWO_AND_HALF_YEARS, null, interestRateChangesPerJump, principle, rate, monthsLength) {
    override fun rateChangesJump(): RateChangesJumps {
        return RateChangesJumps.TWO_AND_HALF_YEARS
    }
}
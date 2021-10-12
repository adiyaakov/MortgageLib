package com.mortgage.server.mortgage.loans.sticky

import com.mortgage.server.mortgage.enums.LoanType
import com.mortgage.server.mortgage.enums.RateChangesJumps
import com.mortgage.server.mortgage.loans.oop.ChangeAbleRateLoan

class StickyFixedRateLoanTwoAndHalfYearsChanges(principle: Double = 0.0, rate: Double = 0.0, monthsLength: Int = 0, monthlyMadad: Double, interestRateChangesPerJump: Double) : ChangeAbleRateLoan(LoanType.STICKY_FIX_RATE_TWO_AND_HALF_YEARS, monthlyMadad, interestRateChangesPerJump, principle, rate, monthsLength) {
    override fun rateChangesJump(): RateChangesJumps {
        return RateChangesJumps.TWO_AND_HALF_YEARS
    }
}
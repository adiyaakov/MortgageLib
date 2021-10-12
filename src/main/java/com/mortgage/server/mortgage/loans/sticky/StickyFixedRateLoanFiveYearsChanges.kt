package com.mortgage.server.mortgage.loans.sticky

import com.mortgage.server.mortgage.enums.LoanType
import com.mortgage.server.mortgage.enums.RateChangesJumps
import com.mortgage.server.mortgage.loans.oop.ChangeAbleRateLoan

class StickyFixedRateLoanFiveYearsChanges(principle: Double = 0.0, rate: Double = 0.0, monthsLength: Int = 0, monthlyMadad: Double, interestRateChangesPerJump: Double) : ChangeAbleRateLoan(LoanType.STICKY_FIX_RATE_FIVE_YEARS, monthlyMadad, interestRateChangesPerJump, principle, rate, monthsLength) {
    override fun rateChangesJump(): RateChangesJumps {
        return RateChangesJumps.FIVE_YEARS
    }
}




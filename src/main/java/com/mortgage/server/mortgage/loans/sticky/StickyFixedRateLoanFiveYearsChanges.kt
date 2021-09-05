package com.mortgage.server.mortgage.loans.sticky

import com.mortgage.server.mortgage.enums.RateChangesJumps
import com.mortgage.server.mortgage.loans.oop.ChangeAbleRateLoan

class StickyFixedRateLoanFiveYearsChanges(monthlyMadad: Double, interestRateChangesPerJump: Double) : ChangeAbleRateLoan(monthlyMadad, interestRateChangesPerJump) {
    override fun rateChangesJump(): RateChangesJumps {
        return RateChangesJumps.FIVE_YEARS
    }
}
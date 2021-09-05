package com.mortgage.server.mortgage.loans.fixeRate

import com.mortgage.server.mortgage.enums.RateChangesJumps
import com.mortgage.server.mortgage.loans.oop.ChangeAbleRateLoan

class FixedRateFiveYearsChangesLoan(interestRateChangesPerJump: Double) : ChangeAbleRateLoan(null, interestRateChangesPerJump) {
    override fun rateChangesJump(): RateChangesJumps {
        return RateChangesJumps.FIVE_YEARS
    }
}
package com.mortgage.server.mortgage.loans.prime

import com.mortgage.server.mortgage.enums.LoanType
import com.mortgage.server.mortgage.enums.RateChangesJumps
import com.mortgage.server.mortgage.loans.oop.ChangeAbleRateLoan

class PrimeLoan(principle: Double = 0.0, rate: Double = 0.0, monthsLength: Int = 0, interestRateChangesPerJump: Double) : ChangeAbleRateLoan(LoanType.PRIME, null, interestRateChangesPerJump, principle, rate, monthsLength) {
    override fun rateChangesJump(): RateChangesJumps {
        return RateChangesJumps.MONTHLY
    }
}


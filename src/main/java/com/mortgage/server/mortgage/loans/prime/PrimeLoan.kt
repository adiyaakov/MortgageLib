package com.mortgage.server.mortgage.loans.prime

import com.mortgage.server.mortgage.enums.LoanType
import com.mortgage.server.mortgage.enums.RateChangesJumps
import com.mortgage.server.mortgage.loans.oop.ChangeAbleRateLoan

class PrimeLoan(interestRateChangesPerJump: Double) : ChangeAbleRateLoan(LoanType.PRIME, null, interestRateChangesPerJump) {
    override fun rateChangesJump(): RateChangesJumps {
        return RateChangesJumps.MONTHLY
    }
}


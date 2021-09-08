package com.mortgage.server.mortgage.loans.sticky

import com.mortgage.server.mortgage.enums.LoanType
import com.mortgage.server.mortgage.loans.oop.ChangeAbleRateLoan

class StickyFixedRateLoan(principle: Double = 0.0, rate: Double = 0.0, monthsLength: Int = 0, monthlyMadad: Double) : ChangeAbleRateLoan(LoanType.STICKY_FIX_RATE, monthlyMadad, 0.0, principle, rate, monthsLength) {
}
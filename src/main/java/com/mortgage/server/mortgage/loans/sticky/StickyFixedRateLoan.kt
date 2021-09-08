package com.mortgage.server.mortgage.loans.sticky

import com.mortgage.server.mortgage.enums.LoanType
import com.mortgage.server.mortgage.loans.oop.ChangeAbleRateLoan

class StickyFixedRateLoan(monthlyMadad: Double) : ChangeAbleRateLoan(LoanType.STICKY_FIX_RATE, monthlyMadad) {
}
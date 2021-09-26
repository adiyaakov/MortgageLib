package com.mortgage.server.mortgage.enums

import com.mortgage.server.mortgage.loans.YEARLY_NUMBER_OF_MONTHS

enum class RateChangesJumps {
    NONE, MONTHLY, FIVE_YEARS;

    public fun getChangesPeriod() : Int {
        when(this) {
            NONE -> return 0
            MONTHLY -> return 1
            FIVE_YEARS -> return YEARLY_NUMBER_OF_MONTHS.toInt() * 5
        }
    }
}


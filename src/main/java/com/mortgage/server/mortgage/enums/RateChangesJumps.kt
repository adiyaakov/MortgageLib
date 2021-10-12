package com.mortgage.server.mortgage.enums

import com.mortgage.server.mortgage.loans.YEARLY_NUMBER_OF_MONTHS

enum class RateChangesJumps {
    NONE, MONTHLY, ONE_YEAR, FIVE_YEARS, TWO_AND_HALF_YEARS;

    public fun getChangesPeriod() : Int {
        when(this) {
            NONE -> return 0
            MONTHLY -> return 1
            FIVE_YEARS -> return YEARLY_NUMBER_OF_MONTHS.toInt() * 5
            TWO_AND_HALF_YEARS -> return 30
            ONE_YEAR -> return YEARLY_NUMBER_OF_MONTHS.toInt()
        }
    }
}


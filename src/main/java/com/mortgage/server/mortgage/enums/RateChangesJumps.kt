package com.mortgage.server.mortgage.enums

enum class RateChangesJumps {
    NONE, MONTHLY, FIVE_YEARS;

    public fun getChangesPeriod() : Int {
        when(this) {
            NONE -> return 0
            MONTHLY -> return 1
            FIVE_YEARS -> return 12 * 5
        }
    }
}


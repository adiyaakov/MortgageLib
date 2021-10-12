package com.mortgage.server.mortgage.enums

enum class LoanType(val id: Long) {
    FIX_RATE(0), STICKY_FIX_RATE(1), FIX_RATE_FIVE_YEARS(2), STICKY_FIX_RATE_FIVE_YEARS(3) , PRIME(4),
    MAKAM_OGEN_1_YEAR(5), FIX_RATE_TWO_AND_HALF_YEARS(6), STICKY_FIX_RATE_TWO_AND_HALF_YEARS(7);

    companion object {
        fun valueOf(id: Long) = values().first { it.id == id }
    }

    fun optimizePriority(numberOfMonths: Int) : Int {
        return when(this) {
            //Most long terms dangerous
            STICKY_FIX_RATE ->  if (numberOfMonths >= 180) 4 else 3
            STICKY_FIX_RATE_TWO_AND_HALF_YEARS -> if (numberOfMonths >= 180) 4 else 3
            STICKY_FIX_RATE_FIVE_YEARS -> if (numberOfMonths >= 180) 6 else 5

            //Most cheapest
            MAKAM_OGEN_1_YEAR -> 9
            PRIME -> 10

            //Most expensive
            FIX_RATE -> return 1
            FIX_RATE_TWO_AND_HALF_YEARS -> if (numberOfMonths >= 180) 4 else 3
            FIX_RATE_FIVE_YEARS -> 2
        }
    }

    fun hebName() : String {
        return when(this) {
            FIX_RATE -> "קבועה לא צמודה"
            STICKY_FIX_RATE -> "קבועה צמודה"
            FIX_RATE_FIVE_YEARS -> "קבועה לא צמודה משתנה כל 5 שנים"
            STICKY_FIX_RATE_FIVE_YEARS -> "קבועה צמודה משתנה כל 5 שנים"
            PRIME -> "פריים"
            MAKAM_OGEN_1_YEAR -> "עוגן מק״מ"
            FIX_RATE_TWO_AND_HALF_YEARS -> "קבועה לא צמודה משתנה כל 2.5 שנים"
            STICKY_FIX_RATE_TWO_AND_HALF_YEARS -> "קבועה צמודה משתנה כל 2.5 שנים"
        }
    }

    fun hebShortName() : String {
        return when(this) {
            FIX_RATE -> "קל'צ"
            STICKY_FIX_RATE -> "ק'צ"
            FIX_RATE_FIVE_YEARS -> "קל'צ 5 שנים"
            STICKY_FIX_RATE_FIVE_YEARS -> "ק'צ 5 שנים"
            PRIME -> "פריים"
            MAKAM_OGEN_1_YEAR -> "עוגן מק״מ"
            FIX_RATE_TWO_AND_HALF_YEARS -> "קל'צ 2.5 שנים"
            STICKY_FIX_RATE_TWO_AND_HALF_YEARS -> "ק'צ 2.5 שנים"
        }
    }
}


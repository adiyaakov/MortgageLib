package com.mortgage.server.mortgage.enums

enum class LoanType(val index: Int) {
    FIX_RATE(0), STICKY_FIX_RATE(1), FIX_RATE_FIVE_YEARS(2), STICKY_FIX_RATE_FIVE_YEARS(3) , PRIME(4);

    fun hebName() : String {
        return when(this) {
            FIX_RATE -> "קבועה לא צמודה"
            STICKY_FIX_RATE -> "קבועה צמודה"
            FIX_RATE_FIVE_YEARS -> "קבועה לא צמודה משתנה כל 5 שנים"
            STICKY_FIX_RATE_FIVE_YEARS -> "קבועה צמודה משתנה כל 5 שנים"
            PRIME -> "פריים"
        }
    }

    fun hebShortName() : String {
        return when(this) {
            FIX_RATE -> "קל'צ"
            STICKY_FIX_RATE -> "ק'צ"
            FIX_RATE_FIVE_YEARS -> "קל'צ 5 שנים"
            STICKY_FIX_RATE_FIVE_YEARS -> "ק'צ 5 שנים"
            PRIME -> "פריים"
        }
    }
}


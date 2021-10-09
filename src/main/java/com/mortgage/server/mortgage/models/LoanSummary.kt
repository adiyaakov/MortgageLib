package com.mortgage.server.mortgage.models

import com.mortgage.server.mortgage.enums.LoanType

class MortgageSummary(val moneyPrice: Double, val firstPayment: Double, val loansMix: ArrayList<LoanSummary>)


class LoanSummary(var percentage: Double, val loanType: LoanType, var principal: Double, val initialRate: Double,
                  val monthLength: Int, val firstPayment: Double, val downPaymentSum: Double) {
}
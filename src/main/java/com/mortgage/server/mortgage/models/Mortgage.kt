package com.mortgage.server.mortgage.models

import com.mortgage.server.mortgage.enums.LoanType
import com.mortgage.server.mortgage.loans.oop.AbstractLoan

class Mortgage(var assetWorth: Double, var equity: Double, var refundCapability: Double) {
    public var netDisposableIncome: Double = 0.0
    var mortgage: HashMap<LoanType, AbstractLoan> = HashMap()
        private set

    private val totalLoanAmount: Double
        get() {
            return assetWorth - equity
        }


    fun getFinancingPercentage() : Double {
        return totalLoanAmount / assetWorth
    }

    fun getDealBalance() : Double {
        return equity - assetWorth * 0.25
    }

    fun isValidFinancingPercentage() : Boolean {
        return getFinancingPercentage() <= 0.75
    }

    fun insertOrUpdateLoan(loanType: LoanType , loan: AbstractLoan?) {
        loan?.let {it
            mortgage.put(loanType, it)
        }.run {
            mortgage.remove(loanType)
        }
    }

    fun maximumValidRefundCapability() : Double {
        return netDisposableIncome * 0.4
    }

    fun minimumValidEquity() : Double {
        return assetWorth * 0.25
    }

    fun isValidDownPayment() : Boolean {
        val totalDownPayments = mortgage.values.sumByDouble { l -> l.getFirstPayment() }
        return maximumValidRefundCapability() > totalDownPayments

    }
}
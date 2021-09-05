package com.mortgage.server.mortgage.models

import java.text.DecimalFormat
import java.text.NumberFormat

open class LoanPayment(var initialPrinciple: Double, var ratePayment: Double, var downPayment: Double) {
    var afterPaymentPrinciple = initialPrinciple - ratePayment;
    var fundPayment = downPayment - ratePayment;


    public fun print() {
        val formatter: NumberFormat = DecimalFormat("#0.00")

        println("Payment: " + formatter.format(downPayment))
        println("Rate: " + formatter.format(ratePayment))
        println("currentPrinciple: " + formatter.format(initialPrinciple))
        println("fundPayment: " + formatter.format(fundPayment))
        println("\n-------\n")
    }
}
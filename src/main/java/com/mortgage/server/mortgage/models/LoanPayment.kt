package com.mortgage.server.mortgage.models

import java.text.DecimalFormat
import java.text.NumberFormat

open class LoanPayment(var initialPrinciple: Double, var ratePayment: Double, var downPayment: Double) {
    var afterPaymentPrinciple = initialPrinciple - ratePayment;
    var fundPayment = downPayment - ratePayment;
    
}
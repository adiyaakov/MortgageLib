package com.ay.mortgage_server_app.db.db_response

import com.mortgage.server.mortgage.enums.LoanType

class LoanRoute(var percent: Double, var principle: Double,
                var loanTypeId: Long, var numberOfMonths: Int) {
}
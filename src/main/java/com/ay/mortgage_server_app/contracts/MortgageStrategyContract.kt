package com.ay.mortgage_server_app.contracts

import com.ay.mortgage_server_app.requestsBody.StrategyLoanBuilderRequest
import com.ay.mortgage_server_app.responses.LoanSummary
import com.ay.mortgage_server_app.responses.MortgageSummary
import com.mortgage.server.mortgage.models.Mortgage

interface MortgageStrategyContract {
    fun findBestStrategyFor(body: StrategyLoanBuilderRequest) : List<MortgageSummary>
}

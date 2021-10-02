package com.ay.mortgage_server_app.controllers

import com.ay.mortgage_server_app.contracts.MortgageStrategyContract
import com.ay.mortgage_server_app.db.db_response.PotentialMortgage
import org.springframework.beans.factory.annotation.Autowired
import com.ay.mortgage_server_app.db.repositories.MortgageRepository
import com.ay.mortgage_server_app.db.repositories.LoansMortgageRepository
import javax.validation.Valid
import com.ay.mortgage_server_app.db.entities.MortgageEntity
import com.ay.mortgage_server_app.requestsBody.Loan
import com.ay.mortgage_server_app.db.entities.LoansMortgageEntity
import com.ay.mortgage_server_app.requestsBody.Mortgage
import com.ay.mortgage_server_app.requestsBody.StrategyLoanBuilderRequest
import com.ay.mortgage_server_app.responses.LoanSummary
import com.ay.mortgage_server_app.responses.MortgageSummary
import org.springframework.web.bind.annotation.*
import java.util.function.Consumer

@RestController
@RequestMapping("/strategy")
class MortgageStrategyController {
    @Autowired
    var contract: MortgageStrategyContract? = null

    @GetMapping
    fun getStrategy(@RequestBody body: @Valid StrategyLoanBuilderRequest) : List<MortgageSummary> {
        return contract!!.findBestStrategyFor(body)
    }

}
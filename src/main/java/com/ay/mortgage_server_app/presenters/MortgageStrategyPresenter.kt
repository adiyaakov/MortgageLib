package com.ay.mortgage_server_app.presenters

import com.ay.mortgage_server_app.contracts.MortgageStrategyContract
import com.ay.mortgage_server_app.db.db_response.LoanRoute
import com.ay.mortgage_server_app.db.db_response.PotentialMortgage
import com.ay.mortgage_server_app.db.repositories.MortgageRepository
import com.ay.mortgage_server_app.requestsBody.StrategyLoanBuilderRequest
import com.ay.mortgage_server_app.responses.LoanSummary
import com.ay.mortgage_server_app.responses.MortgageSummary
import com.google.gson.Gson
import com.mortgage.server.mortgage.enums.LoanType
import com.mortgage.server.mortgage.factory.LoansFactory
import com.mortgage.server.mortgage.models.Mortgage
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.security.Principal

@Service
class MortgageStrategyPresenter : MortgageStrategyContract {
    @Autowired
    lateinit var mortgageRepository: MortgageRepository

    override fun findBestStrategyFor(body: StrategyLoanBuilderRequest) : List<MortgageSummary> {
        var response : ArrayList<MortgageSummary> = ArrayList()
        val res = mortgageRepository.fetchStrategyFor(body.requiredPrinciple)
        res.forEachIndexed { index, _ ->
            val loansMix: Array<LoanRoute> = Gson().fromJson(res[index].getData(), Array<LoanRoute>::class.java)
            val mortgage: Mortgage = Mortgage(body.assetWorth, body.equity, body.refundCapability)

            loansMix.forEachIndexed { index, loanRoute ->
                mortgage.insertOrUpdateLoan(index, LoansFactory.buildLoan(LoanType.valueOf(loanRoute.loanTypeId),
                        loanRoute.principle,
                        4.0,  loanRoute.numberOfMonths, 0.125, 0.0)
                )
            }

            var downPaymentSum = 0.0
            var firstPayment = 0.0
            var loanMixes: ArrayList<LoanSummary> = ArrayList()
            mortgage.loansMix.forEach {
                it.calculatesPaymentsFlowChart().forEach {  loanPayment ->
                    downPaymentSum += loanPayment.downPayment
                }

                val loanFirstPayment: Double = it.calculatesPaymentsFlowChart(1).sumByDouble { it.downPayment }
                firstPayment += loanFirstPayment

                loanMixes.add(LoanSummary(0.0, it.loanType, it.principle, it.initialRate, it.monthsLength, loanFirstPayment))
            }
            val moneyPrice = downPaymentSum / body.requiredPrinciple

            val mortgageSummary = MortgageSummary(moneyPrice, firstPayment, loanMixes)
            response.add(mortgageSummary)
        }

        return response
    }



}


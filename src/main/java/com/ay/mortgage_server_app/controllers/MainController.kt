package com.ay.mortgage_server_app.controllers

import org.springframework.beans.factory.annotation.Autowired
import com.ay.mortgage_server_app.db.repositories.MortgageRepository
import com.ay.mortgage_server_app.db.repositories.LoansMortgageRepository
import javax.validation.Valid
import com.ay.mortgage_server_app.db.entities.MortgageEntity
import com.ay.mortgage_server_app.requestsBody.Loan
import com.ay.mortgage_server_app.db.entities.LoansMortgageEntity
import com.ay.mortgage_server_app.requestsBody.Mortgage
import org.springframework.web.bind.annotation.*
import java.util.function.Consumer

@RestController
@RequestMapping("/mortgage")
class MainController {
    @Autowired
    var repository: MortgageRepository? = null

    @Autowired
    var loansMortgageRepository: LoansMortgageRepository? = null

    @GetMapping
    fun getStrategy(@RequestBody body: @Valid com.mortgage.server.mortgage.models.Mortgage) {
        println("")
    }

    @PostMapping
    fun create(@RequestBody body: @Valid Mortgage) {
        val entity = MortgageEntity()
        entity.title = body.title
        if (body.loansMix.sumOf { it.percentage } != 100.0) {
            return
        }

        val id = repository!!.save(entity).id

        body.loansMix.forEach(Consumer { loan: Loan ->
            val loanMortgageEntity = LoansMortgageEntity()
            loanMortgageEntity.numberOfMonths = loan.monthsLength
            loanMortgageEntity.loanTypeId = loan.loanType.id
            loanMortgageEntity.percent = loan.percentage
            loanMortgageEntity.mortgageId = id
            loansMortgageRepository!!.save(loanMortgageEntity)
        })
        repository!!.findAll()
    }
}
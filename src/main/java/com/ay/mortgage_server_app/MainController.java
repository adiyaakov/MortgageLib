package com.ay.mortgage_server_app;

import com.ay.mortgage_server_app.db.entities.LoansMortgageEntity;
import com.ay.mortgage_server_app.db.entities.MortgageEntity;
import com.ay.mortgage_server_app.db.repositories.LoansMortgageRepository;
import com.ay.mortgage_server_app.db.repositories.MortgageRepository;
import com.ay.mortgage_server_app.requestsBody.Loan;
import com.ay.mortgage_server_app.requestsBody.Mortgage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.function.Consumer;

@RestController
@RequestMapping("/mortgage")
public class MainController {
    @Autowired
    MortgageRepository repository;

    @Autowired
    LoansMortgageRepository loansMortgageRepository;

    @PostMapping
    public void create(@Valid @RequestBody Mortgage body) {
        MortgageEntity entity = new MortgageEntity();
        entity.setTitle(body.getTitle());

        

        Long id = repository.save(entity).getId();

        body.getLoansMix().forEach(loan -> {
            LoansMortgageEntity loanMortgageEntity = new LoansMortgageEntity();
            loanMortgageEntity.setLoanTypeId(loan.getLoanType().getId());
            loanMortgageEntity.setPercent(loan.getPercentage());
            loanMortgageEntity.setMortgageId(id);
            loansMortgageRepository.save(loanMortgageEntity);
        });

        repository.findAll();
    }
}

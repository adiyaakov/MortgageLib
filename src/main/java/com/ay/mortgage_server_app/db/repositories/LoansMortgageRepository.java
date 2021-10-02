package com.ay.mortgage_server_app.db.repositories;

import com.ay.mortgage_server_app.db.entities.LoansMortgage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LoansMortgageRepository extends JpaRepository<LoansMortgage, Long>, JpaSpecificationExecutor<LoansMortgage> {

}
package com.ay.mortgage_server_app.db.repositories;

import com.ay.mortgage_server_app.db.entities.LoansMortgageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LoansMortgageRepository extends JpaRepository<LoansMortgageEntity, Long>, JpaSpecificationExecutor<LoansMortgageEntity> {

}
package com.ay.mortgage_server_app.db.repositories;

import com.ay.mortgage_server_app.db.db_response.PotentialMortgage;
import com.ay.mortgage_server_app.db.entities.MortgageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

public interface MortgageRepository extends JpaRepository<MortgageEntity, Long>, JpaSpecificationExecutor<MortgageEntity> {

    @Query(value = "SELECT mortgage_id, loan_type_id, percent, (:requiredPrinciple * percent) / 100 as principle, " +
            "JSON_ARRAYAGG(" +
            "JSON_OBJECT('mortgage_id', mortgage_id, 'percent', percent, 'loanTypeId', loan_type_id, 'principle', (:requiredPrinciple * percent) / 100 , 'numberOfMonths', number_of_months)" +
            ") AS data " +
            "FROM adi_mortgage.Mortgage AS mort " +
            "INNER JOIN adi_mortgage.loans_mortgage AS loans on mort.id = loans.mortgage_id " +
            "GROUP BY mortgage_id",
            nativeQuery = true)
    List<PotentialMortgage> fetchStrategyFor(@Param("requiredPrinciple") Double principle);


}
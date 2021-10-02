package com.ay.mortgage_server_app.db.repositories;

import com.ay.mortgage_server_app.db.entities.MortgageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MortgageRepository extends JpaRepository<MortgageEntity, Long>, JpaSpecificationExecutor<MortgageEntity> {

}
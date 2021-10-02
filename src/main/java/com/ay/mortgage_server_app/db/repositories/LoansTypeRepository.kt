package com.mortgage.server.app.mortgage.server.db.repositories

import com.ay.mortgage_server_app.db.entities.LoansTypeEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository

@Repository
interface LoansTypeRepository : JpaRepository<LoansTypeEntity, Long>, JpaSpecificationExecutor<LoansTypeEntity>
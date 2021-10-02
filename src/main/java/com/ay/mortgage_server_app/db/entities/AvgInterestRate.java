package com.ay.mortgage_server_app.db.entities;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "avg_interest_rate")
public class AvgInterestRate {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "loan_type_id", nullable = false)
    private String loanTypeId;

    @Column(name = "under_45", nullable = false)
    private BigDecimal under45;

    @Column(name = "above_45_below_60", nullable = false)
    private BigDecimal above45Below60;

    @Column(name = "above_60_below_75", nullable = false)
    private BigDecimal above60Below75;

}

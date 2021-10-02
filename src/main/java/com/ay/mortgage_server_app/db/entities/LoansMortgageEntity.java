package com.ay.mortgage_server_app.db.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "loans_mortgage")
public class LoansMortgageEntity {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;


    //@OneToOne(targetEntity = MortgageEntity.class)
    @JoinColumn(name = "mortgage_id", nullable = false)
    public Long mortgageId;

    @OneToOne(targetEntity = LoansTypeEntity.class)
    @JoinColumn(name = "loan_type_id", nullable = false)
    public Long loanTypeId;

    @Basic
    @Column(name = "percent", nullable = false)
    public Double percent;

    @Basic
    @Column(name = "number_of_months", nullable = false)
    public Integer numberOfMonths;

    public Long getId() {
        return id;
    }

    public Long getMortgageId() {
        return mortgageId;
    }

    public Long getLoanTypeId() {
        return loanTypeId;
    }

    public Double getPercent() {
        return percent;
    }

    public Integer getNumberOfMonths() {
        return numberOfMonths;
    }
}

package com.ay.mortgage_server_app.db.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "loans_mortgage")
public class LoansMortgage {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "mortgage_id", nullable = false)
    private Long mortgageId;

    @Column(name = "loan_type_id", nullable = false)
    private Long loanTypeId;

    @Column(name = "percent", nullable = false)
    private String percent;

    @Column(name = "number_of_months", nullable = false)
    private Integer numberOfMonths;

}

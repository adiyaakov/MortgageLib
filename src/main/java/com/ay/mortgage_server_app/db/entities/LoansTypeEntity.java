package com.ay.mortgage_server_app.db.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "loans_type")
public class LoansTypeEntity {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

}

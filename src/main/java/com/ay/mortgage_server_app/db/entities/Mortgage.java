package com.ay.mortgage_server_app.db.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "mortgage")
public class Mortgage {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

}

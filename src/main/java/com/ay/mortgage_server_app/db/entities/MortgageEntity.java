package com.ay.mortgage_server_app.db.entities;

import lombok.Data;
import lombok.Setter;

import javax.persistence.*;

@Data
@Entity
@Setter
@Table(name = "mortgage")
public class MortgageEntity {

    @Id
    @Column(name = "id", nullable = false, unique = true)
//    @JoinColumn(name = "id", updatable = false, insertable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Basic
    @Column(name = "title", nullable = false)
    public String title;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}

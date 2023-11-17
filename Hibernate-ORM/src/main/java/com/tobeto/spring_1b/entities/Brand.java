package com.tobeto.spring_1b.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "brands")
public class Brand {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="country")
    private String country;

    @OneToMany(mappedBy = "brand")
    private List<Car> cars;
}

package com.tobeto.spring_1b.entities;

import jakarta.persistence.*;

import java.util.List;

@Table(name="cars")
@Entity
public class Car {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="model")
    private String model;

    @Column(name="year")
    private int year;

    @Column(name="ready_to_use")
    private boolean readyToUse;

    @Column(name="rental_price")
    private int rentalPrice;

    @ManyToOne
    @JoinColumn(name="brand_id")
    private Brand brand;

    @OneToMany(mappedBy = "car")
    private List<Rental> rental;
}

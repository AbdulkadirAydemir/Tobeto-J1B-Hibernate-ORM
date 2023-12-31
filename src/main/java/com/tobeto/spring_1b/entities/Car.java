package com.tobeto.spring_1b.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name="cars")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
    @JsonIgnore
    private Brand brand;

    @OneToMany(mappedBy = "car")
    @JsonIgnore
    private List<Rental> rental;
}

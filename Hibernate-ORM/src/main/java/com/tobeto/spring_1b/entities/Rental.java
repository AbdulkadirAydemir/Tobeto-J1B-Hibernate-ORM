package com.tobeto.spring_1b.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "rental")
public class Rental {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="start_date")
    private String startDate;

    @Column(name="end_date")
    private String endDate;

    @Column(name="total_price")
    private String totalPrice;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name="car_id")
    private Car car;

    @ManyToOne
    @JoinColumn(name="employee_id")
    private Employee employee;
}

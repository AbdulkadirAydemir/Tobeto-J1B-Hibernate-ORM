package com.tobeto.spring_1b.repositories;

import com.tobeto.spring_1b.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer>{

    // Derived Query Methods

    List<Car> findByNameLike(String name);
    List<Car> findByYearBetween(int year);

    // JPQL

    @Query("SELECT c FROM Car c Where c.name LIKE %:name%")
    List<Car> search(String name);
    @Query("SELECT c FROM Car c Where EXTRACT(YEAR FROM \":year\") = 2023;")
    List<Car> searchYear(int year);
}

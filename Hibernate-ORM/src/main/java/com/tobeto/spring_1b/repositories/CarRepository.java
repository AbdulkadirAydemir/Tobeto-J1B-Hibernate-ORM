package com.tobeto.spring_1b.repositories;

import com.tobeto.spring_1b.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer>{
}

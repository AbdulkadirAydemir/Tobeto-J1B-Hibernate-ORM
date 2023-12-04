package com.tobeto.spring_1b.repositories;

import com.tobeto.spring_1b.entities.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, Integer> {
}

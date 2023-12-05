package com.tobeto.spring_1b.repositories;

import com.tobeto.spring_1b.entities.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RentalRepository extends JpaRepository<Rental, Integer> {

    // Derived Query Methods

    List<Rental> findByStartDateAfter(String startDate);
    List<Rental> findByOrderByTotalPriceDesc(int totalPrice);

    // JPQL

    @Query("SELECT r FROM Rental r WHERE :startDate > CURRENT_DATE")
    List<Rental> search(String startDate);
    @Query("SELECT r FROM Rental r ORDER BY :rentalPrice DESC")
    List<Rental> searchPrice(int totalPrice);
}

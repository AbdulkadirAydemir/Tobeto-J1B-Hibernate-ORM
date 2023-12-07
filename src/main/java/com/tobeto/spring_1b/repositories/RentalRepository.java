package com.tobeto.spring_1b.repositories;

import com.tobeto.spring_1b.entities.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RentalRepository extends JpaRepository<Rental, Integer> {

    // Derived Query Methods

    List<Rental> findByStartDateLike(String startDate);
    List<Rental> findByEndDateLike(String endDate);

    // JPQL

    @Query("SELECT r.startDate FROM Rental r Where r.startDate LIKE %:startDate%")
    List<Rental> search(String startDate);
    @Query("SELECT r.endDate FROM Rental r Where r.endDate LIKE %:endDate%")
    List<Rental> search2(String endDate);
}

package com.tobeto.spring_1b.repositories;

import com.tobeto.spring_1b.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand, Integer> {

    // Derived Query Methods

    List<Brand> findByNameContaining(String name);
    List<Brand> findByCountryStartingWith(String country);

    // JPQL

    @Query("SELECT b FROM Brand b Where b.name LIKE %:name%")
    List<Brand> search(String name);
    @Query("SELECT b FROM Brand b Where b.country LIKE :country%")
    List<Brand> search1(String country);
}

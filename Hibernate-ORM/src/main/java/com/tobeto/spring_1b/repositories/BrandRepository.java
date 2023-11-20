package com.tobeto.spring_1b.repositories;

import com.tobeto.spring_1b.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
}

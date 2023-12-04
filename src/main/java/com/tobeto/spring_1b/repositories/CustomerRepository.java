package com.tobeto.spring_1b.repositories;

import com.tobeto.spring_1b.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}

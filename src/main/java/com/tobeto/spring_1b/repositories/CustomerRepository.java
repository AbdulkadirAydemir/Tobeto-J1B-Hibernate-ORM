package com.tobeto.spring_1b.repositories;

import com.tobeto.spring_1b.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    // Derived Query Methods

    List<Customer> findByNameLike(String name);
    List<Customer> findByAddressLike(String address);

    // JPQL

    @Query("SELECT c FROM Customer c Where c.name LIKE %:name%")
    List<Customer> search(String name);
    @Query("SELECT c FROM Customer c Where c.address LIKE %:address%")
    List<Customer> searchAddress(String address);
}

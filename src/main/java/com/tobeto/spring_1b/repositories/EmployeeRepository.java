package com.tobeto.spring_1b.repositories;

import com.tobeto.spring_1b.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

    // Derived Query Methods

    List<Employee> findByFirstNameLike(String firstName);
    List<Employee> findByLastNameLike(String lastName);

    // JPQL

    @Query("SELECT e.firstName FROM Employee e Where e.firstName LIKE %:firstName%")
    List<Employee> search(String firstName);
    @Query("SELECT e.lastName FROM Employee e Where e.lastName LIKE %:lastName%")
    List<Employee> search2(String lastName);
}

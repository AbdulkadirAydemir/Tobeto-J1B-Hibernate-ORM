package com.tobeto.spring_1b.repositories;

import com.tobeto.spring_1b.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

    // Derived Query Methods

    List<Employee> findByLastnameOrFirstname(String lastName,String firstName);
    List<Employee> findByStartDateBetween(String birthDate);

    // JPQL

    @Query("SELECT CONCAT(:lastName, ' ', :firstName) FROM Employee e")
    List<Employee> search(String lastName,String firstName);
    @Query("SELECT YEAR(CURRENT_DATE) - YEAR(:birthDate) FROM Employee e")
    List<Employee> searchDate(String birthDate);
}

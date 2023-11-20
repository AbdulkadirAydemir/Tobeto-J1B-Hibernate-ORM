package com.tobeto.spring_1b.repositories;

import com.tobeto.spring_1b.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
}

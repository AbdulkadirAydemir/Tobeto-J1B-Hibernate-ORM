package com.tobeto.spring_1b.controllers;

import com.tobeto.spring_1b.entities.Employee;
import com.tobeto.spring_1b.repositories.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employees")
public class EmployeesController {

    private final EmployeeRepository employeeRepository;

    public EmployeesController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping
    public List<Employee> getAll(){return employeeRepository.findAll();}

    @GetMapping("{id}")
    public Employee getById(@PathVariable int id){
        return employeeRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Employee employee){
        employeeRepository.save(employee);
    }

    @PutMapping
    public void update(@RequestBody Employee employee){
        Employee employeeUpdate = employeeRepository.findById(employee.getId()).orElseThrow();
        employeeRepository.save(employeeUpdate);
    }

    @DeleteMapping("{id}")
    public void deleteToId(@PathVariable int id){
        Employee employeeToDelete = employeeRepository.findById(id).orElseThrow();
        employeeRepository.delete(employeeToDelete);
    }
}
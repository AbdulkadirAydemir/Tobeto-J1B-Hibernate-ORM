package com.tobeto.spring_1b.controllers;

import com.tobeto.spring_1b.dtos.requests.employee.AddEmployeeRequest;
import com.tobeto.spring_1b.dtos.requests.employee.UpdateEmployeeRequest;
import com.tobeto.spring_1b.dtos.responses.customer.GetCustomerListResponse;
import com.tobeto.spring_1b.dtos.responses.employee.GetEmployeeListResponse;
import com.tobeto.spring_1b.dtos.responses.employee.GetEmployeeResponse;
import com.tobeto.spring_1b.entities.Brand;
import com.tobeto.spring_1b.entities.Employee;
import com.tobeto.spring_1b.repositories.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/employees")
public class EmployeesController {

    private final EmployeeRepository employeeRepository;

    public EmployeesController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping
    public List<GetEmployeeListResponse> getAll(){
        List<Employee> employees = employeeRepository.findAll();
        List<GetEmployeeListResponse> responseList = new ArrayList<>();

        for (Employee employee : employees) {
            GetEmployeeListResponse response = new GetEmployeeListResponse();
            response.setId(employee.getId());
            response.setFirstName(employee.getFirstName());
            response.setLastName(employee.getLastName());
            response.setBirthDate(employee.getBirthDate());
        }
        return responseList;
    }

    @GetMapping("{id}")
    public GetEmployeeResponse getById(@PathVariable int id){
        Employee employee = employeeRepository.findById(id).orElseThrow();

        GetEmployeeResponse response = new GetEmployeeResponse();
        response.setFirstName(employee.getFirstName());
        response.setLastName(employee.getLastName());
        response.setBirthDate(employee.getBirthDate());
        return response;
    }

    @PostMapping
    public void add(@RequestBody AddEmployeeRequest request){
        Employee employee = new Employee();
        employee.setFirstName(request.getFirstName());
        employee.setLastName(request.getLastName());
        employee.setBirthDate(request.getBirthDate());
        employeeRepository.save(employee);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody UpdateEmployeeRequest updateEmployeeRequest) {
        Employee employee = new Employee();
        employeeRepository.findById(id).orElseThrow();
        employee.setId(updateEmployeeRequest.getId());
        employee.setFirstName(updateEmployeeRequest.getFirstName());
        employee.setLastName(updateEmployeeRequest.getLastName());
        employee.setBirthDate(updateEmployeeRequest.getBirthDate());
        employeeRepository.save(employee);
    }

    @DeleteMapping("{id}")
    public void deleteToId(@PathVariable int id){
        Employee employeeToDelete = employeeRepository.findById(id).orElseThrow();
        employeeRepository.delete(employeeToDelete);
    }
}

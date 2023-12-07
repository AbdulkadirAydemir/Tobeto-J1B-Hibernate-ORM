package com.tobeto.spring_1b.services.abstracts;

import com.tobeto.spring_1b.entities.Employee;
import com.tobeto.spring_1b.services.dtos.requests.employee.AddEmployeeRequest;
import com.tobeto.spring_1b.services.dtos.requests.employee.UpdateEmployeeRequest;
import com.tobeto.spring_1b.services.dtos.responses.employee.GetEmployeeListResponse;
import com.tobeto.spring_1b.services.dtos.responses.employee.GetEmployeeResponse;

import java.util.List;

public interface EmployeeService {
    List<GetEmployeeListResponse> getAll();
    GetEmployeeResponse getById(int id);
    void add(AddEmployeeRequest request);
    void update(int id, UpdateEmployeeRequest updateEmployeeRequest);
    void delete(int id);
    List<GetEmployeeListResponse> getByFirstName(String firstName);
    List<GetEmployeeListResponse> getByLastName(String lastName);
    List<Employee> search(String firstName);
    List<Employee> search2(String lastName);
}

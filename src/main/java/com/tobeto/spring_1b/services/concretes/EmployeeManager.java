package com.tobeto.spring_1b.services.concretes;

import com.tobeto.spring_1b.core.utilities.mappers.ModelMapperManager;
import com.tobeto.spring_1b.core.utilities.mappers.ModelMapperService;
import com.tobeto.spring_1b.entities.Employee;
import com.tobeto.spring_1b.repositories.EmployeeRepository;
import com.tobeto.spring_1b.services.abstracts.EmployeeService;
import com.tobeto.spring_1b.services.dtos.requests.employee.AddEmployeeRequest;
import com.tobeto.spring_1b.services.dtos.requests.employee.UpdateEmployeeRequest;
import com.tobeto.spring_1b.services.dtos.responses.employee.GetEmployeeListResponse;
import com.tobeto.spring_1b.services.dtos.responses.employee.GetEmployeeResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class EmployeeManager implements EmployeeService
{
    private final EmployeeRepository employeeRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetEmployeeListResponse> getAll() {
        List<Employee> employees = employeeRepository.findAll();
        List<GetEmployeeListResponse> responseList = employees.stream().map(employee -> this.modelMapperService.forResponse()
                .map(employee,GetEmployeeListResponse.class)).toList();
        return responseList;
    }

    @Override
    public GetEmployeeResponse getById(int id) {
        Employee employee = employeeRepository.findById(id).orElseThrow();

        GetEmployeeResponse response = new GetEmployeeResponse();
        response.setFirstName(employee.getFirstName());
        response.setLastName(employee.getLastName());
        response.setBirthDate(employee.getBirthDate());
        return response;
    }

    @Override
    public void add(AddEmployeeRequest request) {
        Employee employee = this.modelMapperService.forRequest().map(request,Employee.class);
    }

    @Override
    public void update(int id, UpdateEmployeeRequest updateEmployeeRequest) {
        Employee employee = this.modelMapperService.forRequest().map(updateEmployeeRequest,Employee.class);
    }

    @Override
    public void delete(int id) {
        Employee employeeToDelete = employeeRepository.findById(id).orElseThrow();
        employeeRepository.delete(employeeToDelete);
    }

    @Override
    public List<GetEmployeeListResponse> getByFirstName(String firstName) {
        List<Employee> employees = employeeRepository.findByFirstNameLike(firstName);
        List<GetEmployeeListResponse> response = new ArrayList<>();

        for (Employee employee:employees) {
            response.add(new GetEmployeeListResponse(employee.getFirstName()));
        }
        return response;
    }

    @Override
    public List<GetEmployeeListResponse> getByLastName(String lastName) {
        List<Employee> employees = employeeRepository.findByLastNameLike(lastName);
        List<GetEmployeeListResponse> response = new ArrayList<>();

        for (Employee employee:employees) {
            response.add(new GetEmployeeListResponse(employee.getLastName()));
        }
        return response;
    }

    @Override
    public List<Employee> search(String firstName) {
        return employeeRepository.search(firstName);
    }

    @Override
    public List<Employee> search2(String lastName) {
        return employeeRepository.search2(lastName);
    }
}

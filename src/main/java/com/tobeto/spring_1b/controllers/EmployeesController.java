package com.tobeto.spring_1b.controllers;

import com.tobeto.spring_1b.entities.Employee;
import com.tobeto.spring_1b.services.abstracts.EmployeeService;
import com.tobeto.spring_1b.services.dtos.requests.employee.AddEmployeeRequest;
import com.tobeto.spring_1b.services.dtos.requests.employee.UpdateEmployeeRequest;
import com.tobeto.spring_1b.services.dtos.responses.employee.GetEmployeeListResponse;
import com.tobeto.spring_1b.services.dtos.responses.employee.GetEmployeeResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employees")
@AllArgsConstructor
public class EmployeesController {

    private final EmployeeService employeeService;

    @GetMapping
    public List<GetEmployeeListResponse> getAll(){
        return employeeService.getAll();
    }

    @GetMapping("{id}")
    public GetEmployeeResponse getById(@PathVariable int id){
       return employeeService.getById(id);
    }

    @GetMapping("name")
    public List<GetEmployeeListResponse> getByFullName(@RequestParam String lastName, @RequestParam String firstName) {
        return this.employeeService.getByFullName(lastName,firstName);
    }

    @GetMapping("birth")
    public List<GetEmployeeListResponse> geyByDate(@RequestParam String birthDate){
        return this.employeeService.geyByDate(birthDate);
    }

    @GetMapping("search")
    public List<Employee> search(@RequestParam String lastName, @RequestParam String firstName){
        return this.employeeService.search(lastName,firstName);
    }

    @GetMapping("search/birth")
    public List<Employee> searchDate(@RequestParam String birthDate){
        return this.employeeService.searchDate(birthDate);
    }


    @PostMapping
    public void add(@RequestBody AddEmployeeRequest request){
        employeeService.add(request);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody UpdateEmployeeRequest updateEmployeeRequest) {
        employeeService.update(id, updateEmployeeRequest);
    }

    @DeleteMapping("{id}")
    public void deleteToId(@PathVariable int id){
       employeeService.delete(id);
    }
}
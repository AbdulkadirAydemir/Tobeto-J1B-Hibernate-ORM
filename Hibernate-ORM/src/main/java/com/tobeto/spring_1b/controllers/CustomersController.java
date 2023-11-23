package com.tobeto.spring_1b.controllers;

import com.tobeto.spring_1b.dtos.requests.car.UpdateCarRequest;
import com.tobeto.spring_1b.dtos.requests.customer.AddCustomerRequest;
import com.tobeto.spring_1b.dtos.requests.customer.UpdateCustomerRequest;
import com.tobeto.spring_1b.dtos.responses.customer.GetCustomerListResponse;
import com.tobeto.spring_1b.dtos.responses.customer.GetCustomerResponse;
import com.tobeto.spring_1b.entities.Brand;
import com.tobeto.spring_1b.entities.Customer;
import com.tobeto.spring_1b.repositories.CustomerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/customers")
public class CustomersController {

    private final CustomerRepository customerRepository;

    public CustomersController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping
    public List<GetCustomerListResponse> getAll() {
        List<Customer> customers = customerRepository.findAll();
        List<GetCustomerListResponse> responseList = new ArrayList<>();

        for (Customer customer : customers) {
            GetCustomerListResponse response = new GetCustomerListResponse();
            response.setId(customer.getId());
            response.setName(customer.getName());
            response.setPhone(customer.getPhone());
            response.setEmail(customer.getEmail());
            response.setAddress(customer.getAddress());
            response.setCarLicense(customer.getCarLicense());
            response.setPhone(customer.getPhone());
        }
        return responseList;
    }

    @GetMapping("{id}")
    public GetCustomerResponse getById(@PathVariable int id){
        Customer customer = customerRepository.findById(id).orElseThrow();

        GetCustomerResponse response = new GetCustomerResponse();
        response.setName(customer.getName());
        response.setPhone(customer.getPhone());
        response.setEmail(customer.getEmail());
        response.setAddress(customer.getAddress());
        response.setCarLicense(customer.getCarLicense());
        response.setPhone(customer.getPhone());
        return response;
    }

    @PostMapping
    public void add(@RequestBody AddCustomerRequest request) {
        Customer customer = new Customer();
        customer.setName(request.getName());
        customer.setPhone(request.getPhone());
        customer.setEmail(request.getEmail());
        customer.setAddress(request.getAddress());
        customer.setCarLicense(request.getCarLicense());
        customer.setPhone(request.getPhone());
        customerRepository.save(customer);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody UpdateCustomerRequest updateCustomerRequest) {
        Customer customer = new Customer();
        customerRepository.findById(id).orElseThrow();
        customer.setId(updateCustomerRequest.getId());
        customer.setName(updateCustomerRequest.getName());
        customer.setSurname(updateCustomerRequest.getSurname());
        customer.setAddress(updateCustomerRequest.getAddress());
        customer.setPhone(updateCustomerRequest.getPhone());
        customer.setEmail(updateCustomerRequest.getEmail());
        customer.setCarLicense(updateCustomerRequest.getCarLicense());
        customerRepository.save(customer);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        Customer customerToDelete = customerRepository.findById(id).orElseThrow();
        customerRepository.delete(customerToDelete);
    }
}

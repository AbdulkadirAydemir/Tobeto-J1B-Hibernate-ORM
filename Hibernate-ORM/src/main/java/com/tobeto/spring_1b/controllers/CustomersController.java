package com.tobeto.spring_1b.controllers;

import com.tobeto.spring_1b.entities.Customer;
import com.tobeto.spring_1b.repositories.CustomerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/customers")
public class CustomersController {

    private final CustomerRepository customerRepository;

    public CustomersController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping
    public List<Customer> getAll() {return customerRepository.findAll();}

    @GetMapping("{id}")
    public Customer getById(@PathVariable int id){
        return customerRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Customer customer) {
        customerRepository.save(customer);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody Customer updateCustomer) {
        Customer customerToUpdate = customerRepository.findById(id).orElseThrow();
        customerToUpdate.setName(updateCustomer.getName());
        customerToUpdate.setSurname(updateCustomer.getSurname());
        customerToUpdate.setAddress(updateCustomer.getAddress());
        customerToUpdate.setPhone(updateCustomer.getPhone());
        customerToUpdate.setEmail(updateCustomer.getEmail());
        customerToUpdate.setCarLicense(updateCustomer.getCarLicense());
        customerRepository.save(customerToUpdate);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        Customer customerToDelete = customerRepository.findById(id).orElseThrow();
        customerRepository.delete(customerToDelete);
    }
}

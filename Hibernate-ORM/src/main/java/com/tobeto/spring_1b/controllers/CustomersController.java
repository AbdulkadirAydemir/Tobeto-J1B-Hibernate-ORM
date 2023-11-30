package com.tobeto.spring_1b.controllers;

import com.tobeto.spring_1b.services.abstracts.CustomerService;
import com.tobeto.spring_1b.services.dtos.requests.customer.AddCustomerRequest;
import com.tobeto.spring_1b.services.dtos.requests.customer.UpdateCustomerRequest;
import com.tobeto.spring_1b.services.dtos.responses.customer.GetCustomerListResponse;
import com.tobeto.spring_1b.services.dtos.responses.customer.GetCustomerResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/customers")
@AllArgsConstructor
public class CustomersController {

    private final CustomerService customerService;

    @GetMapping
    public List<GetCustomerListResponse> getAll() {
        return customerService.getAll();
    }

    @GetMapping("{id}")
    public GetCustomerResponse getById(@PathVariable int id){
       return customerService.getById(id);
    }

    @PostMapping
    public void add(@RequestBody AddCustomerRequest request) {
        customerService.add(request);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody UpdateCustomerRequest updateCustomerRequest) {
        customerService.update(id, updateCustomerRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
       customerService.delete(id);
    }
}
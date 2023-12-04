package com.tobeto.spring_1b.services.abstracts;

import com.tobeto.spring_1b.entities.Customer;
import com.tobeto.spring_1b.services.dtos.requests.customer.AddCustomerRequest;
import com.tobeto.spring_1b.services.dtos.requests.customer.UpdateCustomerRequest;
import com.tobeto.spring_1b.services.dtos.responses.customer.GetCustomerListResponse;
import com.tobeto.spring_1b.services.dtos.responses.customer.GetCustomerResponse;

import java.util.List;

public interface CustomerService {
    List<GetCustomerListResponse> getAll();
    GetCustomerResponse getById(int id);
    void add(AddCustomerRequest request);
    void update(int id, UpdateCustomerRequest updateCustomerRequest);
    void delete(int id);
    List<GetCustomerListResponse> getByFullName(String name, String surname);
    List<GetCustomerListResponse> getByAddress(String address);
    List<Customer> search(String name, String surname);
    List<Customer> searchAddress(String address);
}

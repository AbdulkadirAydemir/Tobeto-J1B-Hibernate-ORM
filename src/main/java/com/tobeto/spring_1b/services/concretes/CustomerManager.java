package com.tobeto.spring_1b.services.concretes;

import com.tobeto.spring_1b.core.utilities.mappers.ModelMapperService;
import com.tobeto.spring_1b.entities.Customer;
import com.tobeto.spring_1b.repositories.CustomerRepository;
import com.tobeto.spring_1b.services.abstracts.CustomerService;
import com.tobeto.spring_1b.services.dtos.requests.customer.AddCustomerRequest;
import com.tobeto.spring_1b.services.dtos.requests.customer.UpdateCustomerRequest;
import com.tobeto.spring_1b.services.dtos.responses.customer.GetCustomerListResponse;
import com.tobeto.spring_1b.services.dtos.responses.customer.GetCustomerResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class CustomerManager implements CustomerService
{
    private final CustomerRepository customerRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetCustomerListResponse> getAll() {
        List<Customer> customers = customerRepository.findAll();
        List<GetCustomerListResponse> responseList = customers.stream().map(customer -> this.modelMapperService.forResponse()
                .map(customer, GetCustomerListResponse.class)).toList();
        return responseList;
    }

    @Override
    public GetCustomerResponse getById(int id) {
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

    @Override
    public void add(AddCustomerRequest request) {
       Customer customer = this.modelMapperService.forRequest().map(request,Customer.class);
    }

    @Override
    public void update(int id, UpdateCustomerRequest updateCustomerRequest) {
        Customer customer = this.modelMapperService.forRequest().map(updateCustomerRequest,Customer.class);
    }

    @Override
    public void delete(int id) {
        Customer customerToDelete = customerRepository.findById(id).orElseThrow();
        customerRepository.delete(customerToDelete);
    }

    @Override
    public List<GetCustomerListResponse> getByFullName(String name) {
        List<Customer> customers = customerRepository.findByNameLike(name);
        List<GetCustomerListResponse> response = new ArrayList<>();

        for (Customer customer: customers) {
            response.add(new GetCustomerListResponse(customer.getName()));
        }
        return response;
    }

    @Override
    public List<GetCustomerListResponse> getByAddress(String address) {
        List<Customer> customers = customerRepository.findByAddressLike(address);
        List<GetCustomerListResponse> response = new ArrayList<>();

        for (Customer customer: customers) {
            response.add(new GetCustomerListResponse(customer.getAddress()));
        }
        return response;
    }

    @Override
    public List<Customer> search(String name) {
        return customerRepository.search(name);
    }

    @Override
    public List<Customer> searchAddress(String address) {
        return customerRepository.searchAddress(address);
    }
}

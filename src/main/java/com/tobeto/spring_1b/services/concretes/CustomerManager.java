package com.tobeto.spring_1b.services.concretes;

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

    @Override
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
        Customer customer = new Customer();
        customer.setName(request.getName());
        customer.setPhone(request.getPhone());
        customer.setEmail(request.getEmail());
        customer.setAddress(request.getAddress());
        customer.setCarLicense(request.getCarLicense());
        customer.setPhone(request.getPhone());
        customerRepository.save(customer);
    }

    @Override
    public void update(int id, UpdateCustomerRequest updateCustomerRequest) {
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

    @Override
    public void delete(int id) {
        Customer customerToDelete = customerRepository.findById(id).orElseThrow();
        customerRepository.delete(customerToDelete);
    }

    @Override
    public List<GetCustomerListResponse> getByFullName(String name, String surname) {
        List<Customer> customers = customerRepository.findDistinctNameAndSurname(name,surname);
        List<GetCustomerListResponse> response = new ArrayList<>();

        for (Customer customer: customers) {
            response.add(new GetCustomerListResponse(customer.getName(), customer.getSurname()));
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
    public List<Customer> search(String name, String surname) {
        return customerRepository.search(name,surname);
    }

    @Override
    public List<Customer> searchAddress(String address) {
        return customerRepository.searchAddress(address);
    }
}

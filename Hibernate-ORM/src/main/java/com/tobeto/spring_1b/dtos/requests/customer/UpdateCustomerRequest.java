package com.tobeto.spring_1b.dtos.requests.customer;

import lombok.Data;

@Data
public class UpdateCustomerRequest {
    private int id;
    private String name;
    private int carLicense;
    private String surname;
    private String address;
    private String email;
    private String phone;
}

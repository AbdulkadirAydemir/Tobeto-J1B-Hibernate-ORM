package com.tobeto.spring_1b.services.dtos.responses.customer;

import lombok.Data;

@Data
public class GetCustomerListResponse {
    private int id;
    private String name;
    private int carLicense;
    private String surname;
    private String address;
    private String email;
    private String phone;
}

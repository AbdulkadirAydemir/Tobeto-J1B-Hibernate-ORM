package com.tobeto.spring_1b.services.dtos.responses.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCustomerListResponse {
    private int id;
    private String name;
    private int carLicense;
    private String surname;
    private String address;
    private String email;
    private String phone;

    public GetCustomerListResponse(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public GetCustomerListResponse(String address) {
        this.address = address;
    }
}

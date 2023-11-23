package com.tobeto.spring_1b.dtos.requests.employee;

import lombok.Data;

import java.util.Date;

@Data
public class UpdateEmployeeRequest {
    private int id;
    private String firstName;
    private String lastName;
    private Date birthDate;
}

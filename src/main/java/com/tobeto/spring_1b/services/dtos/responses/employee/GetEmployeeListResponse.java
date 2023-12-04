package com.tobeto.spring_1b.dtos.responses.employee;

import lombok.Data;

import java.util.Date;

@Data
public class GetEmployeeListResponse {
    private int id;
    private String firstName;
    private String lastName;
    private Date birthDate;
}

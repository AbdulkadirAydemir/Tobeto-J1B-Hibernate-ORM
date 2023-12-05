package com.tobeto.spring_1b.services.dtos.responses.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetEmployeeListResponse {
    private int id;
    private String firstName;
    private String lastName;
    private Date birthDate;

    public GetEmployeeListResponse(String lastName, String firstName) {
    }

    public GetEmployeeListResponse(Date birthDate) {
    }
}

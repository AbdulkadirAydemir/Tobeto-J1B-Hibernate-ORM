package com.tobeto.spring_1b.dtos.requests.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddEmployeeRequest {
    private String firstName;
    private String lastName;
    private Date birthDate;
}

package com.tobeto.spring_1b.services.dtos.requests.employee;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddEmployeeRequest {
    @NotBlank(message = "Çalışan adı boş olamaz.") // multi-language
    @Size(min = 3, max = 30, message = "Çalışan adı 3 ile 30 hane arasında olmalıdır.")
    private String firstName;
    @NotBlank(message = "Çalışan soyadı boş olamaz.") // multi-language
    @Size(min = 3, max = 30, message = "Çalışan soyadı 3 ile 30 hane arasında olmalıdır.")
    private String lastName;
    private Date birthDate;
}

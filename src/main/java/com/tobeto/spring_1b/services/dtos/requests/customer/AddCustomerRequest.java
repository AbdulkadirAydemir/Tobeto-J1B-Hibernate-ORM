package com.tobeto.spring_1b.services.dtos.requests.customer;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCustomerRequest {
    @NotBlank(message = "Müşteri adı boş olamaz.") // multi-language
    @Size(min = 3, max = 30, message = "Müşteri adı 3 ile 30 hane arasında olmalıdır.")
    private String name;
    @NotBlank(message = "Müşteri ehliyeti bilgisi boş olamaz")
    private int carLicense;
    private String surname;
    private String address;
    private String email;
    private String phone;
}

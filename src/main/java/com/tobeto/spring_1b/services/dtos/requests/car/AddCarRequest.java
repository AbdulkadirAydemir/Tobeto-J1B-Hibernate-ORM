package com.tobeto.spring_1b.services.dtos.requests.car;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCarRequest {
    @NotBlank(message = "Araba adı boş olamaz.") // multi-language
    @Size(min = 2, max = 20, message = "Araba adı 2 ile 20 hane arasında olmalıdır.")
    private String name;
    @NotBlank(message = "Model adı boş olamaz.") // multi-language
    @Size(min = 1, max = 20, message = "Model adı 1 ile 20 hane arasında olmalıdır.")
    private String model;
    @NotBlank(message = "Araba yılı boş olamaz")
    @DecimalMin(value = "2000", message = "Yıl 2000 ve üzeri olmalıdır.")
    private int year;
    private boolean readyToUse;
    private int rentalPrice;
}

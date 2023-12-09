package com.tobeto.spring_1b.services.dtos.requests.brand;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddBrandRequest {
    @NotBlank(message = "Marka ismi boş olamaz.")
    @Size(min = 3, max = 20, message = "Marka ismi 3 ile 20 karakter arasında olmalıdır.")
    private String name;
    @NotBlank(message = "Ülke adı boş olamaz.") // multi-language
    @Size(min = 3, max = 20, message = "Ülke adı 3 ile 20 hane arasında olmalıdır.")
    private String country;
}

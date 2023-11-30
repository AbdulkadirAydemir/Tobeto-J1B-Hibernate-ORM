package com.tobeto.spring_1b.services.dtos.requests.brand;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddBrandRequest {
    private String name;
    private String country;
}

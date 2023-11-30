package com.tobeto.spring_1b.services.dtos.requests.brand;

import lombok.Data;

@Data
public class UpdateBrandRequest {
    private int id;
    private String name;
    private String country;
}

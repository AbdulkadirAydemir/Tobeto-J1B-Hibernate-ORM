package com.tobeto.spring_1b.dtos.requests.brand;

import lombok.Data;

@Data
public class UpdateBrandRequest {
    private int id;
    private String name;
    private String country;
}

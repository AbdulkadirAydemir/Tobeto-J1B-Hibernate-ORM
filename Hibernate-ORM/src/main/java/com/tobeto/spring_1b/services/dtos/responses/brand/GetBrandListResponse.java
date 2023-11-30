package com.tobeto.spring_1b.services.dtos.responses.brand;

import lombok.Data;

@Data
public class GetBrandListResponse {
    private int id;
    private String name;
    private String country;
}

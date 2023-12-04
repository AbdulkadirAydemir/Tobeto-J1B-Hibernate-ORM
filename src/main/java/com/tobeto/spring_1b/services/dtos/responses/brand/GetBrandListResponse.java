package com.tobeto.spring_1b.services.dtos.responses.brand;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetBrandListResponse {
    private int id;
    private String name;
    private String country;

    public GetBrandListResponse(String name) {
        this.name = name;
    }
}


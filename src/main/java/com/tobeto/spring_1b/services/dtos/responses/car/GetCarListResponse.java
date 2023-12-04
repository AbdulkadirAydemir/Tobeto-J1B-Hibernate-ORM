package com.tobeto.spring_1b.services.dtos.responses.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCarListResponse {
    private int id;
    private String name;
    private String model;
    private int year;
    private boolean readyToUse;
    private int rentalPrice;

    public GetCarListResponse(String name) {
        this.name = name;
    }
    public GetCarListResponse(int year) {
        this.year = year;
    }
}

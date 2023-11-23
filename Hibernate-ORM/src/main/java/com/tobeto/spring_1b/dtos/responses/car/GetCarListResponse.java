package com.tobeto.spring_1b.dtos.responses.car;

import lombok.Data;

@Data
public class GetCarListResponse {
    private int id;
    private String name;
    private String model;
    private int year;
    private boolean readyToUse;
    private int rentalPrice;
}

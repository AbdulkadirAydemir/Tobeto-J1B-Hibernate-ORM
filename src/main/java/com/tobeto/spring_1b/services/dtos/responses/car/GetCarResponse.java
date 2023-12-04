package com.tobeto.spring_1b.dtos.responses.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCarResponse {
    private String name;
    private String model;
    private int year;
    private boolean readyToUse;
    private int rentalPrice;
}

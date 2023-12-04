package com.tobeto.spring_1b.services.dtos.requests.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCarRequest {
    private String name;
    private String model;
    private int year;
    private boolean readyToUse;
    private int rentalPrice;
}

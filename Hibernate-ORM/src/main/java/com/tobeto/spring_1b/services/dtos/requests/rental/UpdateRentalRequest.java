package com.tobeto.spring_1b.services.dtos.requests.rental;

import lombok.Data;

@Data
public class UpdateRentalRequest {
    private int id;
    private String startDate;
    private String endDate;
    private String totalPrice;
}

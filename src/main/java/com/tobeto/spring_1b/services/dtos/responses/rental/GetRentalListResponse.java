package com.tobeto.spring_1b.services.dtos.responses.rental;

import lombok.Data;

@Data
public class GetRentalListResponse {
    private int id;
    private String startDate;
    private String endDate;
    private String totalPrice;
}

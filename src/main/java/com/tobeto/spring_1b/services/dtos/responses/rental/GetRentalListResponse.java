package com.tobeto.spring_1b.services.dtos.responses.rental;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetRentalListResponse {
    private int id;
    private String startDate;
    private String endDate;
    private int totalPrice;

    public GetRentalListResponse(String startDate) {
    }

    public GetRentalListResponse(int totalPrice) {
    }
}

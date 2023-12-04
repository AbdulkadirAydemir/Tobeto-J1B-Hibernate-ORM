package com.tobeto.spring_1b.dtos.requests.rental;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddRentalRequest {
    private String startDate;
    private String endDate;
    private String totalPrice;
}

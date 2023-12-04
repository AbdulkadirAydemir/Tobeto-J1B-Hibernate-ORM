package com.tobeto.spring_1b.dtos.responses.rental;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetRentalResponse {
    private String startDate;
    private String endDate;
    private String totalPrice;
}

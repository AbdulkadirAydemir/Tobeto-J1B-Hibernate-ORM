package com.tobeto.spring_1b.services.dtos.requests.rental;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddRentalRequest {
    @NotNull(message = "Kiralama başlangıç tarihi boş olamaz.")
    @Future(message = "Kiralama başlangıç tarihi ileri bir tarih olmalıdır")
    private String startDate;
    @NotNull(message = "Kiralama bitiş tarihi boş olamaz.")
    @Future(message = "Kiralama bitiş tarihi ileri bir tarih olmalıdır")
    private String endDate;
    private String totalPrice;
}

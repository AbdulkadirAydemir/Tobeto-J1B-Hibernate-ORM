package com.tobeto.spring_1b.services.abstracts;

import com.tobeto.spring_1b.entities.Rental;
import com.tobeto.spring_1b.services.dtos.requests.rental.AddRentalRequest;
import com.tobeto.spring_1b.services.dtos.requests.rental.UpdateRentalRequest;
import com.tobeto.spring_1b.services.dtos.responses.rental.GetRentalListResponse;
import com.tobeto.spring_1b.services.dtos.responses.rental.GetRentalResponse;

import java.util.List;

public interface RentalService {
    List<GetRentalListResponse> getAll();
    GetRentalResponse getById(int id);
    void add(AddRentalRequest request);
    void update(int id, UpdateRentalRequest updateRentalRequest);
    void delete(int id);
    List<GetRentalListResponse> getByStartDateAfter(String startDate);
    List<GetRentalListResponse> getByTotalPriceDesc(int totalPrice);
    List<Rental> search(String startDate);
    List<Rental> searchPrice(int totalPrice);
}

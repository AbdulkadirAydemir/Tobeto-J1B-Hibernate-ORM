package com.tobeto.spring_1b.services.concretes;

import com.tobeto.spring_1b.entities.Rental;
import com.tobeto.spring_1b.repositories.RentalRepository;
import com.tobeto.spring_1b.services.abstracts.RentalService;
import com.tobeto.spring_1b.services.dtos.requests.rental.AddRentalRequest;
import com.tobeto.spring_1b.services.dtos.requests.rental.UpdateRentalRequest;
import com.tobeto.spring_1b.services.dtos.responses.rental.GetRentalListResponse;
import com.tobeto.spring_1b.services.dtos.responses.rental.GetRentalResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class RentalManager implements RentalService
{
    private final RentalRepository rentalRepository;

    @Override
    public List<GetRentalListResponse> getAll() {
        List<Rental> rentals = rentalRepository.findAll();
        List<GetRentalListResponse> responseList = new ArrayList<>();

        for (Rental rental : rentals) {
            GetRentalListResponse response = new GetRentalListResponse();
            response.setId(rental.getId());
            response.setStartDate(rental.getStartDate());
            response.setEndDate(rental.getEndDate());
            response.setTotalPrice(rental.getTotalPrice());
        }
        return responseList;
    }

    @Override
    public GetRentalResponse getById(int id) {
        Rental rental = rentalRepository.findById(id).orElseThrow();

        GetRentalResponse response = new GetRentalResponse();
        response.setStartDate(rental.getStartDate());
        response.setEndDate(rental.getEndDate());
        response.setTotalPrice(rental.getTotalPrice());
        return response;
    }

    @Override
    public void add(AddRentalRequest request) {
        Rental rental = new Rental();
        rental.setStartDate(request.getStartDate());
        rental.setEndDate(request.getEndDate());
        rental.setTotalPrice(request.getTotalPrice());
        rentalRepository.save(rental);
    }

    @Override
    public void update(int id, UpdateRentalRequest updateRentalRequest) {
        Rental rental = new Rental();
        rentalRepository.findById(id).orElseThrow();
        rental.setId(updateRentalRequest.getId());
        rental.setStartDate(updateRentalRequest.getStartDate());
        rental.setEndDate(updateRentalRequest.getEndDate());
        rental.setTotalPrice(updateRentalRequest.getTotalPrice());
        rentalRepository.save(rental);
    }

    @Override
    public void delete(int id) {
        Rental rentalToDelete = rentalRepository.findById(id).orElseThrow();
        rentalRepository.delete(rentalToDelete);
    }
}

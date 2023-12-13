package com.tobeto.spring_1b.services.concretes;

import com.tobeto.spring_1b.core.utilities.mappers.ModelMapperService;
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
    private ModelMapperService modelMapperService;

    @Override
    public List<GetRentalListResponse> getAll() {
        List<Rental> rentals = rentalRepository.findAll();
        List<GetRentalListResponse> responseList = rentals.stream().map(rental -> this.modelMapperService.forResponse()
                .map(rental,GetRentalListResponse.class)).toList();
        return responseList;
    }

    @Override
    public GetRentalResponse getById(int id) {
        Rental rental = rentalRepository.findById(id).orElseThrow();

        GetRentalResponse response = this.modelMapperService.forResponse().map(rental,GetRentalResponse.class);
        return response;
    }

    @Override
    public void add(AddRentalRequest request) {
        Rental rental = this.modelMapperService.forRequest().map(request,Rental.class);
    }

    @Override
    public void update(int id, UpdateRentalRequest updateRentalRequest) {
        Rental rental = this.modelMapperService.forRequest().map(updateRentalRequest,Rental.class);
    }

    @Override
    public void delete(int id) {
        Rental rentalToDelete = rentalRepository.findById(id).orElseThrow();
        rentalRepository.delete(rentalToDelete);
    }

    @Override
    public List<GetRentalListResponse> getByStartDate(String startDate) {
        List<Rental> rentals = rentalRepository.findByStartDateLike(startDate);
        List<GetRentalListResponse> response = new ArrayList<>();

        for (Rental rental:rentals) {
            response.add(new GetRentalListResponse(rental.getStartDate()));
        }
        return response;
    }

    @Override
    public List<GetRentalListResponse> getByEndDate(String endDate) {
        List<Rental> rentals = rentalRepository.findByEndDateLike(endDate);
        List<GetRentalListResponse> response = new ArrayList<>();

        for (Rental rental:rentals) {
            response.add(new GetRentalListResponse(rental.getTotalPrice()));
        }
        return response;
    }

    @Override
    public List<Rental> search(String startDate) {
        return rentalRepository.search(startDate);
    }

    @Override
    public List<Rental> search2(String endDate) {
        return rentalRepository.search2(endDate);
    }
}

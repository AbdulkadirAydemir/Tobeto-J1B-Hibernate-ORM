package com.tobeto.spring_1b.controllers;

import com.tobeto.spring_1b.dtos.requests.rental.AddRentalRequest;
import com.tobeto.spring_1b.dtos.requests.rental.UpdateRentalRequest;
import com.tobeto.spring_1b.dtos.responses.rental.GetRentalListResponse;
import com.tobeto.spring_1b.dtos.responses.rental.GetRentalResponse;
import com.tobeto.spring_1b.entities.Rental;
import com.tobeto.spring_1b.repositories.RentalRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/rentals")
public class RentalsController {

    private final RentalRepository rentalRepository;

    public RentalsController(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    @GetMapping
    public List<GetRentalListResponse> getAll(){
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

    @GetMapping("{id}")
    public GetRentalResponse getById(@PathVariable int id){
        Rental rental = rentalRepository.findById(id).orElseThrow();

        GetRentalResponse response = new GetRentalResponse();
        response.setStartDate(rental.getStartDate());
        response.setEndDate(rental.getEndDate());
        response.setTotalPrice(rental.getTotalPrice());
        return response;
    }

    @PostMapping
    public void add(@RequestBody AddRentalRequest request){
        Rental rental = new Rental();
        rental.setStartDate(request.getStartDate());
        rental.setEndDate(request.getEndDate());
        rental.setTotalPrice(request.getTotalPrice());
        rentalRepository.save(rental);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody UpdateRentalRequest updateRentalRequest) {
        Rental rental = new Rental();
        rentalRepository.findById(id).orElseThrow();
        rental.setId(updateRentalRequest.getId());
        rental.setStartDate(updateRentalRequest.getStartDate());
        rental.setEndDate(updateRentalRequest.getEndDate());
        rental.setTotalPrice(updateRentalRequest.getTotalPrice());
        rentalRepository.save(rental);
    }

    @DeleteMapping("{id}")
    public void deleteToId(@PathVariable int id){
        Rental rentalToDelete = rentalRepository.findById(id).orElseThrow();
        rentalRepository.delete(rentalToDelete);
    }
}

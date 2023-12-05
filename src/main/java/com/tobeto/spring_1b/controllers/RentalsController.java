package com.tobeto.spring_1b.controllers;

import com.tobeto.spring_1b.entities.Rental;
import com.tobeto.spring_1b.services.abstracts.RentalService;
import com.tobeto.spring_1b.services.dtos.requests.rental.AddRentalRequest;
import com.tobeto.spring_1b.services.dtos.requests.rental.UpdateRentalRequest;
import com.tobeto.spring_1b.services.dtos.responses.rental.GetRentalListResponse;
import com.tobeto.spring_1b.services.dtos.responses.rental.GetRentalResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/rentals")
@AllArgsConstructor
public class RentalsController {

    private final RentalService rentalService;

    @GetMapping
    public List<GetRentalListResponse> getAll(){
        return rentalService.getAll();
    }

    @GetMapping("{id}")
    public GetRentalResponse getById(@PathVariable int id){
        return rentalService.getById(id);
    }

    @GetMapping("date")
    public List<GetRentalListResponse> getByStartDateAfter(@RequestParam String startDate){
        return this.rentalService.getByStartDateAfter(startDate);
    }

    @GetMapping("price")
    public List<GetRentalListResponse> getByTotalPriceDesc(@RequestParam int totalPrice){
        return this.rentalService.getByTotalPriceDesc(totalPrice);
    }

    @GetMapping("search")
    public List<Rental> search(@RequestParam String startDate){
        return this.rentalService.search(startDate);
    }

    @GetMapping("search/price")
    public List<Rental> searchPrice(@RequestParam int totalPrice){
        return this.rentalService.searchPrice(totalPrice);
    }

    @PostMapping
    public void add(@RequestBody AddRentalRequest request){
        rentalService.add(request);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody UpdateRentalRequest updateRentalRequest) {
        rentalService.update(id, updateRentalRequest);
    }

    @DeleteMapping("{id}")
    public void deleteToId(@PathVariable int id){
        rentalService.delete(id);
    }
}
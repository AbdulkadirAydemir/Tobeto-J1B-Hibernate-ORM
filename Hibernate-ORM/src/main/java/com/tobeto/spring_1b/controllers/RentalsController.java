package com.tobeto.spring_1b.controllers;

import com.tobeto.spring_1b.entities.Rental;
import com.tobeto.spring_1b.repositories.RentalRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/rentals")
public class RentalsController {

    private final RentalRepository rentalRepository;

    public RentalsController(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    @GetMapping
    public List<Rental> getAll(){return rentalRepository.findAll();}

    @GetMapping("{id}")
    public Rental getById(@PathVariable int id){
        return  rentalRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Rental rental){
        rentalRepository.save(rental);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody Rental updateRental) {
        Rental rentalToUpdate = rentalRepository.findById(id).orElseThrow();
        rentalToUpdate.setStartDate(updateRental.getStartDate());
        rentalToUpdate.setEndDate(updateRental.getEndDate());
        rentalToUpdate.setTotalPrice(updateRental.getTotalPrice());
        rentalRepository.save(rentalToUpdate);
    }

    @DeleteMapping("{id}")
    public void deleteToId(@PathVariable int id){
        Rental rentalToDelete = rentalRepository.findById(id).orElseThrow();
        rentalRepository.delete(rentalToDelete);
    }
}

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

    @PutMapping
    public void update(@RequestBody Rental rental){
        Rental rentalUpdate = rentalRepository.findById(rental.getId()).orElseThrow();
        rentalRepository.save(rentalUpdate);
    }

    @DeleteMapping("{id}")
    public void deleteToId(@PathVariable int id){
        Rental rentalToDelete = rentalRepository.findById(id).orElseThrow();
        rentalRepository.delete(rentalToDelete);
    }
}
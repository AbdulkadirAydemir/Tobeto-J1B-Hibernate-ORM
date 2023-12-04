package com.tobeto.spring_1b.controllers;

import com.tobeto.spring_1b.entities.Car;
import com.tobeto.spring_1b.repositories.CarRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cars")
public class CarsController {

    private final CarRepository carRepository;

    public CarsController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping
    public List<Car> getAll() {return carRepository.findAll();}

    @GetMapping("{id}")
    public Car getById(@PathVariable int id) {
        return carRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Car car){
        carRepository.save(car);
    }

    @PutMapping
    public void update(@RequestBody Car car) {
        Car carUpdate = carRepository.findById(car.getId()).orElseThrow();
        carRepository.save(carUpdate);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        Car carToDelete = carRepository.findById(id).orElseThrow();
        carRepository.delete(carToDelete);
    }
}
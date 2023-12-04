package com.tobeto.spring_1b.controllers;

import com.tobeto.spring_1b.entities.Car;
import com.tobeto.spring_1b.services.abstracts.CarService;
import com.tobeto.spring_1b.services.dtos.requests.car.AddCarRequest;
import com.tobeto.spring_1b.services.dtos.requests.car.UpdateCarRequest;
import com.tobeto.spring_1b.services.dtos.responses.car.GetCarListResponse;
import com.tobeto.spring_1b.services.dtos.responses.car.GetCarResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cars")
@AllArgsConstructor
public class CarsController {

    private final CarService carService;

    @GetMapping
    public List<GetCarListResponse> getAll() {
      return carService.getAll();
    }

    @GetMapping("{id}")
    public GetCarResponse getById(@PathVariable int id) {
        return carService.getById(id);
    }

    @GetMapping("name")
    public List<GetCarListResponse> getByName(@RequestParam String name) {
        return this.carService.getByName(name);
    }

    @GetMapping("year")
    public List<GetCarListResponse> getByYear(@RequestParam int year){
        return this.carService.getByYear(year);
    }

    @GetMapping("search")
    public List<Car> search(@RequestParam String name){
        return this.carService.search(name);
    }

    @GetMapping("search/year")
    public List<Car> searchYear(@RequestParam int year){
        return this.carService.searchYear(year);
    }

    @PostMapping
    public void add(@RequestBody AddCarRequest request){
        carService.add(request);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody UpdateCarRequest updateCarRequest) {
        carService.update(id, updateCarRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        carService.delete(id);
    }
}
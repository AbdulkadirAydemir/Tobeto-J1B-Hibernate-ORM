package com.tobeto.spring_1b.controllers;

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
package com.tobeto.spring_1b.controllers;

import com.tobeto.spring_1b.dtos.requests.car.AddCarRequest;
import com.tobeto.spring_1b.dtos.requests.car.UpdateCarRequest;
import com.tobeto.spring_1b.dtos.responses.car.GetCarListResponse;
import com.tobeto.spring_1b.dtos.responses.car.GetCarResponse;
import com.tobeto.spring_1b.entities.Brand;
import com.tobeto.spring_1b.entities.Car;
import com.tobeto.spring_1b.repositories.CarRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/cars")
public class CarsController {

    private final CarRepository carRepository;

    public CarsController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping
    public List<GetCarListResponse> getAll() {
      List<Car> cars = carRepository.findAll();
      List<GetCarListResponse> responseList = new ArrayList<>();

      for (Car car : cars){
          GetCarListResponse response = new GetCarListResponse();
          response.setId(car.getId());
          response.setYear(car.getYear());
          response.setName(car.getName());
          response.setModel(car.getModel());
          response.setReadyToUse(car.isReadyToUse());
          response.setRentalPrice(car.getRentalPrice());
      }
      return responseList;
    }

    @GetMapping("{id}")
    public GetCarResponse getById(@PathVariable int id) {
        Car car = carRepository.findById(id).orElseThrow();

        GetCarResponse response = new GetCarResponse();
        response.setYear(car.getYear());
        response.setName(car.getName());
        response.setModel(car.getModel());
        response.setReadyToUse(car.isReadyToUse());
        response.setRentalPrice(car.getRentalPrice());

        return response;
    }

    @PostMapping
    public void add(@RequestBody AddCarRequest request){
        Car car = new Car();
        car.setYear(request.getYear());
        car.setName(request.getName());
        car.setModel(request.getModel());
        car.setReadyToUse(request.isReadyToUse());
        car.setRentalPrice(request.getRentalPrice());
        carRepository.save(car);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody UpdateCarRequest updateCarRequest) {
        Car car = new Car();
        carRepository.findById(id).orElseThrow();
        car.setId(updateCarRequest.getId());
        car.setName(updateCarRequest.getName());
        car.setModel(updateCarRequest.getModel());
        car.setYear(updateCarRequest.getYear());
        car.setReadyToUse(updateCarRequest.isReadyToUse());
        car.setRentalPrice(updateCarRequest.getRentalPrice());
        carRepository.save(car);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        Car carToDelete = carRepository.findById(id).orElseThrow();
        carRepository.delete(carToDelete);
    }
}

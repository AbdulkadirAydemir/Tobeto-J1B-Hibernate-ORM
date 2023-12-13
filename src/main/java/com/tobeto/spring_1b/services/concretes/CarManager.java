package com.tobeto.spring_1b.services.concretes;

import com.tobeto.spring_1b.core.utilities.mappers.ModelMapperService;
import com.tobeto.spring_1b.entities.Car;
import com.tobeto.spring_1b.repositories.CarRepository;
import com.tobeto.spring_1b.services.abstracts.CarService;
import com.tobeto.spring_1b.services.dtos.requests.car.AddCarRequest;
import com.tobeto.spring_1b.services.dtos.requests.car.UpdateCarRequest;
import com.tobeto.spring_1b.services.dtos.responses.car.GetCarListResponse;
import com.tobeto.spring_1b.services.dtos.responses.car.GetCarResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class CarManager implements CarService
{
    private final CarRepository carRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetCarListResponse> getAll() {
        List<Car> cars = carRepository.findAll();
        List<GetCarListResponse> responseList = cars.stream().map(car -> this.modelMapperService.forResponse()
                .map(car, GetCarListResponse.class)).toList();
        return responseList;
    }

    @Override
    public GetCarResponse getById(int id) {
        Car car = carRepository.findById(id).orElseThrow();

        GetCarResponse response = new GetCarResponse();
        response.setYear(car.getYear());
        response.setName(car.getName());
        response.setModel(car.getModel());
        response.setReadyToUse(car.isReadyToUse());
        response.setRentalPrice(car.getRentalPrice());

        return response;
    }

    @Override
    public void add(AddCarRequest request) {
        Car car = this.modelMapperService.forRequest().map(request,Car.class);
    }

    @Override
    public void update(int id, UpdateCarRequest updateCarRequest) {
        Car car = this.modelMapperService.forRequest().map(updateCarRequest,Car.class);
    }

    @Override
    public void delete(int id) {
        Car carToDelete = carRepository.findById(id).orElseThrow();
        carRepository.delete(carToDelete);
    }

    @Override
    public List<GetCarListResponse> getByName(String name) {
        List<Car> cars = carRepository.findByNameLike("%" + name + "%");
        List<GetCarListResponse> response = new ArrayList<>();

        for (Car car : cars) {
            response.add(new GetCarListResponse(car.getName()));
        }
        return response;
    }

    @Override
    public List<GetCarListResponse> getByYear(int year) {
        List<Car> cars = carRepository.findByYearLike(year);
        List<GetCarListResponse> response = new ArrayList<>();

        for (Car car : cars) {
            response.add(new GetCarListResponse(car.getYear()));
        }
        return response;
    }

    @Override
    public List<Car> search(String name) {
        return carRepository.search(name);
    }

    @Override
    public List<Car> searchYear(int year) {
        return carRepository.searchYear(year);
    }
}

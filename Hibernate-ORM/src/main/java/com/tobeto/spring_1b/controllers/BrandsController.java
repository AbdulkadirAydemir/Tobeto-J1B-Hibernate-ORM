package com.tobeto.spring_1b.controllers;

import com.tobeto.spring_1b.dtos.requests.brand.AddBrandRequest;
import com.tobeto.spring_1b.dtos.requests.brand.UpdateBrandRequest;
import com.tobeto.spring_1b.dtos.responses.brand.GetBrandListResponse;
import com.tobeto.spring_1b.dtos.responses.brand.GetBrandResponse;
import com.tobeto.spring_1b.entities.Brand;
import com.tobeto.spring_1b.repositories.BrandRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/brands")
public class BrandsController {

    private final BrandRepository brandRepository;

    public BrandsController(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @GetMapping
    public List<GetBrandListResponse> getAll() {
        List<Brand> brands = brandRepository.findAll();
        List<GetBrandListResponse> responseList = new ArrayList<>();

        for (Brand brand : brands) {
            GetBrandListResponse response = new GetBrandListResponse();
            response.setId(brand.getId());
            response.setName(brand.getName());
            response.setCountry(brand.getCountry());
            responseList.add(response);
        }
        return responseList;
    }


    @GetMapping("{id}")
    public GetBrandResponse getById(@PathVariable int id) {
        Brand brand = brandRepository.findById(id).orElseThrow();

        GetBrandResponse response = new GetBrandResponse();
        response.setName(brand.getName());
        response.setCountry(brand.getCountry());
        return response;
    }

    @PostMapping
    public void add(@RequestBody AddBrandRequest request){
        Brand brand = new Brand();
        brand.setName(request.getName());
        brand.setCountry(request.getCountry());
        brandRepository.save(brand);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody UpdateBrandRequest updateBrandRequest) {
        Brand brand = new Brand();
        brandRepository.findById(brand.getId()).orElseThrow();
        brand.setId(updateBrandRequest.getId());
        brand.setName(updateBrandRequest.getName());
        brand.setCountry(updateBrandRequest.getCountry());
        brandRepository.save(brand);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        Brand brandToDelete = brandRepository.findById(id).orElseThrow();
        brandRepository.delete(brandToDelete);
    }
}

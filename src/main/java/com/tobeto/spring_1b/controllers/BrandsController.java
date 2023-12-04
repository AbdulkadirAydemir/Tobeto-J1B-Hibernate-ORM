package com.tobeto.spring_1b.controllers;

import com.tobeto.spring_1b.entities.Brand;
import com.tobeto.spring_1b.services.abstracts.BrandService;
import com.tobeto.spring_1b.services.dtos.requests.brand.AddBrandRequest;
import com.tobeto.spring_1b.services.dtos.requests.brand.UpdateBrandRequest;
import com.tobeto.spring_1b.services.dtos.responses.brand.GetBrandListResponse;
import com.tobeto.spring_1b.services.dtos.responses.brand.GetBrandResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/brands")
@AllArgsConstructor
public class BrandsController {

    private final BrandService brandService;

    @GetMapping
    public List<GetBrandListResponse> getAll() {
        return brandService.getAll();
    }

    @GetMapping("{id}")
    public GetBrandResponse getById(@PathVariable int id) {
        return brandService.getById(id);
    }

    @GetMapping("name")
    public List<GetBrandListResponse> getByName(@RequestParam String name)
    {
        return this.brandService.getByName(name);
    }

    @GetMapping("country")
    public List<GetBrandListResponse> getByCountry(@RequestParam String country)
    {
        return this.brandService.getByCountry(country);
    }

    @GetMapping("search")
    public List<Brand> search(@RequestParam String name){
        return this.brandService.search(name);
    }

    @GetMapping("search/country")
    public List<Brand> search1(@RequestParam String country){
        return this.brandService.search1(country);
    }

    @PostMapping
    public void add(@RequestBody AddBrandRequest request){
        brandService.add(request);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody UpdateBrandRequest updateBrandRequest) {
        brandService.update(id,updateBrandRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
       brandService.delete(id);
    }
}
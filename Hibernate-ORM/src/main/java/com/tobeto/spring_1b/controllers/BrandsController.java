package com.tobeto.spring_1b.controllers;

import com.tobeto.spring_1b.entities.Brand;
import com.tobeto.spring_1b.repositories.BrandRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/brands")
public class BrandsController {

    private final BrandRepository brandRepository;

    public BrandsController(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @GetMapping
    public List<Brand> getAll() {return brandRepository.findAll();}

    @GetMapping("{id}")
    public Brand getById(@PathVariable int id) {
        return brandRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody  Brand brand){
        brandRepository.save(brand);
    }

    @PutMapping("{id}")
    public void update(@RequestBody Brand brand) {
        Brand brandUpdate = brandRepository.findById(brand.getId()).orElseThrow();
        brandRepository.save(brandUpdate);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        Brand brandToDelete = brandRepository.findById(id).orElseThrow();
        brandRepository.delete(brandToDelete);
    }
}
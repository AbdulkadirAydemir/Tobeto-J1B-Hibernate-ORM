package com.tobeto.spring_1b.services.concretes;

import com.tobeto.spring_1b.core.utilities.mappers.ModelMapperService;
import com.tobeto.spring_1b.entities.Brand;
import com.tobeto.spring_1b.repositories.BrandRepository;
import com.tobeto.spring_1b.services.abstracts.BrandService;
import com.tobeto.spring_1b.services.dtos.requests.brand.AddBrandRequest;
import com.tobeto.spring_1b.services.dtos.requests.brand.UpdateBrandRequest;
import com.tobeto.spring_1b.services.dtos.responses.brand.GetBrandListResponse;
import com.tobeto.spring_1b.services.dtos.responses.brand.GetBrandResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {
    private final BrandRepository brandRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetBrandListResponse> getAll() {
        List<Brand> brands = brandRepository.findAll();

        List<GetBrandListResponse> responseList = brands.stream().map(brand -> this.modelMapperService.forResponse()
                .map(brand, GetBrandListResponse.class)).toList();

        return responseList;
    }

    @Override
    public GetBrandResponse getById(int id) {
        Brand brand = brandRepository.findById(id).orElseThrow();

        GetBrandResponse response = this.modelMapperService.forResponse().map(brand,GetBrandResponse.class);
        return response;
    }

    @Override
    public void add(AddBrandRequest request) {
        Brand brand = this.modelMapperService.forRequest().map(request, Brand.class);
        this.brandRepository.save(brand);
    }

    @Override
    public void update(int id, UpdateBrandRequest updateBrandRequest) {
        Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
        this.brandRepository.save(brand);
    }

    @Override
    public void delete(int id) {
        Brand brandToDelete = brandRepository.findById(id).orElseThrow();
        brandRepository.delete(brandToDelete);
    }

    @Override
    public List<GetBrandListResponse> getByName(String name) {
        List<Brand> brands = brandRepository.findByNameContaining("%" + name + "%");

        List<GetBrandListResponse> response = new ArrayList<>();

        for (Brand brand : brands) {
            response.add(new GetBrandListResponse(brand.getName()));
        }
        return response;
    }

    @Override
    public List<GetBrandListResponse> getByCountry(String country) {
        List<Brand> brands = brandRepository.findByCountryStartingWith(country + "%");
        List<GetBrandListResponse> response = new ArrayList<>();

        for (Brand brand : brands) {
            response.add(new GetBrandListResponse(brand.getCountry()));
        }
        return response;
    }

    @Override
    public List<Brand> search(String name) {
        return brandRepository.search(name);
    }

    @Override
    public List<Brand> search1(String country) {
        return brandRepository.search1(country);
    }
}

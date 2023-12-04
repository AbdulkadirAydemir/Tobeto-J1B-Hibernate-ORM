package com.tobeto.spring_1b.services.abstracts;

import com.tobeto.spring_1b.entities.Brand;
import com.tobeto.spring_1b.services.dtos.requests.brand.AddBrandRequest;
import com.tobeto.spring_1b.services.dtos.requests.brand.UpdateBrandRequest;
import com.tobeto.spring_1b.services.dtos.responses.brand.GetBrandListResponse;
import com.tobeto.spring_1b.services.dtos.responses.brand.GetBrandResponse;

import java.util.List;

public interface BrandService {
    List<GetBrandListResponse> getAll();
    GetBrandResponse getById(int id);
    void add(AddBrandRequest request);
    void update(int id, UpdateBrandRequest updateBrandRequest);
    void delete(int id);
    List<GetBrandListResponse> getByName(String name);
    List<GetBrandListResponse> getByCountry(String country);
    List<Brand> search(String name);
    List<Brand> search1(String country);
}

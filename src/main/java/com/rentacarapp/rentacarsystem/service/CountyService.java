package com.rentacarapp.rentacarsystem.service;

import com.rentacarapp.rentacarsystem.entity.County;
import com.rentacarapp.rentacarsystem.dto.CountyDTO;
import java.util.List;
import java.util.Optional;

public interface CountyService {
    County createCounty(County county);
    County updateCounty(Integer id, County county);
    void deleteCounty(Integer id);
    Optional<County> getCountyById(Integer id);
    List<County> getAllCounties();
    List<CountyDTO> getAllCountyDTOs();
    List<CountyDTO> getCountiesByCityId(Integer cityId);
}
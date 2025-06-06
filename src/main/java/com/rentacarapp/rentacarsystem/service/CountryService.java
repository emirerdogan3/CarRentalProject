package com.rentacarapp.rentacarsystem.service;


import com.rentacarapp.rentacarsystem.entity.Country;
import com.rentacarapp.rentacarsystem.dto.CountryDTO;
import java.util.List;
import java.util.Optional;

public interface CountryService {
    Country createCountry(Country country);
    Country updateCountry(Integer id, Country country);
    void deleteCountry(Integer id);
    Optional<Country> getCountryById(Integer id);
    List<Country> getAllCountries();
    List<CountryDTO> getAllCountryDTOs();
}
package com.rentacarapp.rentacarsystem.service;


import com.rentacarapp.rentacarsystem.dto.FuelTypeDTO;
import com.rentacarapp.rentacarsystem.entity.FuelType;

import java.util.List;
import java.util.Optional;

public interface FuelTypeService {
    List<FuelTypeDTO> getAllFuelTypes();
    Optional<FuelTypeDTO> getFuelTypeDtoById(Integer id);
    FuelTypeDTO createFuelType(FuelTypeDTO fuelTypeDTO);
    FuelTypeDTO updateFuelType(Integer id, FuelTypeDTO fuelTypeDTO);
    void deleteFuelType(Integer id);
    Optional<FuelType> getFuelTypeById(Integer id); // For internal use
}
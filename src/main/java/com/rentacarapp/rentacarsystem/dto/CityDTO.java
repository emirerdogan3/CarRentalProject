package com.rentacarapp.rentacarsystem.dto;

import lombok.Data;

@Data
public class CityDTO {
    private Integer cityID;
    private String cityName;
    private Integer countryID;
    private String countryName;
}
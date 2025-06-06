package com.rentacarapp.rentacarsystem.dto;

import lombok.Data;

@Data
public class CountyDTO {
    private Integer countyID;
    private String countyName;
    private Integer cityID;
    private String cityName;
}
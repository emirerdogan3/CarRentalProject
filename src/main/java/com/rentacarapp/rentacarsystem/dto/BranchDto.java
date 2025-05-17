package com.rentacarapp.rentacarsystem.dto;

import lombok.Data;


@Data
public class BranchDto {
    private Long branchID;

    private Long userId;

    private String branchName;

    private String countryName;
    private Long countryId;

    private String cityName;
    private Long cityId;

    private String countyName;
    private Long countyId;
}

package com.rentacarapp.rentacarsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarCategoryDTO {
    private Integer categoryID;
    private String categoryName;
}
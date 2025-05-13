package com.rentacarapp.rentacarsystem.dto;

import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    private Long employeeID;
    //private Long userID;
    private String firstName;
    private String lastName;
    private BigDecimal salary;
    private Integer shiftCount;
    private String positionTitle;

    private Long branchID;
    private String branch; // İsteğe bağlı: branch bilgisini göstermek için
    private String branchName;

    private String username;
}
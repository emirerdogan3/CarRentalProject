package com.rentacarapp.rentacarsystem.dto;

import lombok.Data;

@Data
public class MoneyAccountDTO {
    private Integer accountID;
    private Integer branchID; // Assuming we'll map Branch to its ID
    private Double moneyBalance;
}
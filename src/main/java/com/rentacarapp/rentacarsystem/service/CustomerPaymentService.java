package com.rentacarapp.rentacarsystem.service;


import com.rentacarapp.rentacarsystem.entity.CustomerPayment;

public interface CustomerPaymentService {
    CustomerPayment makePayment(CustomerPayment payment);
}
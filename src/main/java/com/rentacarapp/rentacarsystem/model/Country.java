package com.rentacarapp.rentacarsystem.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Country")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CountryID")
    private Long countryID;

    @Column(name = "CountryName", unique = true, length = 50)
    private String countryName;
}
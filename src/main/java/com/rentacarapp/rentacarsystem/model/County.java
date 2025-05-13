package com.rentacarapp.rentacarsystem.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "County")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class County {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CountyID")
    private Long countyID;

    @Column(name = "CountyName", unique = true, length = 50)
    private String countyName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CityID")
    private City city;
}
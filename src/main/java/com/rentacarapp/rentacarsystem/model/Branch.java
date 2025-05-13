package com.rentacarapp.rentacarsystem.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Branch")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BranchID")
    private Long branchID;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "UserID")
    private User user;

    @Column(name = "BranchName", length = 100)
    private String branchName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CountryID")
    private Country country;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CityID")
    private City city;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CountyID")
    private County county;
}
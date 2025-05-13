package com.rentacarapp.rentacarsystem.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "BranchEmployees")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BranchEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "BranchID", nullable = false)
    private Branch branch;

    @ManyToOne
    @JoinColumn(name = "EmployeeID", nullable = false)
    private Employee employee;
}

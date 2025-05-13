package com.rentacarapp.rentacarsystem.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "Employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EmployeeID")
    private Long employeeID;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "UserID")
    private User user;

    @Column(name = "FirstName", length = 50)
    private String firstName;

    @Column(name = "LastName", length = 50)
    private String lastName;

    @Column(name = "Salary", precision = 10, scale = 2)
    private BigDecimal salary;

    @Column(name = "ShiftCount")
    private Integer shiftCount;

    @Column(name = "PositionTitle", length = 50)
    private String positionTitle;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "BranchID")
    private Branch branch;
}
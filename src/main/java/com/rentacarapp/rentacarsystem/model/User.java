package com.rentacarapp.rentacarsystem.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserID")
    private long userID; // VetApp de long  ben önceden Long yapmıştım

    @Column(name = "Username", nullable = false, unique = true)
    private String username;

    @Column(name = "PasswordHash", nullable = false, length = 255)
    private String passwordHash;

    @Column(name = "Email")
    private String email;

    @Column(name = "Phone")
    private String phone;

    @Column(name = "RoleID")
    private int roleId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "RoleID", insertable = false, updatable = false)
    private Role role;
}

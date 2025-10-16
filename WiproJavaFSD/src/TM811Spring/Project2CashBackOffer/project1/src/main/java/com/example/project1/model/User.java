package com.example.project1.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "app_users")
public class User {
    @Id
    private String username;

    @NotEmpty
    @Size(min = 6, max = 6, message = "Password must be 6 characters")
    private String password;

    @NotEmpty
    @Pattern(regexp = "^[A-Za-z]\\d{4}$", message = "Must be 1 letter then 4 digits")
    @Column(name = "employee_id", unique = true)
    private String employeeId;

    @NotEmpty
    @Email
    @Column(unique = true)
    private String email;

    public String getUsername() {
        return username;
    }

    public Object getPassword() {
        return password;
    }

    // Getters and Setters...
}

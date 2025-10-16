package TM16Hibernate;

// package com.example.model;
import javax.persistence.*;

@Entity
@Table(name = "Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emp_seq")
    @SequenceGenerator(name = "emp_seq", sequenceName = "employee_id_seq", allocationSize = 1)
    private int id;
    private String name;
    private String gender;
    private String designation;
    private double salary;
    private String city;
    private String email;
    @Column(name = "mobile_no")
    private String mobileNo;

    // Getters and Setters for all fields...
}

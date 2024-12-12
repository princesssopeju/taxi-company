package com.taxi.taxi_company.model;

import jakarta.persistence.*;

@Entity
@Table(name = "customers") // Maps to the "customers" table
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", nullable = false)
    private int customerId; // Matches the database column "customer_id"

    @Column(name = "Name", nullable = false)
    private String name; // Matches the "Name" column in the database

    @Column(name = "phone_number", nullable = true)
    private Long phoneNumber; // Matches the "phone_number" column in the database

    @Column(name = "Email", nullable = true, unique = true)
    private String email; // Matches the "Email" column in the database

    // Getters and Setters
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

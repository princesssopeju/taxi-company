package com.taxi.taxi_company.model;

import jakarta.persistence.*;

@Entity
@Table(name = "taxis")
public class Taxi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TaxiID")
    private Long taxiId;

    @Column(name = "LicensePlate", nullable = false, unique = true)
    private String licensePlate;

    @Column(name = "model")
    private String model;

    @Column(name = "Year")
    private int year;

    @Column(name = "Capacity")
    private int capacity;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "driver_id", nullable = true)
    private Driver driver;

    // Getters and setters
    public Long getTaxiId() {
        return taxiId;
    }

    public void setTaxiId(Long taxiId) {
        this.taxiId = taxiId;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
}

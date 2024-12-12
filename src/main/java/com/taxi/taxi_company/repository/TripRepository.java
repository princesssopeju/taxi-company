package com.taxi.taxi_company.repository;

import com.taxi.taxi_company.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<Trip, Long> {
    // Add custom query methods if needed, e.g.:
    // List<Trip> findByDriverId(Long driverId);
}

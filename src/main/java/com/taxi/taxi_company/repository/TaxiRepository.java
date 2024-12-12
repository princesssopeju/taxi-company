package com.taxi.taxi_company.repository;

import com.taxi.taxi_company.model.Taxi;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaxiRepository extends JpaRepository<Taxi, Long> {
    // Add custom query methods if needed, e.g.:
    // List<Taxi> findByStatus(String status);
}

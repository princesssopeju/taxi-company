package com.taxi.taxi_company.repository;

import com.taxi.taxi_company.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Long> {
    // The ID type is now Long
}

package com.taxi.taxi_company.service;

import com.taxi.taxi_company.model.Driver;
import java.util.List;

public interface DriverService {
    List<Driver> getAllDrivers();

    Driver getDriverById(Long id);

    Driver createDriver(Driver driver);

    Driver updateDriver(Long id, Driver updatedDriver);

    void deleteDriver(Long id);
}

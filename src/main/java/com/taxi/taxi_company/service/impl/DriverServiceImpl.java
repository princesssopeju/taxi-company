package com.taxi.taxi_company.service.impl;

import com.taxi.taxi_company.model.Driver;
import com.taxi.taxi_company.repository.DriverRepository;
import com.taxi.taxi_company.service.DriverService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverServiceImpl implements DriverService {

    private final DriverRepository driverRepository;

    public DriverServiceImpl(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @Override
    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    @Override
    public Driver getDriverById(Long id) {
        return driverRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Driver not found with ID: " + id));
    }

    @Override
    public Driver createDriver(Driver driver) {
        return driverRepository.save(driver);
    }

    @Override
    public Driver updateDriver(Long id, Driver updatedDriver) {
        Driver existingDriver = getDriverById(id);
        existingDriver.setName(updatedDriver.getName());
        existingDriver.setLicenseNumber(updatedDriver.getLicenseNumber());
        existingDriver.setPhoneNumber(updatedDriver.getPhoneNumber());
        existingDriver.setEmail(updatedDriver.getEmail());
        existingDriver.setStatus(updatedDriver.getStatus());
        return driverRepository.save(existingDriver);
    }

    @Override
    public void deleteDriver(Long id) {
        driverRepository.deleteById(id);
    }
}

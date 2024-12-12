package com.taxi.taxi_company.service.impl;

import com.taxi.taxi_company.model.Taxi;
import com.taxi.taxi_company.repository.TaxiRepository;
import com.taxi.taxi_company.service.TaxiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaxiServiceImpl implements TaxiService {

    @Autowired
    private TaxiRepository taxiRepository;

    @Override
    public Taxi createTaxi(Taxi taxi) {
        return taxiRepository.save(taxi); // Save the Taxi entity to the database
    }

    @Override
    public Taxi getTaxiById(Long id) {
        return taxiRepository.findById(id).orElse(null);
    }

    @Override
    public List<Taxi> getAllTaxis() {
        return taxiRepository.findAll();
    }

    @Override
    public Taxi updateTaxi(Long id, Taxi taxi) {
        Taxi existingTaxi = getTaxiById(id);
        if (existingTaxi != null) {
            existingTaxi.setLicensePlate(taxi.getLicensePlate());
            existingTaxi.setModel(taxi.getModel());
            existingTaxi.setYear(taxi.getYear());
            existingTaxi.setCapacity(taxi.getCapacity());
            existingTaxi.setStatus(taxi.getStatus());
            return taxiRepository.save(existingTaxi);
        }
        return null;
    }

    @Override
    public void deleteTaxi(Long id) {
        taxiRepository.deleteById(id);
    }
}

package com.taxi.taxi_company.service;

import com.taxi.taxi_company.model.Taxi;
import java.util.List;

public interface TaxiService {
    Taxi createTaxi(Taxi taxi);
    Taxi getTaxiById(Long id);
    List<Taxi> getAllTaxis(); // Correct return type
    Taxi updateTaxi(Long id, Taxi taxi);
    void deleteTaxi(Long id);
}

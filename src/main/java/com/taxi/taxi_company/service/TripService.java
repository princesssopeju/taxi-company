package com.taxi.taxi_company.service;

import com.taxi.taxi_company.model.Trip;

import java.util.List;

public interface TripService {
    Trip createTrip(Trip trip); // Define the createTrip method
    Trip getTripById(Long id); // Define the getTripById method
    List<Trip> getAllTrips(); // Define the getAllTrips method
    Trip updateTrip(Long id, Trip trip); // Define the updateTrip method
    void deleteTrip(Long id); // Define the deleteTrip method
}

package com.taxi.taxi_company.service.impl;

import com.taxi.taxi_company.model.Trip;
import com.taxi.taxi_company.model.Driver;
import com.taxi.taxi_company.model.Customer;
import com.taxi.taxi_company.model.Taxi;
import com.taxi.taxi_company.repository.TripRepository;
import com.taxi.taxi_company.repository.DriverRepository;
import com.taxi.taxi_company.repository.CustomerRepository;
import com.taxi.taxi_company.repository.TaxiRepository;
import com.taxi.taxi_company.service.TripService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripServiceImpl implements TripService {

    private final TripRepository tripRepository;
    private final DriverRepository driverRepository;
    private final CustomerRepository customerRepository;
    private final TaxiRepository taxiRepository;

    // Constructor-based Dependency Injection
    public TripServiceImpl(
            TripRepository tripRepository,
            DriverRepository driverRepository,
            CustomerRepository customerRepository,
            TaxiRepository taxiRepository
    ) {
        this.tripRepository = tripRepository;
        this.driverRepository = driverRepository;
        this.customerRepository = customerRepository;
        this.taxiRepository = taxiRepository;
    }

    @Override
    public Trip createTrip(Trip trip) {
        // Ensure the related entities exist
        Driver driver = driverRepository.findById(trip.getDriver().getDriverId())
                .orElseThrow(() -> new RuntimeException("Driver not found with ID: " + trip.getDriver().getDriverId()));
        Customer customer = customerRepository.findById(trip.getCustomer().getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found with ID: " + trip.getCustomer().getCustomerId()));
        Taxi taxi = taxiRepository.findById(trip.getTaxi().getTaxiId())
                .orElseThrow(() -> new RuntimeException("Taxi not found with ID: " + trip.getTaxi().getTaxiId()));

        // Set the related entities
        trip.setDriver(driver);
        trip.setCustomer(customer);
        trip.setTaxi(taxi);

        // Save and return the trip
        return tripRepository.save(trip);
    }

    @Override
    public Trip getTripById(Long id) {
        return tripRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trip not found with ID: " + id));
    }

    @Override
    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }

    @Override
    public Trip updateTrip(Long id, Trip trip) {
        Trip existingTrip = getTripById(id);

        // Update basic fields
        existingTrip.setStartLocation(trip.getStartLocation());
        existingTrip.setEndLocation(trip.getEndLocation());
        existingTrip.setStartTime(trip.getStartTime());
        existingTrip.setEndTime(trip.getEndTime());
        existingTrip.setFare(trip.getFare());
        existingTrip.setPaymentMethod(trip.getPaymentMethod());

        // Update related entities
        if (trip.getDriver() != null) {
            Driver driver = driverRepository.findById(trip.getDriver().getDriverId())
                    .orElseThrow(() -> new RuntimeException("Driver not found with ID: " + trip.getDriver().getDriverId()));
            existingTrip.setDriver(driver);
        }
        if (trip.getCustomer() != null) {
            Customer customer = customerRepository.findById(trip.getCustomer().getCustomerId())
                    .orElseThrow(() -> new RuntimeException("Customer not found with ID: " + trip.getCustomer().getCustomerId()));
            existingTrip.setCustomer(customer);
        }
        if (trip.getTaxi() != null) {
            Taxi taxi = taxiRepository.findById(trip.getTaxi().getTaxiId())
                    .orElseThrow(() -> new RuntimeException("Taxi not found with ID: " + trip.getTaxi().getTaxiId()));
            existingTrip.setTaxi(taxi);
        }

        // Save and return updated trip
        return tripRepository.save(existingTrip);
    }

    @Override
    public void deleteTrip(Long id) {
        tripRepository.deleteById(id);
    }
}

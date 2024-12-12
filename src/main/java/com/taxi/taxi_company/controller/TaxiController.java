package com.taxi.taxi_company.controller;

import com.taxi.taxi_company.model.Taxi;
import com.taxi.taxi_company.service.TaxiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/taxis")
public class TaxiController {

    @Autowired
    private TaxiService taxiService;

    // Get all taxis
    @GetMapping
    public ResponseEntity<List<Taxi>> getAllTaxis() {
        List<Taxi> taxis = taxiService.getAllTaxis();
        return ResponseEntity.ok(taxis);
    }

    // Create a new taxi
    @PostMapping("/create")
    public ResponseEntity<Taxi> createTaxi(@RequestBody Taxi taxi) {
        Taxi createdTaxi = taxiService.createTaxi(taxi);
        return ResponseEntity.ok(createdTaxi);
    }
}

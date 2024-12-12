package com.taxi.taxi_company.service;

import com.taxi.taxi_company.model.Customer;

import java.util.List;

public interface CustomerService {

    // Create a new customer
    Customer createCustomer(Customer customer);

    // Retrieve a customer by ID
    Customer getCustomerById(Integer id);


    // Retrieve all customers
    List<Customer> getAllCustomers();

    // Update an existing customer
    Customer updateCustomer(Integer id, Customer customer);

    // Delete a customer by ID
    boolean deleteCustomer(Integer id);
}

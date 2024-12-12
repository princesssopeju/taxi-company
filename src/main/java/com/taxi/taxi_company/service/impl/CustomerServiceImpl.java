package com.taxi.taxi_company.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.taxi.taxi_company.model.Customer;
import com.taxi.taxi_company.repository.CustomerRepository;
import com.taxi.taxi_company.service.CustomerService;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer getCustomerById(Integer id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with id " + id));
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer updateCustomer(Integer id, Customer customer) {
        Customer existingCustomer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with id " + id));
        existingCustomer.setName(customer.getName());
        existingCustomer.setEmail(customer.getEmail());
        existingCustomer.setPhoneNumber(customer.getPhoneNumber());
        return customerRepository.save(existingCustomer);
    }

    @Override
    public boolean deleteCustomer(Integer id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
            return true; // Indicate successful deletion
        }
        return false; // Indicate failure (customer not found)
    }

}

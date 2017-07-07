package com.musicstore.dao;

import com.musicstore.model.Customer;

import java.util.List;

public interface CustomerDao {
    void addCustomer(Customer customer);

    Customer getCustomerById(int customerId);

    List<Customer> getAllCustomer();

    Customer getCustomerByUsername(String username);
}

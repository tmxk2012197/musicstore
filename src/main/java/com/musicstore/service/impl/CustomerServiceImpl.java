package com.musicstore.service.impl;

import com.musicstore.dao.CustomerDao;
import com.musicstore.model.Customer;
import com.musicstore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerDao customerDao;

    @Override
    public void addCustomer(Customer customer) {
    customerDao.addCustomer(customer);
    }

    @Override
    public Customer getCustomerById(int customerId) {
        return customerDao.getCustomerById(customerId);
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerDao.getAllCustomer();
    }
}

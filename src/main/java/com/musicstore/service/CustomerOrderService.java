package com.musicstore.service;

import com.musicstore.model.CustomerOrder;

public interface CustomerOrderService {
    void addCustomerOrder(CustomerOrder customerOrder);

    double getCustomerOrderGrandTotal(int cartId);
}

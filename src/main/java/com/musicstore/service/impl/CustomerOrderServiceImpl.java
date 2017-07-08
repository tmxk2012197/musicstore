package com.musicstore.service.impl;

import com.musicstore.dao.CustomerOrderDao;
import com.musicstore.model.Cart;
import com.musicstore.model.CartItem;
import com.musicstore.model.CustomerOrder;
import com.musicstore.service.CartService;
import com.musicstore.service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService{
    @Autowired
    private CartService cartService;

    @Autowired
    private CustomerOrderDao customerOrderDao;

    @Override
    public void addCustomerOrder(CustomerOrder customerOrder) {
        customerOrderDao.addCustomerOrder(customerOrder);
    }

    @Override
    public double getCustomerOrderGrandTotal(int cartId) {
        double grandTotal = 0d;
        Cart cart = cartService.getCartById(cartId);
        List<CartItem> cartItems = cart.getCartItems();
        for (CartItem cartItem : cartItems) {
            grandTotal += cartItem.getTotalPrice();
        }
        return grandTotal;
    }
}

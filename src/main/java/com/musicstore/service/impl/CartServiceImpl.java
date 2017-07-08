package com.musicstore.service.impl;

import com.musicstore.dao.CartDao;
import com.musicstore.model.Cart;
import com.musicstore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService{
    @Autowired
    private CartDao cartDao;

    @Override
    public Cart getCartById(int cartId) {
        return cartDao.getCartById(cartId);
    }

    @Override
    public void updateCart(Cart cart) {
        cartDao.updateCart(cart);
    }
}

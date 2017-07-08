package com.musicstore.service;

import com.musicstore.model.Cart;

public interface CartService {
    Cart getCartById(int cartId);

    void updateCart(Cart cart);
}

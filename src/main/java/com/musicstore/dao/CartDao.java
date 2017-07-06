package com.musicstore.dao;

import com.musicstore.model.Cart;

public interface CartDao {
    Cart createCart(Cart cart);

    Cart readCartInfo(int cartId);

    void updateCart(int cartId, Cart cart);

    void deleteCart(int cartId);
}

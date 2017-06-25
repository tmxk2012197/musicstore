package com.musicstore.dao;

import com.musicstore.model.Cart;

public interface CartDao {
    Cart createCart(Cart cart);

    Cart readCartInfo(String cartId);

    void updateCart(String cartId, Cart cart);

    void deleteCart(String cartId);
}

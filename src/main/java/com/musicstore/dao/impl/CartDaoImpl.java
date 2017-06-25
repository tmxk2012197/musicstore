package com.musicstore.dao.impl;

import com.musicstore.dao.CartDao;
import com.musicstore.model.Cart;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CartDaoImpl implements CartDao{
    private Map<String, Cart> carts;

    public CartDaoImpl() {
        this.carts = new HashMap<>();
    }

    @Override
    public Cart createCart(Cart cart) {
        if (carts.containsKey(cart.getCartId())) {
            throw new IllegalArgumentException(String.format("Cannot create the cart. A cart with the given id (%s) already exists", cart.getCartId()));
        }
        carts.put(cart.getCartId(), cart);
        return cart;
    }

    @Override
    public Cart readCartInfo(String cartId) {
        return carts.get(cartId);
    }

    @Override
    public void updateCart(String cartId, Cart cart) {
        if (!carts.containsKey(cartId)) {
            throw new IllegalArgumentException(String.format("Cannot update the cart. A cart with the given id (%s) does not exist", cart.getCartId()));
        }
        carts.put(cartId, cart);
    }

    @Override
    public void deleteCart(String cartId) {
        if (!carts.containsKey(cartId)) {
            throw new IllegalArgumentException(String.format("Cannot delete the cart. A cart with the given id (%s) does not exist", cartId));
        }
        carts.remove(cartId);
    }
}

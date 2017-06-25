package com.musicstore.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private String cartId;
    private Map<Integer, CartItem> cartItems;
    private double grandTotal;

    private Cart() {
        this.cartItems = new HashMap<>();
        this.grandTotal = 0;
    }

    public Cart(String cartId) {
        this();
        this.cartId = cartId;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public Map<Integer, CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(Map<Integer, CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public void addCartItem(CartItem cartItem) {
        int productId = cartItem.getProduct().getProductId();
        if (cartItems.containsKey(productId)) {
            CartItem existingCartItem = cartItems.get(productId);
            existingCartItem.setQuantity(existingCartItem.getQuantity() + cartItem.getQuantity());
            cartItems.put(productId, existingCartItem);
        } else {
            cartItems.put(productId, cartItem);
        }
        updateGrandTotal();
    }

    public void removeCartItem(CartItem cartItem) {
        int productId = cartItem.getProduct().getProductId();
        cartItems.remove(productId);
        updateGrandTotal();
    }

    public void updateGrandTotal() {
        grandTotal = 0;
        for (CartItem cartItem : cartItems.values()) {
            grandTotal += cartItem.getTotalPrice();
        }
    }
}

package com.musicstore.dao;

import com.musicstore.model.Product;

import java.util.List;

public interface ProductDao {
    void addProduct(Product product);

    Product getProductById(int productId);

    List<Product> getAllProducts();

    void deleteProduct(int productId);

    void editProduct(Product product);
}

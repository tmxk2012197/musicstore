package com.musicstore.dao;

import com.musicstore.model.Product;

import java.util.List;

public interface ProductDao {
    List<Product> getProductList();

    Product getProductById(int productId);

    void addProduct(Product product);

    void editProduct(Product product);

    void deleteProduct(Product product);
}

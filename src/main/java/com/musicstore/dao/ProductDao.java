package com.musicstore.dao;

import com.musicstore.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    private List<Product> productList;

    public List<Product> getProductList() {
        Product product = new Product();
        product.setName("Guitar");
        product.setCategory("Instrument");
        product.setDescription("Fender star guitar");
        product.setPrice(1200);
        product.setCondition("New");
        product.setStatus("Active");
        product.setUnitInStock(11);
        product.setManufacturer("Fender");

        productList = new ArrayList<Product>();
        productList.add(product);
        return productList;
    }
}

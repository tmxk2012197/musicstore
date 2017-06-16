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

        Product product2 = new Product();
        product2.setName("Record1");
        product2.setCategory("Record");
        product2.setDescription("mix of 20th century");
        product2.setPrice(45);
        product2.setCondition("New");
        product2.setStatus("Active");
        product2.setUnitInStock(21);
        product2.setManufacturer("EMI");

        Product product3 = new Product();
        product3.setName("Speaker");
        product3.setCategory("Accessory");
        product3.setDescription("Polk shelf speaker");
        product3.setPrice(343);
        product3.setCondition("New");
        product3.setStatus("Active");
        product3.setUnitInStock(34);
        product3.setManufacturer("Polk");

        productList = new ArrayList<Product>();
        productList.add(product);
        productList.add(product2);
        productList.add(product3);
        return productList;
    }
}

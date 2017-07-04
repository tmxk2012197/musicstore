package com.musicstore.dao.impl;

import com.musicstore.dao.ProductDao;
import com.musicstore.model.Product;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao{
    @Autowired
    private SessionFactory sessionFactory;

    public void addProduct(Product product) {
        //session is singleton
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
        //session operation will be executed only after flush
        session.flush();
    }

    @Override
    public List<Product> getProductList() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Product");
        List<Product> productList = query.list();
        session.flush();
        return productList;
    }

    public Product getProductById(int productId) {
        Session session = sessionFactory.getCurrentSession();
        Product product = (Product) session.get(Product.class, productId);
        session.flush();
        return product;
    }

    @Override
    public void editProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
        session.flush();
    }

    @Override
    public void deleteProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(product);
        session.flush();
    }
}

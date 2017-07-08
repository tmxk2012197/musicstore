package com.musicstore.dao.impl;

import com.musicstore.dao.CustomerDao;
import com.musicstore.model.Authorities;
import com.musicstore.model.Cart;
import com.musicstore.model.Customer;
import com.musicstore.model.Users;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();

        customer.getBillingAddress().setCustomer(customer);
        customer.getShippingAddress().setCustomer(customer);
        session.saveOrUpdate(customer);
        session.saveOrUpdate(customer.getBillingAddress());
        session.saveOrUpdate(customer.getShippingAddress());

        Users users = new Users();
        users.setUsername(customer.getUsername());
        users.setPassword(customer.getPassword());
        users.setEnabled(true);
        users.setCustomerId(customer.getCustomerId());

        Authorities authorities = new Authorities();
        authorities.setUsername(customer.getUsername());
        authorities.setAuthority("ROLE_USER");
        session.saveOrUpdate(users);
        session.saveOrUpdate(authorities);

        Cart cart = new Cart();
        cart.setCustomer(customer);
        customer.setCart(cart);
        session.saveOrUpdate(customer);
        session.saveOrUpdate(cart);

        session.flush();
    }

    @Override
    public Customer getCustomerById(int customerId) {
        Session session = sessionFactory.getCurrentSession();
        return (Customer) session.get(Customer.class, customerId);
    }

    @Override
    public List<Customer> getAllCustomer() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Customer");
        List<Customer> customerList = query.list();
        return customerList;
    }

    @Override
    public Customer getCustomerByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Customer where username = ?");
        query.setParameter(0, username);
        return (Customer) query.uniqueResult();
    }
}

package com.musicstore.controller;

import com.musicstore.model.BillingAddress;
import com.musicstore.model.Customer;
import com.musicstore.model.ShippingAddress;
import com.musicstore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
public class RegisterController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping("/register")
    public String registerCustomer(Model model) {
        Customer customer = new Customer();
        BillingAddress billingAddress = new BillingAddress();
        ShippingAddress shippingAddress = new ShippingAddress();
        customer.setBillingAddress(billingAddress);
        customer.setShippingAddress(shippingAddress);
        model.addAttribute("customer", customer);
        return "registerCustomer";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerCustomerPost(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "registerCustomer";
        }
        List<Customer> customerList = customerService.getAllCustomer();
        for (Customer c : customerList) {
            if (customer.getCustomerEmail().equals(c.getCustomerEmail())) {
                model.addAttribute("emailMsg", "Email already exists");
                return "registerCustomer";
            }
            if (customer.getUsername().equals(c.getUsername())) {
                model.addAttribute("usernameMsg", "Username already exists");
                return "registerCustomer";
            }
        }
        customer.setEnabled(true);
        customerService.addCustomer(customer);
        return "registerCustomerSuccess";
    }
}

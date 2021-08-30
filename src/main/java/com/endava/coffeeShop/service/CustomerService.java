package com.endava.coffeeShop.service;

import com.endava.coffeeShop.model.Customer;

import javax.transaction.Transactional;

public interface CustomerService {
    @Transactional
    Customer addCustomer(Customer customer);
}

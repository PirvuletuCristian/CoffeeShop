package com.endava.coffeeShop.service;

import com.endava.coffeeShop.model.Order;

import javax.transaction.Transactional;

public interface OrderService {
    @Transactional
    Order addOrder(Order order);
}

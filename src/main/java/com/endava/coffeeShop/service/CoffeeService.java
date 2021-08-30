package com.endava.coffeeShop.service;

import com.endava.coffeeShop.model.Coffee;

import javax.transaction.Transactional;

public interface CoffeeService {
    @Transactional
    Coffee addCoffee(Coffee coffee);


}

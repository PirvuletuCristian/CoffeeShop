package com.endava.coffeeShop.service;

import com.endava.coffeeShop.model.Address;

import javax.transaction.Transactional;

public interface AddressService {
    @Transactional
    Address addAdress(Address address);
}

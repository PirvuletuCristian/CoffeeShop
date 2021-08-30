package com.endava.coffeeShop.service;

import com.endava.coffeeShop.model.Address;
import com.endava.coffeeShop.repository.AddressRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AddressServiceImpl implements AddressService {

    public final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository){this.addressRepository = addressRepository;}

    @Override
    @Transactional
    public Address addAdress(Address address){
        address = addressRepository.save(address);

        return address;
    }
}

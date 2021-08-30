package com.endava.coffeeShop.controller;

import com.endava.coffeeShop.EmployeeNotFoundException;
import com.endava.coffeeShop.model.Address;
import com.endava.coffeeShop.repository.AddressRepository;
import com.endava.coffeeShop.service.AddressService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AddressController {

    public final AddressRepository addressRepository;

    public final AddressService addressService;

    public AddressController(AddressRepository addressRepository, AddressService addressService) {
        this.addressRepository = addressRepository;
        this.addressService = addressService;
    }

    @GetMapping("/addresses")
    List<Address> all() {
        return addressRepository.findAll();
    }

    @GetMapping("/addresses/{id}")
    Optional<Address> one(@PathVariable Long id) {
        return addressRepository.findById(id);
    }

    @PostMapping("/addresses")
    public Address postAddress(Address address) {
        System.out.println("Address: " + address.getId());

        addressService.addAdress(address);

        return address;
    }

    @PutMapping("/addresses/{id}/{street}/{nr}")
    public Address update(@PathVariable Long id, @PathVariable String street, @PathVariable int nr) {
        Address address = addressRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
        address.setStreet(street);
        address.setNr(nr);

        return addressRepository.save(address);


    }

    @DeleteMapping("/addresses/{id}")
    void deleteAddress(@PathVariable Long id) {
        addressRepository.deleteById(id);
    }

}

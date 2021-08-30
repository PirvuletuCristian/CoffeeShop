package com.endava.coffeeShop.service;

import com.endava.coffeeShop.model.Customer;
import com.endava.coffeeShop.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CustomerServiceImpl implements CustomerService {

    public final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public Customer addCustomer(Customer customer){
        customer = customerRepository.save(customer);

        return customer;
    }
}

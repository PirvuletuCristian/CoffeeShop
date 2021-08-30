package com.endava.coffeeShop.controller;

import com.endava.coffeeShop.EmployeeNotFoundException;
import com.endava.coffeeShop.model.Customer;
import com.endava.coffeeShop.repository.CustomerRepository;
import com.endava.coffeeShop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    public final CustomerRepository customerRepository;

    public final CustomerService customerService;

    public CustomerController(CustomerRepository customerRepository, CustomerService customerService) {
        this.customerRepository = customerRepository;
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    List<Customer> all(){return customerRepository.findAll();}

    @GetMapping("/customers/{id}")
    Optional<Customer> one(@PathVariable Long id){
        return customerRepository.findById(id);
    }

    @PostMapping("/customers")
    public Customer postCustomer(Customer customer){
        System.out.println("Customer: " + customer.getUsername());

        customerService.addCustomer(customer);

        return customer;
    }

    @PutMapping("/customers/{id}/{username}/{password}")
    public Customer update(@PathVariable Long id, @PathVariable String username, @PathVariable String password){
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
        customer.setUsername(username);
        customer.setPassword(password);

        return customerRepository.save(customer);
    }

    @DeleteMapping("/customers/{id}")
    void deleteCustomer(@PathVariable Long id){customerRepository.deleteById(id);}


}

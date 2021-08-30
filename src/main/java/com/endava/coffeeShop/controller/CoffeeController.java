package com.endava.coffeeShop.controller;

import com.endava.coffeeShop.model.Coffee;
import com.endava.coffeeShop.repository.CoffeeRepository;
import com.endava.coffeeShop.service.CoffeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CoffeeController {

    public final CoffeeService coffeeService;
    public final CoffeeRepository coffeeRepository;

    public CoffeeController(CoffeeService coffeeService, CoffeeRepository coffeeRepository) {
        this.coffeeService = coffeeService;
        this.coffeeRepository = coffeeRepository;
    }


    @GetMapping("/coffees")
    List<Coffee> all() {
        return coffeeRepository.findAll();
    }


    @PostMapping("/coffee")
    public Coffee postCoffee(Coffee coffee){
        System.out.println("Coffee:" + coffee.getName());

        coffeeService.addCoffee(coffee);

        return coffee;
    }

}

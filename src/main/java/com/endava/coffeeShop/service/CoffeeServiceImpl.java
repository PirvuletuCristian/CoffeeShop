package com.endava.coffeeShop.service;

import com.endava.coffeeShop.model.Coffee;
import com.endava.coffeeShop.model.Ingredient;
import com.endava.coffeeShop.repository.CoffeeRepository;
import com.endava.coffeeShop.repository.IngredientRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
public class CoffeeServiceImpl implements CoffeeService {

    public final CoffeeRepository coffeeRepository;
    public final IngredientRepository ingredientRepository;

    public CoffeeServiceImpl(CoffeeRepository coffeeRepository, IngredientRepository ingredientRepository ) {
        this.coffeeRepository = coffeeRepository;
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    @Transactional
    public Coffee addCoffee(Coffee coffee) {
            coffee = coffeeRepository.save(coffee);

//            if(coffee.getId() == null) {
//                Ingredient ingredient = new Ingredient();
//                ingredient.setName("Coffee shot");
//                ingredient.setStock(20);
//                ingredient.setPrice(2);
//                ingredient.setCoffee(coffee);
//
//                ingredientRepository.save(ingredient);
//            }

        return coffee;
    }



}

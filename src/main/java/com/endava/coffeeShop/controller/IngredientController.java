package com.endava.coffeeShop.controller;

import com.endava.coffeeShop.EmployeeNotFoundException;
import com.endava.coffeeShop.model.Ingredient;
import com.endava.coffeeShop.repository.IngredientRepository;
import com.endava.coffeeShop.service.IngredientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class IngredientController {

    public final IngredientRepository ingredientRepository;
    public final IngredientService ingredientService;

    public IngredientController(IngredientRepository ingredientRepository,IngredientService ingredientService) {
        this.ingredientRepository = ingredientRepository;
        this.ingredientService = ingredientService;
    }

    @GetMapping("/ingredients")
    List<Ingredient> all() {
        return ingredientRepository.findAll();
    }

    @PostMapping("/ingredients")
    public Ingredient postIngredient(Ingredient ingredient){
        System.out.println("Ingredient:" + ingredient.getName());

        ingredientService.addIngredient(ingredient);

        return ingredient;
    }

    @GetMapping("/ingredients/{id}")
    Optional<Ingredient> one(@PathVariable Long id) {

        return ingredientRepository.findById(id);
    }

    @PutMapping("/ingredients/{id}/{newName}/{newStock}/{newPrice}")
    public Ingredient update(@PathVariable Long id, @PathVariable String newName, @PathVariable int newStock, @PathVariable int newPrice){
        Ingredient ingredient = ingredientRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
        ingredient.setName(newName);
        ingredient.setStock(newStock);
        ingredient.setPrice(newPrice);

        return ingredientRepository.save(ingredient);

    }

    @DeleteMapping("/ingredients/{id}")
    void deleteIngredients(@PathVariable Long id) {
        ingredientRepository.deleteById(id);
    }
}

package com.endava.coffeeShop.service;

import com.endava.coffeeShop.model.Ingredient;

import javax.transaction.Transactional;

public interface IngredientService {
    @Transactional
    Ingredient addIngredient(Ingredient ingredient);
}

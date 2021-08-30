package com.endava.coffeeShop.service;

import com.endava.coffeeShop.model.Recipe;

import javax.transaction.Transactional;

public interface RecipeService {
    @Transactional
    Recipe addRecipe(Recipe recipe);
}

package com.endava.coffeeShop.service;

import com.endava.coffeeShop.model.Ingredient;
import com.endava.coffeeShop.repository.IngredientRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class IngredientServiceImpl implements IngredientService {
    public final IngredientRepository ingredientRepository;

    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    @Transactional
    public Ingredient  addIngredient(Ingredient ingredient){
        ingredient = ingredientRepository.save(ingredient);

        return ingredient;
    }
}

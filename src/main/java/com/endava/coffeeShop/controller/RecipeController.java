package com.endava.coffeeShop.controller;

import com.endava.coffeeShop.model.Recipe;
import com.endava.coffeeShop.repository.RecipeRepository;
import com.endava.coffeeShop.service.RecipeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecipeController {

    public final RecipeRepository recipeRepository;

    public final RecipeService recipeService;

    public RecipeController(RecipeRepository recipeRepository, RecipeService recipeService) {
        this.recipeRepository = recipeRepository;
        this.recipeService = recipeService;
    }

    @GetMapping("/recipes")
    List<Recipe> all(){return  recipeRepository.findAll();}

    @PostMapping("/recipe")
    public Recipe postRecipe(Recipe recipe){
        System.out.println("Recipe:" + recipe.getName());

        recipeService.addRecipe(recipe);

        return recipe;
    }
}



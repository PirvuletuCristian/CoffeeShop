package com.endava.coffeeShop.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "RECIPE_ID")
    private Long id;

    @Column(name = "REPICE_NAME")
    private String name;

    @OneToOne(mappedBy = "recipe")
    private Coffee coffee;



    @OneToMany(mappedBy = "recipe")
    @Column(name = "INGREDIENTS")
    private Set<RecipeIngredients> recipeIngredients;




    public Recipe(String name, Coffee coffee, Set<RecipeIngredients> recipeIngredients) {
        this.name = name;
        this.coffee = coffee;
        this.recipeIngredients = recipeIngredients;
    }

    public Recipe() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coffee getCoffee() {
        return coffee;
    }

    public void setCoffee(Coffee coffee) {
        this.coffee = coffee;
    }

    public Set<RecipeIngredients> getRecipeIngredients() {
        return recipeIngredients;
    }

    public void setRecipeIngredients(Set<RecipeIngredients> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }
}

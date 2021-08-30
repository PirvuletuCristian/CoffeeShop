package com.endava.coffeeShop.model;

import javax.persistence.*;

@Entity
@Table(name = "COFFEE_INGREDIENTS")
public class CoffeeIngredients {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "COFFEE_ID")
    private Coffee coffee;

    @ManyToOne
    @JoinColumn(name = "INGREDIENT_ID")
    private Ingredient ingredient;

    public CoffeeIngredients() {
    }

    public CoffeeIngredients(Long id, Coffee coffee, Ingredient ingredient) {
        this.id = id;
        this.coffee = coffee;
        this.ingredient = ingredient;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Coffee getCoffee() {
        return coffee;
    }

    public void setCoffee(Coffee coffee) {
        this.coffee = coffee;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }
}

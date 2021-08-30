package com.endava.coffeeShop.model;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "BAVERAGES")
public class Coffee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BAVERAGE_ID")
    private Long id;

    @Column(name = "BAVERAGE_NAME", nullable = false)
    private String name;

    @Column(name = "BAVERAGE_PRICE", nullable = false)
    private Integer price;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "RECIPE_ID", referencedColumnName = "RECIPE_ID")
    private Recipe recipe;

    @OneToMany(mappedBy = "coffee")
    @Column(name = "INGREDIENTS")
    private Set<CoffeeIngredients> coffeeIngredients;



    public Coffee() {

    }

    public Coffee(Long id, String name, Integer price, Recipe recipe, Set<CoffeeIngredients> coffeeIngredients) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.recipe = recipe;
        this.coffeeIngredients = coffeeIngredients;
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public Set<CoffeeIngredients> getCoffeeIngredients() {
        return coffeeIngredients;
    }

    public void setCoffeeIngredients(Set<CoffeeIngredients> coffeeIngredients) {
        this.coffeeIngredients = coffeeIngredients;
    }
}


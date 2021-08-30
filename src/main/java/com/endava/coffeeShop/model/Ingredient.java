package com.endava.coffeeShop.model;



import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "INGREDIENTS")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "INGREDIENT_ID")
    private Long id;

    @Column(name = "iNGREDIENT_NAME", nullable = false)
    private String name;

    @Column(name = "iNGREDIENT_STOCK")
    private Integer stock;

    @Column(name = "iNGREDIENT_PRICE", nullable = false)
    private Integer price;

    @OneToMany(mappedBy = "ingredient")
    private Set<RecipeIngredients> recipeIngredients;

    @OneToMany(mappedBy = "ingredient")
    private Set<CoffeeIngredients> coffeeIngredients;

    public Ingredient() {

    }

    public Ingredient(Long id, String name, Integer stock, Integer price, Set<RecipeIngredients> recipeIngredients, Set<CoffeeIngredients> coffeeIngredients) {
        this.id = id;
        this.name = name;
        this.stock = stock;
        this.price = price;
        this.recipeIngredients = recipeIngredients;
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

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Set<RecipeIngredients> getRecipeIngredients() {
        return recipeIngredients;
    }

    public void setRecipeIngredients(Set<RecipeIngredients> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    public Set<CoffeeIngredients> getCoffeeIngredients() {
        return coffeeIngredients;
    }

    public void setCoffeeIngredients(Set<CoffeeIngredients> coffeeIngredients) {
        this.coffeeIngredients = coffeeIngredients;
    }
}

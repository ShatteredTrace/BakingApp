package com.kirsch.lennard.bakingapp;

public class Recipe {
    int id;
    String name;
    Ingredient[] ingredients;
    RecipeStep[] recipeSteps;
    int servings;
    String image;

    public Recipe(int id, String name, Ingredient[] ingredients, RecipeStep[] recipeSteps, int servings, String image){
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
        this.recipeSteps = recipeSteps;
        this.servings = servings;
        this.image = image;
    }

    public Recipe(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Ingredient[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(Ingredient[] ingredients) {
        this.ingredients = ingredients;
    }

    public RecipeStep[] getRecipeSteps() {
        return recipeSteps;
    }

    public void setRecipeSteps(RecipeStep[] recipeSteps) {
        this.recipeSteps = recipeSteps;
    }

    public int getServings() {
        return servings;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

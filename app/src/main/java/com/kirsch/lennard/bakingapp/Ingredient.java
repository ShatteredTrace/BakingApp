package com.kirsch.lennard.bakingapp;

public class Ingredient {
    int quantity;
    String measure;
    String ingredientName;

    public Ingredient(int quantity, String measure, String ingredientName){
        this.quantity = quantity;
        this.measure = measure;
        this.ingredientName = ingredientName;
    }

    public Ingredient(){}

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }
}

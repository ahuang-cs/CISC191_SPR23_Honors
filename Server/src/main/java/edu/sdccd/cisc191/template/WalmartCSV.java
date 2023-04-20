package edu.sdccd.cisc191.template;

import edu.sdccd.cisc191.template.Ingredient.Ingredient;

public class WalmartCSV {
    private String ingredientName;

    //private double quantity;

    private Ingredient.Units unit;

    private double price;
    public WalmartCSV(){}

    public WalmartCSV(String ingredientName, Ingredient.Units unit, double price) {
        this.ingredientName = ingredientName;
       // this.quantity = quantity;
        this.unit = unit;
        this.price = price;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

//    public double getQuantity() {
//        return quantity;
//    }

//    public void setQuantity(double quantity) {
//        this.quantity = quantity;
//    }

    public Ingredient.Units getUnit() {
        return unit;
    }

    public void setUnit(Ingredient.Units unit) {
        this.unit = unit;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

package edu.sdccd.cisc191.template;

public class Ingredient {
    String ingredientName;
    Units unit;
    double quantity;     /// amount of ingredient in inventory

    public Ingredient(){};
    public Ingredient(String ingredientName, Units unit,double quantity) {
        this.ingredientName = ingredientName;
        this.unit = unit;
        this.quantity = quantity;
    }


    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public Units getUnit() {
        return unit;
    }

    public void setUnit(Units unit) {
        this.unit = unit;
    }
    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }






    public static enum Units {
        OZ,
        LB,
        GAL,
        PINT,
        TSP
    }

}

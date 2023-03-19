package edu.sdccd.cisc191.template;

public class Ingredient {
    String ingredientName;
    Units unit;

    /// amount of ingredient in inventory
    double inventoryQuantity;

    public Ingredient(){};

    // Re-add units
    public Ingredient(String ingredientName, Units unit, double quantity) {
        this.ingredientName = ingredientName;
        this.unit = unit;
        this.inventoryQuantity = quantity;
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
        return inventoryQuantity;
    }

    public void setQuantity(double quantity) {
        this.inventoryQuantity = quantity;
    }


    public static enum Units {
        OZ,
        LB,
        GAL,
        PINT,
        TSP
    }

}

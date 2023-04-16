package edu.sdccd.cisc191.template.Ingredient;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Ingredient {
    String ingredientName;
    Units unit;
    // amount of ingredient in inventory
    double quantity;
    @Id
    private Long id;

    public Ingredient(){};

    public Ingredient(String ingredientName, Units unit, double quantity) {
        this.ingredientName = ingredientName;
        this.unit = unit;
        this.quantity = quantity;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public Units getUnit() {
        return unit;
    }

    public void setUnit(Units unit) {
        this.unit = unit;
    }
    public void setQuantity(double quantity){this.quantity = quantity;}

    public double getQuantity(){return quantity;}


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public static enum Units {
        OZ,
        fluidOZ,
        LB,
        GAL,
        PINT,
        TSP
    }

}

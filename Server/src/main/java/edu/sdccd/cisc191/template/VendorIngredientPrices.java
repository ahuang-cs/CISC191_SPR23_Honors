package edu.sdccd.cisc191.template;

import java.awt.*;
import java.awt.MenuItem;

public class VendorIngredientPrices extends Vendors{
    private Vendors vendor;
    private Ingredient ingredient;
    private double costPerUnit;
    private String item;

    public VendorIngredientPrices(){
        super();
    };
    public VendorIngredientPrices(Vendors vendor, Ingredient ingredient, double costPerUnit, String item) {

        setVendor(vendor);
        setIngredient(ingredient);
        setCostPerUnit(costPerUnit);
        setItem(item);
    }

    public Vendors getVendor() {
        return vendor;
    }

    public void setVendor(Vendors vendor) {
        this.vendor = vendor;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public double getCostPerUnit() {
        return costPerUnit;
    }

    public void setCostPerUnit(double costPerUnit) {
        this.costPerUnit = costPerUnit;
    }
    public void setItem(String item){this.item = item;};
    public String getItem(){return item;}
}

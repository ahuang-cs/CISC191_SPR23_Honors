package edu.sdccd.cisc191.template;

public class VendorIngredientPrices extends Vendor{
    private Vendor vendor;
    private Ingredient ingredient;
    private double costPerUnit;


    public VendorIngredientPrices(){
        super();
    };
    public VendorIngredientPrices(Vendor vendor, Ingredient ingredient, double costPerUnit) {

        setVendor(vendor);
        setIngredient(ingredient);
        setCostPerUnit(costPerUnit);
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
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
}

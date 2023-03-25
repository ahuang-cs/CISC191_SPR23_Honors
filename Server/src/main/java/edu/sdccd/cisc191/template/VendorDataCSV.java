package edu.sdccd.cisc191.template;

import java.util.ArrayList;
import java.util.List;

public class VendorDataCSV implements VendorData {
    private Vendors vendor;
    public VendorDataCSV(Vendors newVendor) {
        vendor = newVendor;
    }

    @Override
    public List<VendorIngredientPrices> importVendorIngredients() {
        //Create a list of  different vendor name, product and cost

        List<VendorIngredientPrices> newIngredientPrices = new ArrayList<>();
        Ingredient ingredient = new Ingredient("Sugar      ", Ingredient.Units.LB,30.0);
        VendorIngredientPrices vendorIngredientPrices = new VendorIngredientPrices(vendor, ingredient, 9.99, "coffee");
        newIngredientPrices.add(vendorIngredientPrices);


        Ingredient ingredient1 = new Ingredient("Coffee Bean", Ingredient.Units.LB,55.0);
        VendorIngredientPrices vendorIngredientPrices1 = new VendorIngredientPrices(vendor, ingredient1, 6.99, "coffee");
        newIngredientPrices.add(vendorIngredientPrices1);

        Ingredient ingredient2 = new Ingredient("Milk     ", Ingredient.Units.GAL,25.0);
        VendorIngredientPrices vendorIngredientPrices2 = new VendorIngredientPrices(vendor, ingredient2,3.99, "coffee");
        newIngredientPrices.add(vendorIngredientPrices2);

        Ingredient ingredient3 = new Ingredient("Flour     ", Ingredient.Units.LB,10.0);
        VendorIngredientPrices vendorIngredientPrices3 = new VendorIngredientPrices(vendor, ingredient3,1.99, "donut");
        newIngredientPrices.add(vendorIngredientPrices3);

        Ingredient ingredient4 = new Ingredient("Sprinkles", Ingredient.Units.GAL,2.0);
        VendorIngredientPrices vendorIngredientPrices4 = new VendorIngredientPrices(vendor, ingredient4,4.99, "donut");
        newIngredientPrices.add(vendorIngredientPrices4);

        Ingredient ingredient5 = new Ingredient("Ham     ", Ingredient.Units.LB,5.0);
        VendorIngredientPrices vendorIngredientPrices5 = new VendorIngredientPrices(vendor, ingredient5,10.99, "sandwich");
        newIngredientPrices.add(vendorIngredientPrices5);

        Ingredient ingredient6 = new Ingredient("Bread     ", Ingredient.Units.LB,10.0);
        VendorIngredientPrices vendorIngredientPrices6 = new VendorIngredientPrices(vendor, ingredient6,2.99, "sandwich");
        newIngredientPrices.add(vendorIngredientPrices6);

        Ingredient ingredient7 = new Ingredient("Cheese     ", Ingredient.Units.LB,10.0);
        VendorIngredientPrices vendorIngredientPrices7 = new VendorIngredientPrices(vendor, ingredient7,5.99, "sandwich");
        newIngredientPrices.add(vendorIngredientPrices7);
        return newIngredientPrices;
    }
}

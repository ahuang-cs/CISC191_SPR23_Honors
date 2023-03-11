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
            VendorIngredientPrices vendorIngredientPrices = new VendorIngredientPrices(vendor, ingredient, 9.99);
            newIngredientPrices.add(vendorIngredientPrices);


            Ingredient ingredient1 = new Ingredient("Coffee Bean", Ingredient.Units.LB,55.0);
            VendorIngredientPrices vendorIngredientPrices1 = new VendorIngredientPrices(vendor, ingredient1, 6.99);
            newIngredientPrices.add(vendorIngredientPrices1);


            Ingredient ingredient2 = new Ingredient("Milk     ", Ingredient.Units.GAL,25.0);
            VendorIngredientPrices vendorIngredientPrices2 = new VendorIngredientPrices(vendor, ingredient2,3.99 );
            newIngredientPrices.add(vendorIngredientPrices2);

            return newIngredientPrices;
        }
}

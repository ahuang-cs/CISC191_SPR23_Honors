package edu.sdccd.cisc191.template;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
class VendorIngredientPricesTest
{
    @Test
    public void vendorIngredientPricesTest() {
        Vendors vendor = new Vendors();

        Ingredient ingredient = new Ingredient();
        vendor.name = "Kirkland";
        ingredient.ingredientName = "flour";
        ingredient.unit = Ingredient.Units.LB;
        double costPerUnit = 4.99;

        VendorIngredientPrices vendorIngredientPrices2 = new VendorIngredientPrices(vendor, ingredient, costPerUnit);

        assertEquals("Kirkland", vendor.getName());
        assertEquals("flour", ingredient.getIngredientName());
        assertEquals(Ingredient.Units.LB, ingredient.unit);
        assertEquals(4.99, vendorIngredientPrices2.getCostPerUnit());

    }

    public void vendorsTest() {
        Vendors vendors = new Vendors("Target");
        assertEquals("Target", vendors.getName());
    }
  
}
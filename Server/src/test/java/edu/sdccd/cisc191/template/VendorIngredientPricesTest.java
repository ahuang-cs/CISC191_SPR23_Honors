package edu.sdccd.cisc191.template;

import edu.sdccd.cisc191.template.Ingredient.Ingredient;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
class VendorIngredientPricesTest
{
    @Test
    public void vendorIngredientPricesTest() {
        Vendor vendor = new Vendor();

        Ingredient ingredient = new Ingredient();
        vendor.name = "Kirkland";
        ingredient.setName("flour") ;
        ingredient.setUnit(Ingredient.Units.LB);
        double costPerUnit = 4.99;

        VendorIngredientPrices vendorIngredientPrices2 = new VendorIngredientPrices(vendor, ingredient, costPerUnit);

        assertEquals("Kirkland", vendor.getName());
        assertEquals("flour", ingredient.getIngredientName());
        assertEquals(Ingredient.Units.LB, ingredient.getUnit());
        assertEquals(4.99, vendorIngredientPrices2.getCostPerUnit());

    }

    public void vendorsTest() {
        Vendor vendor = new Vendor("Target");
        assertEquals("Target", vendor.getName());
    }
  
}
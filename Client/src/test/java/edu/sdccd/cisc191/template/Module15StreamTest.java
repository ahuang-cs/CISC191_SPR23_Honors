package edu.sdccd.cisc191.template;

import edu.sdccd.cisc191.template.Ingredient.Ingredient;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static edu.sdccd.cisc191.template.CoffeeShop.inventory;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Module15StreamTest {
    //Module 15: Test Stream API
    @Test
    void getLowestIngredientPrices() throws IOException {

        List<WalmartCSV> walmartList = new ArrayList<>();

        WalmartCSV walmart1 = new WalmartCSV("Flour", Ingredient.Units.LB, 1.99);
        walmartList.add(walmart1);

        WalmartCSV walmart2 = new WalmartCSV("Coffee Beans", Ingredient.Units.LB, 3.99);
        walmartList.add(walmart2);

        List<CostcoCSV> costcoList = new ArrayList<>();
        CostcoCSV costco1 = new CostcoCSV("Flour", Ingredient.Units.LB, 1.59);
        costcoList.add(costco1);

        CostcoCSV costco2 = new CostcoCSV("Coffee Beans", Ingredient.Units.LB, 4.99);
        costcoList.add(costco2);

        //after using Stream API to filter the lowest prices from costcoList and walmartList, we add the results into this list
        List<String> results = new ArrayList<>();

        List<Ingredient> allIngredients = inventory.getIngredientList();
        allIngredients.forEach(ingredient -> {
            double costcoPrice = costcoList.parallelStream()
                    .filter(costcoIngredient -> ingredient.getIngredientName()
                                                            .equalsIgnoreCase(costcoIngredient
                                                                    .getIngredientName()))
                    .mapToDouble(CostcoCSV::getPrice)
                    .findFirst()
                    .orElse(Double.MAX_VALUE);

            double walmartPrice = walmartList.parallelStream()
                    .filter(walmartIngredient -> ingredient.getIngredientName()
                                                            .equalsIgnoreCase(walmartIngredient
                                                                    .getIngredientName()))
                    .mapToDouble(WalmartCSV::getPrice)
                    .findFirst()
                    .orElse(Double.MAX_VALUE);

            if (costcoPrice == Double.MAX_VALUE && walmartPrice == Double.MAX_VALUE) {
                System.out.printf("%-15s%-10s\n", ingredient.getIngredientName(), "could not find price in vendors");
                results.add(ingredient.getIngredientName() + " could not find price in vendors");
            } else if (costcoPrice == walmartPrice) {
                System.out.printf("%-15s%-10s%-10s\n", ingredient.getIngredientName(), costcoPrice, "Same price");
                results.add(ingredient.getIngredientName() + " " + costcoPrice + " same price");
            } else if (costcoPrice < walmartPrice) {
                System.out.printf("%-15s%-10s%-10s\n", ingredient.getIngredientName(), costcoPrice, "Costco");
                results.add(ingredient.getIngredientName() + " " + costcoPrice + " Costco");
            } else if (walmartPrice < costcoPrice) {
               System.out.printf("%-15s%-10s%-10s\n", ingredient.getIngredientName(), walmartPrice, "Walmart");
               results.add(ingredient.getIngredientName() + " " + walmartPrice + " Walmart");
            }
        });
        assertEquals(8, results.size());
        assertEquals("Coffee Beans 3.99 Walmart", results.get(0));
        assertEquals("Creamer could not find price in vendors", results.get(1));
        assertEquals("Sugar could not find price in vendors", results.get(2));
        assertEquals("Flour 1.59 Costco", results.get(3));
        assertEquals("Butter could not find price in vendors", results.get(4));
        assertEquals("Eggs could not find price in vendors", results.get(5));
        assertEquals("Yeast could not find price in vendors", results.get(6));
        assertEquals("Milk could not find price in vendors", results.get(7));

    }
}
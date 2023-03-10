package edu.sdccd.cisc191.template;

/*
 * This class contains all unit tests for InventoryManager.java
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventoryManagerTest
{

    // Testing the InventoryManager constructor
    @Test
    void InventoryManagerConstructorTest()
    {
        // Create a new InventoryManager object called inventory
        InventoryManager inventory = new InventoryManager();

        // A new InventoryManager object should have no ingredients, menu items, or recipes.
        assertEquals(0, inventory.getIngredientList().length);
        assertEquals(0, inventory.getMenuItemList().length);
    }

    @Test
    void addIngredientTest()
    {
        // Create a new InventoryManager object.
        InventoryManager inventory = new InventoryManager();

        // Add some test ingredients.
        inventory.addIngredient("Flour", 8);
        inventory.addIngredient("Coffee", 2);
        inventory.addIngredient("Milk", 12);

        // There should now be three ingredients in the ingredient array.
        assertEquals(3, inventory.getIngredientList().length);

        // Test to ensure that the ingredientList array has been properly filled.
        assertEquals("Flour", inventory.getIngredientList()[0]);
        assertEquals("Coffee", inventory.getIngredientList()[1]);
        assertEquals("Milk", inventory.getIngredientList()[2]);
    }
}
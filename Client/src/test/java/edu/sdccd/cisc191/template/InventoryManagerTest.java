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
    void addIngredientTest() throws ItemNotFoundException
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
        assertEquals("flour", inventory.getIngredientList()[0]);
        assertEquals("coffee", inventory.getIngredientList()[1]);
        assertEquals("milk", inventory.getIngredientList()[2]);

        // Test to ensure that the ingredientInventory has been properly filled.
        assertEquals(8, inventory.getIngredientAmount("Flour"));
        assertEquals(2, inventory.getIngredientAmount("Coffee"));
        assertEquals(12, inventory.getIngredientAmount("Milk"));

        // Test that the method can alter the amounts of existing ingredients.
        inventory.addIngredient("Milk", 24);

        assertEquals(36, inventory.getIngredientAmount("milk"));

    }
}
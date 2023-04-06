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

        // There should be nothing in the Ingredient List.
        assertEquals(0, inventory.getIngredientList().length);

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


    @Test
    void getIngredientAmountExceptionTest()
    {
        InventoryManager inv = new InventoryManager();

        // Check searching for an ingredient in an empty list.
        assertThrows(ItemNotFoundException.class, () -> inv.getIngredientAmount("Beans"));

        // Check searching for an ingredient in a working inventory.

        inv.addIngredient("Beans", 2);
        inv.addIngredient("Tomatoes", 3);
        inv.addIngredient("Rice", 20);

        // Cheese is not an ingredient in the list, so it should throw an exception.
        assertThrows(ItemNotFoundException.class, () -> inv.getIngredientAmount("Cheese"));

        // Rice is an ingredient in the list, so it should not throw an exception.
        assertDoesNotThrow(() -> inv.getIngredientAmount("Rice"));
    }


    @Test
    void setIngredientAmountTest() throws ItemNotFoundException
    {
        // Create a new inventory manager object
        InventoryManager inventory = new InventoryManager();

        // Attempt to set an ingredient amount for an empty inventory.
        assertThrows(ItemNotFoundException.class, () -> inventory.setIngredientAmount("Beans", 9));

        // Add ingredients to the inventoryManager.
        inventory.addIngredient("Cheese", 10);
        inventory.addIngredient("Celery", 100);
        inventory.addIngredient("Avocados", 12);

        // Verify initial amounts
        assertEquals(10, inventory.getIngredientAmount("Cheese"));
        assertEquals(100, inventory.getIngredientAmount("Celery"));
        assertEquals(12, inventory.getIngredientAmount("Avocados"));

        // Change the values of each ingredient.
        inventory.setIngredientAmount("Cheese", 8);
        inventory.setIngredientAmount("Celery", 80);
        inventory.setIngredientAmount("Avocados", 20);

        // Verify that each ingredient has a new value.
        assertEquals(8, inventory.getIngredientAmount("Cheese"));
        assertEquals(80, inventory.getIngredientAmount("Celery"));
        assertEquals(20, inventory.getIngredientAmount("Avocados"));

        // Verify that changing an existing value does not throw an exception.
        assertDoesNotThrow(() -> inventory.setIngredientAmount("Avocados", 17));

        // Verify that changing a nonexistent value does throw an exception
        assertThrows(ItemNotFoundException.class, () -> inventory.setIngredientAmount("Ice", 9));
    }


    @Test
    void addMenuItemTest() throws ItemNotFoundException
    {
        // Create a new InventoryManager object to test
        InventoryManager inventory = new InventoryManager();

        // Create menu items
        MenuItem cake = new MenuItem("Cake", 3.99);
        MenuItem coffee = new MenuItem("Coffee", 4.99);
        MenuItem tea = new MenuItem("Tea", 3.00);

        // Add menu items to the inventory
        inventory.addMenuItem(cake, 8);
        inventory.addMenuItem(coffee, 20);
        inventory.addMenuItem(tea, 18);

        // There should now be three menu items in the menu item array.
        assertEquals(3, inventory.getMenuItemList().length);

        // Test to ensure that the menu items in the menu item array have been properly set
        assertEquals("Cake", inventory.getMenuItemList()[0].getName());
        assertEquals("Coffee", inventory.getMenuItemList()[1].getName());
        assertEquals("Tea", inventory.getMenuItemList()[2].getName());

        assertEquals(3.99, inventory.getMenuItemList()[0].getSalePrice());
        assertEquals(4.99, inventory.getMenuItemList()[1].getSalePrice());
        assertEquals(3.00, inventory.getMenuItemList()[2].getSalePrice());

        // Test to ensure that the 2D inventory array has been properly filled
        assertEquals(8, inventory.getMenuItemAmount("Cake"));
        assertEquals(20, inventory.getMenuItemAmount("Coffee"));
        assertEquals(18, inventory.getMenuItemAmount("Tea"));

        // Test that the method can alter the amounts of existing ingredients.
        inventory.addMenuItem(cake, 32);

        assertEquals(40, inventory.getMenuItemAmount("Cake"));
    }

    @Test
    void getMenuItemAmountExceptionTest()
    {
        InventoryManager inv = new InventoryManager();

        // Check searching for a menu item in an empty list.
        assertThrows(ItemNotFoundException.class, () -> inv.getMenuItemAmount("Croissant"));

        // Check searching for an menu item in a working inventory.

        MenuItem cake = new MenuItem("Cake", 12.00);
        MenuItem pie = new MenuItem("Pie", 16.99);
        MenuItem lemonade = new MenuItem("Lemonade", 3.99);

        inv.addMenuItem(cake, 2);
        inv.addMenuItem(pie, 3);
        inv.addMenuItem(lemonade, 20);

        // Cheese is not an ingredient in the list, so it should throw an exception.
        assertThrows(ItemNotFoundException.class, () -> inv.getMenuItemAmount("soda"));

        // Rice is an ingredient in the list, so it should not throw an exception.
        assertDoesNotThrow(() -> inv.getMenuItemAmount("pie"));
    }

    @Test
    void setMenuItemAmountTest() throws ItemNotFoundException
    {
        // Create a new inventory manager object
        InventoryManager inventory = new InventoryManager();

        // Attempt to set an MenuItem amount for an empty inventory.
        assertThrows(ItemNotFoundException.class, () -> inventory.setMenuItemAmount("Cake", 9));

        // Add MenuItems to the inventoryManager.
        MenuItem coffee = new MenuItem("Coffee", 5.99);
        MenuItem tea = new MenuItem("Tea", 5.99);
        MenuItem hotChocolate = new MenuItem("Hot Chocolate", 5.99);

        inventory.addMenuItem(coffee, 10);
        inventory.addMenuItem(tea, 100);
        inventory.addMenuItem(hotChocolate, 12);

        // Verify initial amounts
        assertEquals(10, inventory.getMenuItemAmount(coffee.getName()));
        assertEquals(100, inventory.getMenuItemAmount(tea.getName()));
        assertEquals(12, inventory.getMenuItemAmount(hotChocolate.getName()));

        // Change the values of each ingredient.
        inventory.setMenuItemAmount(coffee.getName(), 8);
        inventory.setMenuItemAmount(tea.getName(), 80);
        inventory.setMenuItemAmount(hotChocolate.getName(), 20);

        // Verify that each ingredient has a new value.
        assertEquals(8, inventory.getMenuItemAmount(coffee.getName()));
        assertEquals(80, inventory.getMenuItemAmount(tea.getName()));
        assertEquals(20, inventory.getMenuItemAmount(hotChocolate.getName()));

        // Verify that changing an existing value does not throw an exception.
        assertDoesNotThrow(() -> inventory.setMenuItemAmount(tea.getName(), 17));

        // Verify that changing a nonexistent value does throw an exception
        assertThrows(ItemNotFoundException.class, () -> inventory.setMenuItemAmount("Yogurt", 9));
    }

    // @Test
    // void addToRecipeAndGetRecipeTest()
    // {
    //
    // }
}
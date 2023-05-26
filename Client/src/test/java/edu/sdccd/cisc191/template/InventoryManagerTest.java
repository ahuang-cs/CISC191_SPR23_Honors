package edu.sdccd.cisc191.template;

/*
 * This class contains all unit tests for edu.sdccd.cisc191.template.InventoryManager.java
 */

import edu.sdccd.cisc191.template.Ingredient.Ingredient;
import edu.sdccd.cisc191.template.MenuItem.MenuItem;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InventoryManagerTest
{
    //Module 8/12: networking test
    //a request is made to the server in the getIngredientData() method, and the response is converted to a list
    // Integrated with collections
    @Test
    void networkingTest(){
        InventoryManager inventory = new InventoryManager();
        Ingredient[] serverIngredients = inventory.getIngredientData();
        List<Ingredient> actualList = new ArrayList<>();
        for(Ingredient ingredient:serverIngredients){
            actualList.add(ingredient);
        }
        List<Ingredient> ingredientList= new ArrayList<>();
        ingredientList.add(new Ingredient("Coffee Beans", Ingredient.Units.LB, 40));
        ingredientList.add(new Ingredient("Creamer", Ingredient.Units.fluidOZ, 40));
        ingredientList.add(new Ingredient("Sugar", Ingredient.Units.LB, 40));
        ingredientList.add(new Ingredient("Flour", Ingredient.Units.LB, 40));
        ingredientList.add(new Ingredient("Butter", Ingredient.Units.LB, 40));
        ingredientList.add(new Ingredient("Eggs", Ingredient.Units.NUM, 40));
        ingredientList.add(new Ingredient("Yeast", Ingredient.Units.TSP, 40));
        ingredientList.add(new Ingredient("Milk", Ingredient.Units.CUP, 40));
        assertEquals(actualList.toString(), ingredientList.toString());
    }
    //Module 9: collections test
    //ingredients are stored in a list, and is manipulated through inventory manager methods which perform actions on the list
    //Connected with JavaFX
    @Test
    void setIngredientAmountTest() throws ItemNotFoundException
    {
        // Create a new inventory manager object
        InventoryManager inventory = new InventoryManager();

        // Attempt to set an ingredient amount for an empty inventory.
        assertThrows(ItemNotFoundException.class, () -> inventory.setIngredientAmount("Beans", 9.00));

        // Verify initial amounts
        assertEquals(40.0, inventory.getIngredientAmount("Creamer"));
        assertEquals(40.0, inventory.getIngredientAmount("Sugar"));
        assertEquals(40.0, inventory.getIngredientAmount("Flour"));

        // Change the values of each ingredient.
        inventory.setIngredientAmount("Creamer", 8);
        inventory.setIngredientAmount("Sugar", 80);
        inventory.setIngredientAmount("Flour", 20);

        // Verify that each ingredient has a new value.
        assertEquals(8, inventory.getIngredientAmount("Creamer"));
        assertEquals(80, inventory.getIngredientAmount("Sugar"));
        assertEquals(20, inventory.getIngredientAmount("Flour"));

        // Verify that changing an existing value does not throw an exception.
        assertDoesNotThrow(() -> inventory.setIngredientAmount("Creamer", 17.0));

        // Verify that changing a nonexistent value does throw an exception
        assertThrows(ItemNotFoundException.class, () -> inventory.setIngredientAmount("Ice", 9));
    }
    //Module 10: linked list test and recursion
    //uses the inventory addMenuItem method which manipulates the linked list which stores menu items,
    //and uses a recursive contains method to check if there is already and item with the same name

    //integrated with javaFX
    @Test
    void addMenuItemTest() throws ItemNotFoundException
    {
        // Create a new edu.sdccd.cisc191.template.InventoryManager object to test
        InventoryManager inventory = new InventoryManager();

        // Create menu items
        MenuItem cake = new MenuItem();
        cake.setName("Cake");
        cake.setSalePrice(3.99);
        cake.setQuantity(8);
        MenuItem coffee = new MenuItem();
        coffee.setName("Coffee");
        coffee.setSalePrice(4.99);
        coffee.setQuantity(20);
        MenuItem tea = new MenuItem();
        tea.setName("Tea");
        tea.setSalePrice(3.00);
        tea.setQuantity(18);

        // Add menu items to the inventory
        inventory.addMenuItem(cake);
        inventory.addMenuItem(coffee);
        inventory.addMenuItem(tea);

        // There should now be three menu items in the menu item array.
        assertEquals(3, inventory.getMenuItemList().size());

        // Test to ensure that the menu items in the menu item array have been properly set
        assertEquals("Cake", inventory.getMenuItemList().get(2).getName());
        assertEquals("Coffee", inventory.getMenuItemList().get(1).getName());
        assertEquals("Tea", inventory.getMenuItemList().get(0).getName());

        assertEquals(3.99, inventory.getMenuItemList().get(2).getSalePrice());
        assertEquals(4.99, inventory.getMenuItemList().get(1).getSalePrice());
        assertEquals(3.00, inventory.getMenuItemList().get(0).getSalePrice());

        // Test to ensure that the 2D inventory array has been properly filled
        assertEquals(8, inventory.getMenuItemAmount("Cake"));
        assertEquals(20, inventory.getMenuItemAmount("Coffee"));
        assertEquals(18, inventory.getMenuItemAmount("Tea"));
    }
    //Module 13: Concurrency
    @Test
    void testInventoryManager()
    {
        InventoryManager inventoryManager = new InventoryManager();
        Ingredient ingredient1 = new Ingredient();
        //subtracting the 8 ingredients that are loaded in from the spring server
        assertEquals(0, inventoryManager.getNumberOfIngredients()-8);
        inventoryManager.addIngredient(ingredient1);
        assertEquals(1, inventoryManager.getNumberOfIngredients()-8);
        assertEquals(ingredient1, inventoryManager.deleteIngredient(ingredient1.getIngredientName()));
        assertEquals(0, inventoryManager.getNumberOfIngredients()-8);
        Ingredient ingredient2 = new Ingredient();
        Ingredient ingredient3 = new Ingredient();
        inventoryManager.addIngredient(ingredient2);
        inventoryManager.addIngredient(ingredient3);
        assertEquals(2, inventoryManager.getNumberOfIngredients()-8);
        assertEquals(ingredient3, inventoryManager.deleteIngredient(ingredient3.getIngredientName()));
        assertEquals(ingredient2, inventoryManager.deleteIngredient(ingredient2.getIngredientName()));
        assertEquals(0, inventoryManager.getNumberOfIngredients()-8);
    }
    /**
     * In this test we are simulating many producers creating items sequentially
     * that are then stored in a warehouse.
     */
    @Test
    void testProducingSequentially()
    {
        InventoryManager inventoryManager = new InventoryManager();
        long startTime = System.nanoTime();

        int numberOfProducers = 10000;
        int numberOfItemsPerProducer = 100;
        Producer[] producers = new Producer[numberOfProducers];
        for (int i = 0; i < numberOfProducers; i++)
        {
            producers[i] = new Producer("Producer Ingredient " + i, inventoryManager, numberOfItemsPerProducer);
        }

        // Execute all the producers in the current thread
        for (int i = 0; i < numberOfProducers; i++)
        {
            producers[i].run();
        }
        long endTime = System.nanoTime();
        System.out.println(endTime-startTime);
        // There should be numberOfProducers*numberOfItemsPerProducer items at the warehouse
        assertEquals(numberOfProducers * numberOfItemsPerProducer, inventoryManager.getNumberOfIngredients()-8);
        try
        {
            String filename= "SequentialData.txt";
            FileWriter fw = new FileWriter(filename,true); //the true will append the new data
            fw.write(endTime-startTime+" //"+numberOfItemsPerProducer+" number of items per producer\n");//appends the string to the file
            fw.close();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    void testProducingConcurrently() throws InterruptedException
    {
        InventoryManager inventoryManager = new InventoryManager();
        long startTime = System.nanoTime();

        // You may have to run this test multiple times for it to fail
        // If the program does not run, reduce the following numbers
        // If the test does not fail, increase the following numbers
        int numberOfProducers = 10000;
        int numberOfItemsPerProducer = 100;
        Producer[] producers = new Producer[numberOfProducers];
        for (int i = 0; i < numberOfProducers; i++)
        {
            producers[i] = new Producer("Producer" + i, inventoryManager, numberOfItemsPerProducer);
        }

        // Execute all the producers in separate threads
        for (int i = 0; i < numberOfProducers; i++)
        {
            producers[i].start();
        }

        // Wait for producers to complete
        for (int i = 0; i < numberOfProducers; i++)
        {
            producers[i].join();
        }
        long endTime = System.nanoTime();
        System.out.println(endTime-startTime);
        try
        {
            String filename= "ConcurrentData.txt";
            FileWriter fw = new FileWriter(filename,true); //the true will append the new data
            fw.write(endTime-startTime+" //"+numberOfItemsPerProducer+" number of items per producer Error:"+(inventoryManager.getNumberOfIngredients()-8-numberOfProducers * numberOfItemsPerProducer)+"\n");//appends the string to the file
            fw.close();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

        // There should be numberOfProducers*numberOfItemsPerProducer items at the warehouse
        assertEquals(numberOfProducers * numberOfItemsPerProducer, inventoryManager.getNumberOfIngredients()-8);
    }

    //Module 14/15: Lambdas/stream api
    @Test
    public void generateData(){

    }



    @Test
    void setMenuItemAmountTest() throws ItemNotFoundException
    {
        // Create a new inventory manager object
        InventoryManager inventory = new InventoryManager();

        // Attempt to set an MenuItem amount for an empty inventory.
        assertThrows(ItemNotFoundException.class, () -> inventory.setMenuItemAmount("Cake", 9));

        // Add MenuItems to the inventoryManager.
        MenuItem coffee = new MenuItem();
        coffee.setName("Coffee");
        coffee.setSalePrice(3.99);
        coffee.setQuantity(10);
        MenuItem tea = new MenuItem();
        tea.setName("Tea");
        tea.setSalePrice(4.99);
        tea.setQuantity(100);
        MenuItem hotChocolate = new MenuItem();
        hotChocolate.setName("Hot Chocolate");
        hotChocolate.setSalePrice(3.00);
        hotChocolate.setQuantity(12);

        inventory.addMenuItem(coffee);
        inventory.addMenuItem(tea);
        inventory.addMenuItem(hotChocolate);

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
}
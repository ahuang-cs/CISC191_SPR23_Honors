package edu.sdccd.cisc191.template;

import edu.sdccd.cisc191.template.Ingredient.Ingredient;
import sun.management.counter.Units;

public class Producer extends Thread
{
    private String name;
    private InventoryManager inventoryManager;
    private int numberOfItemsToProduce;

    public Producer(String givenName, InventoryManager givenInventoryManager, int givenNumberOfItemsToProduce)
    {
        name = givenName;
        inventoryManager = givenInventoryManager;
        numberOfItemsToProduce = givenNumberOfItemsToProduce;
    }

    @Override
    public void run()
    {
        //System.out.println(name + " running in Thread: " + Thread.currentThread().getName());
        for(int i=0; i<numberOfItemsToProduce; i++){
            inventoryManager.addIngredient(new Ingredient(name+i, Ingredient.Units.NUM, 5));
        }
        //System.out.println(name + " ended.");
    }

}

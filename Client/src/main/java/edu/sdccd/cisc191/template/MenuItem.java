package edu.sdccd.cisc191.template;

import java.util.ArrayList;     // Allows for dynamic resizing of arrays

/*
    The MenuItem class will be an abstract class representing all menu items. Currently in progress.
    Will serve as a framework for subclasses prior to abstraction and conversion.

    All MenuItem objects should contain:
        - Item Name (String)
        - Item Recipe (Array of Ingredients)

    Subclass Ideas:
        - Drink sizes (affects ingredient requirements)
        - Flavors / Variants
        - Create Boolean for hot and cold drinks

    Abstract Classes Ideas
        - Subclasses will have tags that alter ingredients as needed (e.g. sugar free removes sugar, etc.)

    We'll probably want our INGREDIENT class to have a null ingredient in order to allow for future stuff.



    TODO:   Create functional MenuItem Class
            Add subclasses of MenuItem
            Make MenuItem an abstract class, adjust children accordingly
 */

public class MenuItem
{
    private String itemName;            // Name of this menuItem (Cannot be changed later)
    private double salePrice;           // Price of menu item
    private ArrayList<String> recipe;   // Holds ingredients to make this menuItem

    /**
     * Default Constructor
     * Fills all fields with empty / null values.
     */
    public MenuItem()
    {
        itemName = "";
        salePrice = 0.0;
        recipe = new ArrayList<String>();
    }

    /**
     * This is the constructor for MenuItem objects.
     * @param name The name of the Menu Item.
     */
    public MenuItem(String name, double salePrice)
    {
        this.itemName = name;
        this.salePrice = salePrice;
        recipe = new ArrayList<String>();
    }

    /**
     * This method returns the name of a menu item.
     * @return String representing name of menu item.
     */
    public String getName()
    {
        return itemName;
    }

    /**
     * This method sets the name of a menu item
     * @param name The new name of the menu item.
     */
    public void setName(String name)
    {
        itemName = name;
    }

    /**
     * This method prints out a string representing this menuItem object.
     * @return The Menu Item's name.
     */
    public String toString()
    {
        // TODO: Print all relevant information (Ingredients, etc.).
        return itemName;
    }


}

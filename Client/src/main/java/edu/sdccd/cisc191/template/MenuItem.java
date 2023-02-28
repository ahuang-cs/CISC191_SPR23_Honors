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
     * Fills all fields with empty known values.
     */
    public MenuItem()
    {
        itemName = "";
        salePrice = 0.0;
        recipe = new ArrayList<>();
    }

    /**
     * This is the constructor for MenuItem objects.
     * @param name The name of the Menu Item.
     */
    public MenuItem(String name, double salePrice)
    {
        this.itemName = name;
        this.salePrice = salePrice;
        recipe = new ArrayList<>();
    }

    /**
     * Adds an ingredient to a MenuItem's recipe
     * @param ingredient The ingredient to be added to the menu item's recipe.
     */
    public void addToRecipe(String ingredient)
    {
        // Check whether the recipe already contains the specified ingredient.
        if (!(recipe.contains(ingredient)))
        {
            // If the ingredient is not already in the array, add it.
            recipe.add(ingredient);
        }


        // TODO:    Consider throwing an exception when trying to add ingredients that are already there.

        // TODO:    Change this method to include Ingredient objects instead of Strings.
    }

    /**
     * Removes an ingredient from the recipe.
     * @param ingredient The ingredient to be removed.
     */
    public void removeFromRecipe(String ingredient)
    {
        // Check whether the ingredient is in the recipe array.
        if (recipe.contains(ingredient))
        {
            // If the ingredient is in the recipe array, remove it.
            recipe.remove(ingredient);
        }

        // TODO: Consider throwing an exception when trying to remove an ingredient that is not in the recipe

        // TODO: Change this method to include Ingredient objects instead of Strings.
    }

    /**
     * Deletes all ingredients within the Recipe ArrayList.
     */
    public void clearRecipe()
    {
        recipe.clear();
    }

    /**
     * Returns a list of ingredients to make the menu item as an array.
     * TODO: Review implementation (Do we want to return array, individual ingredients, etc.)
     * @return An ArrayList of ingredients to make the menu item.
     */
    public String[] getRecipe()
    {
        // For security reasons, we want to limit other classes from having access to our recipe ArrayList.
        // This method transfers the recipe into a separate array for access outside of this class.
        // That way, this method can only read from the ArrayList.

        // Create a new array
        String[] ingredientList = new String[recipe.size()];

        // Transfer each element of the recipe ArrayList to the corresponding index of the new array.
        for (int i = 0; i < recipe.size(); i++)
        {
            ingredientList[i] = recipe.get(i);
        }

        // Return the new array.
        return ingredientList;
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
     * This method returns the sale price of a menu item.
     * @return The sale price of this menu item.
     */
    public double getSalePrice()
    {
        return salePrice;
    }

    /**
     * This method sets the name of a menu item
     * @param name String containing the new name of the menu item.
     */
    public void setName(String name)
    {
        itemName = name;
    }

    /**
     * This method changes the sale price for a menu item.
     * @param newPrice Double containing new value for the menu item's sale price.
     */
    public void setSalePrice(double newPrice)
    {
        // TODO: Consider adding input validation to prevent negative input.
        salePrice = newPrice;
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

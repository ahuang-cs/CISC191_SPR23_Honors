package edu.sdccd.cisc191.template;

/*
    The MenuItem class will be an abstract class representing all menu items.

    MenuItem objects should contain:
        - Item Name (String)
        - Item Recipe (Array of Ingredients)

    Subclass Ideas:
        - Drink sizes (affects ingredient requirements)
        - Flavors / Variants

    TODO:   Create functional MenuItem Class
            Add subclasses of MenuItem
            Make MenuItem an abstract class, adjust children accordingly
 */

public class MenuItem
{
    private String itemName;        // Name of this menuItem (Cannot be changed later)

    // Constructor
    public MenuItem(String name)
    {
        itemName = name;
    }

    public String getName()
    {
        return itemName;
    }

    public String toString()
    {
        return itemName;
    }


}

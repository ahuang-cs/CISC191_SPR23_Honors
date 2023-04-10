package edu.sdccd.cisc191.template;

import edu.sdccd.cisc191.template.MenuItem.MenuItem;

public class Drink extends MenuItem {

    private String size;        // Drink size (Small, Medium, Large)
    private boolean isHot;      // Whether the drink is hot (true) or cold (false).

    // Default Constructor
    public Drink()
    {
        super();
        this.size = "small";
        this.isHot = false;
    }

    /**
     * Constructor
     * @param name The name of the drink
     * @param size The size of the drink (Small, Medium, Large)
     * @param isHot Whether the drink is hot (true) or cold (false).
     */
    public Drink(String name, double salePrice, String size, boolean isHot){
        super(name, salePrice);
        this.size = size;
        this.isHot = isHot;
    }

    /**
     * This method changes the size of the drink to a specified value (Small, Medium, Large).
     * @param newSize The new value for the size.
     */
    public void setSize(String newSize)
    {
        size = newSize;
    }

    /**
     * This method changes whether the drink is classified as a hot drink (true) or not.
     * @param isHot True if the drink is hot, false if not.
     */
    public void setHeatValue(boolean isHot)
    {
        this.isHot = isHot;
    }


    /**
     * This method returns the size of a drink object.
     * @return The size of a drink object (Small, Medium, Large, etc.)
     */
    public String getSize()
    {
        return size;
    }

    /**
     * This method returns true if the drink is hot, otherwise it will return false.
     * @return Boolean representing whether or not the drink is hot.
     */
    public boolean getHeatValue()
    {
        return isHot;
    }

    /**
     * String representation of this drink object.
     * @return String containing size and name of drink
     */
    public String toString()
    {
        return size + " " + this.getName();
    }
}

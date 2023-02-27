package edu.sdccd.cisc191.template;

/*
    The Drink class will be an abstract class representing all drinks.
    Currently in progress.
    Will serve as a framework for subclasses prior to abstraction and conversion.

    Drinks should include:
        - Type (Hot/Cold)
        - Sizes (Large/ Medium/ Small)
        - SugarFree (Contains Aspartame)

    Example:
        Coffee
            TYPE
                - Black
                - Latte
                - Cappuccino
                - Frozen
                - Iced

            INGREDIENTS
                - Sugar
                - Drizzle
                    -Carmel
                    -Mocha
                    -Vanilla
                - Milk
                     -Almond
                     -Coconut
 */


public class Drink extends MenuItem {

    private String size;        // Drink size (Small, Medium, Large)
    private int volume;         // Number of ounces that this drink contains.
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
        // TODO:    Validate user input for acceptable values (small, medium, large, etc.) (FOR REVIEW)
        //          Discard other values and throw error.
        // TODO:    Set volume of drink according to size (Perhaps based on a static final 2D array) (FOR REVIEW)
        size = newSize;
    }

    /**
     * This method changes the volume of the drink to a specified numerical value (oz).
     * @param newVolume The volume of the drink in ounces.
     */
    public void setVolume(int newVolume)
    {
        // TODO: Set size of drink if it matches a value in the table? (FOR REVIEW)
        volume = newVolume;
    }

    /**
     * This method changes whether or not the drink is classified as a hot drink (true) or not.
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
     * This method returns the volume in ounces of a drink object
     * @return The volume of the drink in ounces.
     */
    public int getVolume()
    {
        return volume;
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
        // TODO: Edit this as needed.
        return size + " " + this.getName();
    }

}

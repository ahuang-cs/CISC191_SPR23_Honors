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
    public Drink(String name, String size, boolean isHot){
        super(name);
        this.size = size;
        this.isHot = isHot;
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

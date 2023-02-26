package edu.sdccd.cisc191.template;

/*
    Drinks should include:
        - Type (Hot/Cold)
        - Sizes
        - SugarFree

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

    private String size;
    private boolean isHot;

    // Default Constructor
    public Drink()
    {
        super();
        this.size = "small";
        this.isHot = false;
    }
    public Drink(String name, String size, boolean isHot){
        super(name);
        this.size = size;
        this.isHot = isHot;
    }

}

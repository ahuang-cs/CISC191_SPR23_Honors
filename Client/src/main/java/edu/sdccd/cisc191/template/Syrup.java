package edu.sdccd.cisc191.template;

public class Syrup extends VolumetricIngredient{

    // ********** CONSTANTS **********

    private static final double PUMP_TO_MILLILITERS = 10.0;

    // ********** END OF CONSTANTS **********

    // Default Constructor
    public Syrup()
    {
        super();
    }

    // Complete Constructor
    public Syrup(String name, double amount)
    {
        super(name, amount);
    }


}

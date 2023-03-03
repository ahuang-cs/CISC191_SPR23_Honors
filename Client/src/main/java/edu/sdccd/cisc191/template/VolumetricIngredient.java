package edu.sdccd.cisc191.template;

public class VolumetricIngredient extends Ingredient
{
    // ********** CONSTANTS *********
    private static final double OUNCES_TO_MILLILITERS = 29.57;      // Conversion Factor

    //********** END OF CONSTANTS **********
    private double amount;              // Amount in milliliters
    private boolean isLiquid;           // True if ingredient is liquid, false if solid / powder

    // Default Constructor
    public VolumetricIngredient()
    {
        super();
        // No information, set all values to default / null values.
        amount = 0;
        isLiquid = false;
    }

    // Complete Constructor
    public VolumetricIngredient(String name, double amount)
    {
        super(name);
        this.amount = amount;
    }






}

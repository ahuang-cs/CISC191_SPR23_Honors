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




    /**
     * This method specifies whether the ingredient is a liquid.
     * @param isLiquid Input true if the ingredient is a liquid, false otherwise.
     */
    public void setLiquid(boolean isLiquid)
    {
        this.isLiquid = isLiquid;
    }

    /**
     * This method returns information regarding whether this ingredient is a liquid.
     * @return True if the ingredient is a liquid, false otherwise.
     */
    public boolean getLiquid()
    {
        return isLiquid;
    }

    /**
     * Returns the amount of the ingredient in milliliters
     * @return The volume in milliliters
     */
    public double getAmountMilliliters()
    {
        return amount;
    }

    /**
     * Returns the amount of the ingredient in ounces using conversion factor
     * @return The amount of the ingredient in ounces
     */
    public double getAmountOunces()
    {
        return amount / OUNCES_TO_MILLILITERS;
    }





}

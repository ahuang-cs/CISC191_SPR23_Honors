package edu.sdccd.cisc191.template;

public class WeighedIngredient extends Ingredient{

    // ********** CONSTANTS *********
    private static final double LBS_TO_GRAMS = 453.592;      // Conversion Factor

    //********** END OF CONSTANTS **********

    private double weight;

    // Default constructor.
    public WeighedIngredient()
    {
        super();
        weight = 0;
    }

    // Complete constructor.
    public WeighedIngredient(String name, double weight)
    {
        super(name);
        this.weight = weight;
    }

    public double getAmountGrams()
    {
        return weight;
    }

    /**
     * Returns the amount of the ingredient in lbs using conversion factor
     * @return The amount of the ingredient in lbs
     */
    public double getAmountLbs()
    {
        return weight / LBS_TO_GRAMS;
    }



}

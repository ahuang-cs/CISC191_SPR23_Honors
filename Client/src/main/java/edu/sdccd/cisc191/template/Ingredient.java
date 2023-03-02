package edu.sdccd.cisc191.template;

public class Ingredient
{
    // ********** CLASS FIELDS **********
    private String name;                // The name of the ingredient
    private double unitPrice;           // The unit price of the ingredient
    private String expirationDate;      // The date at which this ingredient expires. (Perhaps change to shelf life?)
    private boolean isLiquid;           // True if ingredient is liquid, false if solid / powder
    private boolean isOrganic;          // True if ingredient is organic, false otherwise
    private boolean hasCaffeine;        // True if ingredient has caffeine, false otherwise
    private boolean hasGluten;          // True if ingredient has gluten, false otherwise
    private boolean veganFriendly;      // True if ingredient has no animal products, false if otherwise

    // ********** END OF CLASS FIELDS **********

    // Default Constructor
    public Ingredient()
    {
        // No information is given, so set all fields to specified empty / null values to prevent unspecified behavior.
        this.name = "";
        this.unitPrice = 0.00;
        this.expirationDate = "";
        this.isLiquid = false;
        this.isOrganic = false;
        this.hasCaffeine = false;
        this.hasGluten = false;
        this.veganFriendly = false;
    }


    // Constructor
    public Ingredient(String name, double price, String expirationDate, boolean isLiquid, boolean isOrganic, boolean hasCaffeine, boolean hasGluten, boolean veganFriendly)
    {
        this.name = name;
        this.unitPrice = price;
        this.expirationDate = expirationDate;
        this.isLiquid = isLiquid;
        this.isOrganic = isOrganic;
        this.hasCaffeine = hasCaffeine;
        this.hasGluten = hasGluten;
        this.veganFriendly = veganFriendly;
    }

    /**
     * This method returns the name of an ingredient.
     * @return the ingredient's name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * This method returns the price per unit of an ingredient
     * @return The unit price of this ingredient
     */
    public double getUnitPrice()
    {
        return unitPrice;
    }

    /**
     * This method returns the expiration date of an ingredient.
     * @return The expiration date of the ingredient.
     */
    public String getExpirationDate()
    {
        return expirationDate;
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
     * Returns whether the ingredient is organic.
     * @return True if the ingredient is organic, false otherwise.
     */
    public boolean getOrganic()
    {
        return isOrganic;
    }


    /**
     * This method returns whether the ingredient has caffeine.
     * @return True if caffeine is present, false otherwise.
     */
    public boolean getCaffeine()
    {
        return hasCaffeine;
    }

    /**
     * This method returns whether the ingredient has gluten.
     * @return True if gluten is present, false otherwise.
     */
    public boolean getGluten()
    {
        return hasGluten;
    }

    /**
     * This method returns whether the ingredient is vegan friendly (Contains no animal products).
     * @return True if vegan friendly, false otherwise.
     */
    public boolean getVeganFriendly()
    {
        return veganFriendly;
    }











}

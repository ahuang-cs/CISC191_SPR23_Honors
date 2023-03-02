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
    public Ingredient(String name, double price, boolean isLiquid, boolean isOrganic, boolean hasCaffeine, boolean hasGluten, boolean veganFriendly)
    {
        this.name = name;
        this.unitPrice = price;
        this.isLiquid = isLiquid;
        this.isOrganic = isOrganic;
        this.hasCaffeine = hasCaffeine;
        this.hasGluten = hasGluten;
        this.veganFriendly = veganFriendly;
    }







}

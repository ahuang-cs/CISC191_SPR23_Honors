package edu.sdccd.cisc191.template;

/*
    Donuts
        -Double Chocolate
        -Chocolate Frosted
        -Strawberry Frosted
        -Vanilla Frosted
        -Glazed
        -Boston Creme
        -Jelly

 */
public class Donut extends Pastry{

    public boolean hasSprinkles;        //Whether the donut has sprinkles or not
    public boolean hasIcing;            //Whether the donut is glazed or not

    // Default Constructor
    public Donut()
    {
        super();
        hasSprinkles = false;
        hasIcing = false;
    }

    public boolean getHasSprinkles()
    {
        return hasSprinkles;
    }

    public void setHasSprinkles(boolean hasSprinkles)
    {
        this.hasSprinkles = hasSprinkles;
    }

    public boolean hasIcing()
    {
        return hasIcing;
    }

    public void setHasIcing(boolean iced)
    {
        hasIcing = iced;
    }
}

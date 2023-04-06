package edu.sdccd.cisc191.template;

public class Donut extends Pastry{

    public boolean hasSprinkles;        //Whether the donut has sprinkles or not (false by default)
    public boolean hasIcing;            //Whether the donut is glazed or not (false by default)

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

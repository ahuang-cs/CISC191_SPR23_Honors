package edu.sdccd.cisc191.template;

/*
    Pastries should include:
        - Gluten Free alternative



 */


public class Pastry extends MenuItem {

    private String icingFlavor;     //Flavor of Icing on Pastry(Vanilla, Chocolate, Strawberry)
    private boolean hasGluten;      //Whether the pastry is gluten-free or not

    //Default Constructor
    public Pastry()
    {
        super();
        this.icingFlavor = "Chocolate";
        this.hasGluten = true;
    }
    /**
     * Constructor
     * @param name The name of the pastry
     * @param hasGluten Whether the pastry is gluten free (false) or not (true)
     * @param icingFlavor Determines what flavor icing the pastry will have.
     */
    public Pastry(String name, double salePrice,String icingFlavor, boolean hasGluten)
    {
        super(name, salePrice);
        this.hasGluten = hasGluten;
        this.icingFlavor = icingFlavor;
    }
    /**
     * This method sets the flavor of icing for the pastry being made.
     * @param newFlavor The flavor of the icing to be used on the pastry.
     */
    public void setIcingFlavor(String newFlavor)
    {
        icingFlavor = newFlavor;
    }
    /**
     * This method changes whether the pastry is classified as gluten-free (true) or not.
     * @param hasGluten True if the pastry has gluten, false if not.
     */
    public void setHasGluten(boolean hasGluten)
    {
        this.hasGluten = hasGluten;
    }
    /**
     * This method returns the flavor of the icing for the pastry
     * @return The flavor of the icing.
     */
    public String getIcingFlavor()
    {
        return icingFlavor;
    }
    /**
     * This method returns true if the pastry is gluten-free, otherwise it will return false.
     * @return Boolean representing whether the pastry is gluten-free.
     */
    public boolean getHasGluten()
    {
        return hasGluten;
    }
}

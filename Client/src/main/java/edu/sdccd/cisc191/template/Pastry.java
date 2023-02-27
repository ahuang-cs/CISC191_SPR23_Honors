package edu.sdccd.cisc191.template;

/*
    Pastries should include:
        - Gluten Free alternative



 */


public class Pastry extends MenuItem {

    private String icingFlavor;
    private boolean hasGluten;

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

}

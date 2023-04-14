package edu.sdccd.cisc191.template;

import edu.sdccd.cisc191.template.MenuItem.MenuItem;

public class Pastry extends MenuItem {

    private boolean hasGluten;

    //Default Constructor
    public Pastry()
    {
        super();
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
        super();
        this.setName(name);
        this.setSalePrice(salePrice);
        this.hasGluten = hasGluten;
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
     * This method returns true if the pastry is gluten-free, otherwise it will return false.
     * @return Boolean representing whether the pastry is gluten-free.
     */
    public boolean getHasGluten()
    {
        return hasGluten;
    }
}

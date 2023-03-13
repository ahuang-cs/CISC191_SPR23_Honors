package edu.sdccd.cisc191.template;

public class MenuItem
{
    private String itemName;
    private double salePrice;

    /**
     * Default Constructor
     * Fills all fields with empty known values.
     */
    public MenuItem()
    {
        itemName = "";
        salePrice = 0.0;

    }

    /**
     * This is the constructor for MenuItem objects.
     * @param name The name of the Menu Item.
     */
    public MenuItem(String name, double salePrice)
    {
        this.itemName = name;
        this.salePrice = salePrice;
    }


    /**
     * This method returns the name of a menu item.
     * @return String representing name of menu item.
     */
    public String getName()
    {
        return itemName;
    }

    /**
     * This method returns the sale price of a menu item.
     * @return The sale price of this menu item.
     */
    public double getSalePrice()
    {
        return salePrice;
    }

    /**
     * This method sets the name of a menu item
     * @param name String containing the new name of the menu item.
     */
    public void setName(String name)
    {
        itemName = name;
    }

    /**
     * This method changes the sale price for a menu item.
     * @param newPrice Double containing new value for the menu item's sale price.
     */
    public void setSalePrice(double newPrice)
    {
        salePrice = newPrice;
    }


    /**
     * This method prints out a string representing this menuItem object.
     * @return The Menu Item's name.
     */
    public String toString()
    {
        return itemName;
    }
}

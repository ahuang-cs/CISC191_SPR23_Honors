package edu.sdccd.cisc191.template.MenuItem;

import edu.sdccd.cisc191.template.Ingredient.Ingredient;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;


@Entity
public class MenuItem
{
    //for use if recipe is stored in menuItem Object.
    @OneToMany
    private List<Ingredient> recipe = new ArrayList<>();
    private String itemName = "";
    private double salePrice = 0.0;
    private int quantity = 0;
    @Id @GeneratedValue
    private Long id;

    /**
     * This is the constructor for MenuItem objects.
     * @param name The name of the Menu Item.
     */
    public MenuItem(String name, double salePrice, int quantity, List<Ingredient> recipe)
    {
        this.itemName = name;
        this.salePrice = salePrice;
        this.recipe = recipe;
        this.quantity = quantity;
    }
    public MenuItem(){

    }
    public List<Ingredient> getRecipe(){
        return this.recipe;
    }
    public void setRecipe(List<Ingredient> recipe){this.recipe = recipe;}
    public void addToRecipe(Ingredient ingredient){recipe.add(ingredient);}
    public int getQuantity(){
        return this.quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
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

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}

package edu.sdccd.cisc191.template;

public class CountedIngredient extends Ingredient
{
    private int quantity;

    // Default Constructor
    public CountedIngredient()
    {
        super();
        this.quantity = 0;
    }


    // Constructor
    public CountedIngredient(String ingredientName, int quantity)
    {
        super(ingredientName);
        this.quantity=quantity;
    }


    public int getQuantity(){
        return quantity;
    }

    /**
     * This method sets the quantity of ingredients, so for example 10 sugar, the quantity will be 10.
     * @param quantity Amount of ingredient
     */
    public void setQuantity(int quantity){
        this.quantity=quantity;
    }

    public void addQuantity(int amount){
        quantity+= amount;
    }

    public void removeQuantity(int amount){
        quantity -= amount;
        if(quantity < 0){
            quantity = 0;
        }

    }
}

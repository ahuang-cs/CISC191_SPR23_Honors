package edu.sdccd.cisc191.template;
import java.util.ArrayList;

/**
 * This will  be the base class that holds a Menu Objects Ingredient List.
 */
public class Recipe {
    private ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();

    // Default constructor.
    public Recipe(){}

    /**
     * Create an instance of Recipe with an array.
     * @param ingredients
     */
    public Recipe(Ingredient[] ingredients){
        // Iterates over array.
        for (int i =0; i < ingredients.length; i++) {

            // Adds ingredients to ingredients.
            addIngredient(ingredients[i]);

        }
    }

    //Recipe([sugar, milk, blackcoffee]);
    // new recipe
    // recipe.add(milk)
    /**
     * Adds an ingredient to the recipe list, avoids adding an ingredient if it is already in the list.
     * @param ingredient the ingredient to add.
     */
    public void addIngredient(Ingredient ingredient){
        if(!ingredients.contains(ingredient)) {
            ingredients.add(ingredient);
        } else {
            System.out.println("Can't add ingredient " +  ingredient.getIngredientName() + " to recipe, this recipe already contains this ingredient.");
        }
    }

    /**
     * Prints ingredient list.
     */
    public void printIngredientList() {
        for (int i = 0; i < ingredients.size(); i++)
        {
            System.out.println(ingredients.get(i).getIngredientName());
        }
    }

    /**
     *  Add an array of ingredients.
     * @param ingredients
     */
    public void addIngredients(Ingredient[] ingredients){
        // Iterates over array.
        for (int i =0; i < ingredients.length; i++) {
            // Adds ingredients to ingredients.
            this.ingredients.add(ingredients[i]);

        }
    }
    /**
     * Removes an ingredient to the recipe list, avoids removing an ingredient if it is not in the list.
     * @param ingredient the ingredient to remove.
     */
    public void removeIngredient(Ingredient ingredient){
        if(ingredients.contains(ingredient)) {
            ingredients.remove(ingredient);
        } else {
            System.out.println("Can't remove ingredient " +  ingredient.getIngredientName() + " to recipe, this recipe does not contain this ingredient.");
        }
    }

    /**
     * Get the list of ingredients for this recipe.
     * @return
     */
    public ArrayList<Ingredient> getIngredientList(){
        return ingredients;
    }

    public void clearIngredients()
    {
        ingredients.clear();
    }


}

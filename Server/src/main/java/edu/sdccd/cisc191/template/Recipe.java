package edu.sdccd.cisc191.template;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * This will  be the base class that holds a Menu Objects Ingredient List.
 */
public class Recipe {

    private ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
    private HashMap<Ingredient,Double> ingredientAmounts = new HashMap<Ingredient,Double>();

    // TODO: Update class to have an array list, setIngredientAmount, getIngredientAmount, searchForIngredient

    // Default constructor.
    public Recipe(){}


    public void addIngredient(Ingredient ingredient, double amount)
    {
       ingredientAmounts.put(ingredient, amount);
    }

    public void setIngredientAmount(Ingredient ingredient, Double amount) {
        ingredientAmounts.put(ingredient, amount);
    }

    public Double getIngredientAmount(Ingredient ingredient) {
        return ingredientAmounts.containsKey(ingredient) ? ingredientAmounts.get(ingredient) : 0.0;
    }
    public Boolean hasIngredientNamed(String name) {

        ArrayList<String> ingredientNames = new  ArrayList<String>();

        int index = 0;
        for (int i = 0; i < ingredients.size(); i++) {
           ingredientNames.add(ingredients.get(i).ingredientName);
           index = i;
        }

        return ingredientNames.contains(name);
    }

    //
    public  Boolean recipeHasIngredient(Ingredient ingredient) {
        return ingredients.contains(ingredient);
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

    public void addIngredient(Ingredient ingredient, Double amount) {
        addIngredient(ingredient);
        setIngredientAmount(ingredient, amount);

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

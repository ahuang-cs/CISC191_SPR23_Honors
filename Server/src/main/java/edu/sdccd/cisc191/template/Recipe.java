package edu.sdccd.cisc191.template;
import java.util.*;

/**
 * This will  be the base class that holds a Menu Objects Ingredient List.
 */
public class Recipe {

    /**
     * A hash map of our ingredients and the amount included in the recipe
     */
    private HashMap<Ingredient,Double> ingredients = new HashMap<Ingredient,Double>();

    // Default constructor.
    public Recipe(){}


    /**
     * adds an ingredient with an amount to our ingredient list
     * @param ingredient
     * @param amount
     */
    public void addIngredient(Ingredient ingredient, double amount)
    {
       ingredients.put(ingredient, amount);
    }


    /**
     * sets the amount of an ingredient. if an ingredient does not exist it will add it to the recipe
     * @param ingredient the ingredient to add
     * @param amount amount of ingredient used in recipe
     */
    public void setIngredientAmount(Ingredient ingredient, Double amount) {
        ingredients.put(ingredient, amount);
    }

    /**
     * get the amount of an ingredient
     * @param ingredient the ingredient to know the amount of
     * @return the amount of this ingredient used
     */
    public Double getIngredientAmount(Ingredient ingredient) {
        return ingredients.containsKey(ingredient) ? ingredients.get(ingredient) : 0.0;
    }

    /**
     * searches for an ingredient by its name
     * @param name the ingredient to search for
     * @return boolean if this recipe contains an ingredient
     */
    public boolean contains(String name) {
        // create a Set, an array of unique elements from our hashmap
        Set<Ingredient> ingredientSet = ingredients.keySet();
        // iterate through all elements in our set
        // for(each ingredient: in our ingredientSet) { check if ingredients name == our search name }
       for(Ingredient ingredient :ingredientSet) {
           // check if ingredients name is equal to our search name
            if (ingredient.getIngredientName() == name) {
                return  true;
            }
       }
        return false;
    }

    /**
     * searches for an ingredient
     * @param ingredient the ingredient to search for
     * @return boolean if this recipe contains an ingredient
     */
    public boolean contains(Ingredient ingredient) {
        return ingredients.keySet().contains(ingredient);
    }

    /**
     * Adds an ingredient to the recipe list, avoids adding an ingredient if it is already in the list.
     * ingredient amount is automatically set to 1.
     * @param ingredient the ingredient to add.
     */
    public void addIngredient(Ingredient ingredient){
        // check to see if our hashmap contains ingredient
        if(!ingredients.keySet().contains(ingredient)) {
            // add our ingredient to our hash table with default amount of 1
            ingredients.put(ingredient, 1.0);
        } else {
            System.out.println("Can't add ingredient " +  ingredient.getIngredientName() + " to recipe, this recipe already contains this ingredient.");
        }
    }

    /** add an ingredient with a custom amount, if the ingredient already exists it will update the amount
     *
     * @param ingredient the ingredient to add
     * @param amount the amount of ingredient in the recipe
     */
    public void addIngredient(Ingredient ingredient, Double amount) {
        addIngredient(ingredient);
        setIngredientAmount(ingredient, amount);
    }
        /**
         * Prints ingredient list.
         */
    public void printIngredientList() {
        // get set from our hashmap
        Set<Ingredient> ingredientSet = ingredients.keySet();
        // for every ingredient in our ingredientSet
        for(Ingredient ingredient :ingredientSet) {
            // print our ingredient name
            System.out.println(ingredient.ingredientName);
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
            this.addIngredient(ingredients[i]);
        }
    }
    /**
     * Removes an ingredient to the recipe list, avoids removing an ingredient if it is not in the list.
     * @param ingredient the ingredient to remove.
     */
    public void removeIngredient(Ingredient ingredient){
        if(ingredients.keySet().contains(ingredient)) {
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
        // make empty array list
        ArrayList<Ingredient> ingredientArrayList = new ArrayList<>();

        Set<Ingredient> ingredientSet = ingredients.keySet();
        // for every ingredient in our ingredientSet
        for(Ingredient ingredient :ingredientSet) {
            // add ingredient to array list
            ingredientArrayList.add(ingredient);
        }
        return ingredientArrayList;
    }


    public void clearIngredients()
    {
        ingredients.clear();
    }



}

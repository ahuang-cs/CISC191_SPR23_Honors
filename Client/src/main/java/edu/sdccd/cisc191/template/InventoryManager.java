package edu.sdccd.cisc191.template;

import edu.sdccd.cisc191.template.Ingredient.Ingredient;
import edu.sdccd.cisc191.template.MenuItem.MenuItem;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class InventoryManager
{
    // ************************ DATA ***********************

    // Holds a list of all stocked ingredients.
    private List<Ingredient> ingredientList;

    // Holds a list of all menu items.
    private MenuItemList menuItemList;

    // ******************** END OF DATA ********************

    /**
     * Creates a new InventoryManager object
     */
    public InventoryManager()
    {
        //Module 8, still need to add gui to interface with ingredients and write unit test
        //inventory gets MenuItems from MenuItemController
        //TO UPDATE: For now, menu items will be stored on memory, and not saved. Ingredients will be stored on the database.
        RestTemplate restTemplate = new RestTemplate();
        String menuItemSourceUrl = "http://localhost:8080/MenuItems";
        ResponseEntity<Ingredient[]> response = restTemplate.getForEntity(menuItemSourceUrl, Ingredient[].class, new ParameterizedTypeReference<List<MenuItem>>() {});
        Ingredient[] responseArr = response.getBody();
        for(Ingredient ingredient:responseArr){
            addIngredient(ingredient);
        }
        ingredientList = new ArrayList<>();
        menuItemList = new MenuItemList();

    }

    // ******************** Ingredient Methods ********************
    public List<Ingredient> getIngredientList()
    {
        return ingredientList;
    }
    public void addIngredient(Ingredient ingredient)
    {
        ingredientList.add(ingredient);
    }

    /**
     * Searches the IngredientList for a specific ingredient specified by target parameter.
     * @param target The name of the ingredient to be found
     * @return The index in IngredientList containing the target ingredient, or -1 if the target does not exist.
     */
    private int findIngredient(String target)
    {
        int targetIndex = 0;                            // Stores the index of the target ingredient.
        String lowercaseTarget = target.toLowerCase();  // The target string in lowercase, to remove case sensitivity.

        // Check whether ingredientList is empty
        if (ingredientList.size() == 0)
        {
            // If the ingredientList is empty, then the target cannot be present in the array.
            targetIndex = -1;
            return targetIndex;
        }
        else
        {
            // If there are elements in ingredientList, search each element.
            for (int i = 0; i < ingredientList.size(); i++)
            {
                // Compare each element with the target string.
                if (lowercaseTarget.equals(ingredientList.get(i).toString().toLowerCase()))
                {
                    // If the target matches this element, return the index of this element.
                    targetIndex = i;
                    return targetIndex;
                }
            }

            // If we've gone through all elements in the array without encountering the target, it isn't present.
            targetIndex = -1;
            return targetIndex;
        }
    }

    /**
     * Adds an ingredient to ingredientList and ingredientInventory if it is not already present.
     * If the ingredient is already there, it will just add the amount to the ingredientInventory.
     * @param ingredient The ingredient to be added
     */

    /**
     * Directly sets the amount of an ingredient.
     * @param ingredient The ingredient whose amount will be changed
     * @param amount The new amount of the ingredient.
     * @throws ItemNotFoundException Thrown when changing the amount of an ingredient that does not exist.
     */
    public void setIngredientAmount(String ingredient, double amount) throws ItemNotFoundException
    {
        int ingredientIndex = 0; // The index of the ingredient which we want to alter.

        // Search for the ingredient in the ingredientList array.
        ingredientIndex = findIngredient(ingredient);
        // Verify that the ingredient we want to alter is actually in the array.
        if (ingredientIndex != -1)
        {
            // If the ingredient is present, set the corresponding value in the inventory to amount.
            Ingredient newIngredient = ingredientList.get(ingredientIndex);
            newIngredient.setQuantity(amount);
            ingredientList.set(ingredientIndex, newIngredient);
        }
        else
        {
            // The ingredient is not present in the array.
            // Throw an ItemNotFound exception.
            throw new ItemNotFoundException();
        }
    }


    /**
     * Returns a list of all ingredients in the inventory
     * @return a String[] containing all ingredients in chronological order
     */
    /**
     * Returns the amount of an ingredient in the inventory
     * @param ingredient The name of the ingredient to be accessed
     * @return The amount of the ingredient in the inventory
     * @throws ItemNotFoundException Thrown when attempting to access an ingredient that does not exist.
     */
    public double getIngredientAmount(Ingredient ingredient) throws ItemNotFoundException
    {
        double amount = 0;             // The value to be returned, contains the value of the ingredient (if present).

        // Search for the ingredient in the ingredientList array.
        int ingredientIndex = findIngredient(ingredient.getIngredientName());

        // Verify that the ingredient is actually present in the arrays.
        if (ingredientIndex != -1)
        {
            // If the ingredient is present, set amount to the value stored in ingredientInventory
            amount = ingredientList.get(ingredientIndex).getQuantity();
        }
        else
        {
            // The ingredient is not in the array.
            // Throw an exception.
            throw new ItemNotFoundException();
        }

        return amount;
    }

    public void printAllIngredients(){
        System.out.println("************Current Ingredient Stock**********");
        System.out.println("Name, Quantity");
        for(Ingredient ingredient: ingredientList){
            System.out.println(ingredient.getIngredientName()+", "+ingredient.getQuantity()+ingredient.getUnit());
        }

    }
    // ******************** End of Ingredient Methods ********************



    // ******************** MenuItem Methods ********************


    /**
     * Adds a menu item to the inventory.
     * If the menu item already exists, add the amount to the total stored in the inventory.
     * @param item The MenuItem object to be stored.
     */
    public void addMenuItem(MenuItem item)
    {
        menuItemList.addMenuItem(item);
    }

    /**
     * Directly sets the amount of a MenuItem stored in the inventory.
     * @param itemName The name of the MenuItem to be accessed.
     * @param amount The new amount to be stored in the inventory.
     * @throws ItemNotFoundException Thrown when attempting to access a MenuItem that does not exist.
     */
    public void setMenuItemAmount(String itemName, int amount) throws ItemNotFoundException
    {
        // Verify that the item is actually in the array.
        if (!menuItemList.setMenuItemQuantity(itemName, amount)){
            throw new ItemNotFoundException();
        }
       //TODO: subtract quantity from menuItem recipe from the ingredients stock
    }

    /**
     * Returns a list of all menu items in the inventory.
     * @return A MenuItem[] containing all menu items in the inventory in chronological order.
     */
    public List<MenuItem> getMenuItemList()
    {
        return menuItemList.getList();
    }


    /**
     * Returns the amount of a MenuItem in the inventory.
     * @param itemName The name of the menu item to be accessed
     * @return The amount of the MenuItem stored in the inventory.
     * @throws ItemNotFoundException Thrown when attempting to access a menu item that does not exist.
     */
    public int getMenuItemAmount(String itemName) throws ItemNotFoundException
    {
        int amount = 0;   // The amount of the item in the inventory

        // Verify that the menu item is actually present in the array.
        amount = menuItemList.getMenuItemQuantity(itemName);
        if(amount==-1){
            // The menu item is not present.
            // Throw an ItemNotFound exception.
            throw new ItemNotFoundException();
        }

        return amount;
    }

    // ******************** End of MenuItem Methods ********************



    // ******************** Recipe Methods ********************


    /**
     * Adds an ingredient from the inventory to a MenuItem's recipe.
     * @param itemName The name of the menu item whose recipe is being changed.
     * @param ingredient The name of the ingredient to be added to the recipe.
     * @throws ItemNotFoundException    Thrown when attempting to add an ingredient that does not exist,
     *                                  or change the recipe of a menu item that does not exist.
     */
    public void addToRecipe(String itemName, Ingredient ingredient) throws ItemNotFoundException
    {

        // Verify that the menu item is present
        if (!menuItemList.contains(itemName))
        {
            // Either the ingredient or menu item does not exist. This is an error.
            throw new ItemNotFoundException();
        }
        else
        {
            menuItemList.addToRecipe(itemName, ingredient);
        }
    }

    /**
     * Returns a 2D array representing a recipe for a menu item.
     * @param itemName The menu item whose recipe this method returns.
     * @return  A 2D array of integers.
     *          The first column represents an index in the Ingredients inventory (see getIngredientList()).
     *          The second column represents the amount of that ingreedient to be used in the recipe.
     * @throws ItemNotFoundException Thrown when attempting to access the recipe of a menu item that does not exist.
     */
    public List<Ingredient> getRecipe(String itemName) throws ItemNotFoundException
    {

        // Make sure the menu item is actually there
        if (!menuItemList.contains(itemName))
        {
            // If the menu item does not exist, throw a ItemNotFoundException
            throw new ItemNotFoundException();
        }
        else
        {
            return menuItemList.getRecipe(itemName);
        }
    }
    // ******************** End of Recipe Methods ********************

}
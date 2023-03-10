package edu.sdccd.cisc191.template;

/**
 * This class stores 2D arrays containing MenuItems, Ingredients, and their respective amounts.
 * This class also contains a recipe book which maps MenuItems and Ingredients.
 *
 * Fields:
 *  - String[] ingredientList;      <-- Holds a list of ingredients (strings for now)
 *  - MenuItems[] menuItemList;     <-- Holds a list of all menu items
 *  - int[][2] ingredientInventory; <-- Maps items from the ingredientList to the amount in stock
 *  - int[][2] menuItemInventory;   <-- Maps items from the menuItemList to the amount in stock
 *  - int[][] recipeBook;           <-- Maps items from the ingredientList to each item on the menuItem list
 *
 * Required Methods:
 * ********** INGREDIENT SPECIFIC METHODS **********
 *  - int findIngredient(String ingredient);                <-- Returns the index of an ingredient in ingredientList.
 *  + void setIngredientAmount(String ingredient, int amount);- Directly sets the amount of an ingredient.
 *  + void addIngredient(String ingredient, int amount);    <-- Adds ingredients to the ingredientList.
 *  + void deleteIngredient(String ingredient);             <-- Deletes an ingredient from ingredientList and recipes
 *  + void reduceIngredient(String ingredient, int amount); <-- Reduces the amount of an ingredient in ingredientList.
 * ********** END OF INGREDIENT SPECIFIC METHODS **********
 *
 * ********** MENUITEM SPECIFIC METHODS **********
 *  - int findMenuItem(String itemName);                        <-- Returns the index of a menu item in menuItemList
 *  + void setMenuItemAmount(String itemName, int amount);      <-- Directly sets the amount of an MenuItem.
 *  + void addMenuItem(MenuItem item, int amount);              <-- Adds ingredients to the menuItemList.
 *  + void deleteMenuItem(String itemName);                     <-- Deletes an MenuItem from menuItemList and recipes
 *  + void reduceMenuItem(String itemName, int amount);         <-- Reduces the amount of an MenuItem in menuItemList.
 * ********** END OF MENUITEM SPECIFIC METHODS
 *
 * ********** RECIPE SPECIFIC METHODS **********
 *  + void addToRecipe(String itemName, String ingredient, int amount); <-- Adds an ingredient to a menuItem's recipe
 *  + void removeFromRecipe(String itemName, String ingredient);        <-- Removes an ingredient from menuItem recipe
 * ********** END OF RECIPE SPECIFIC METHODS **********
 */
public class InventoryManager
{
    // ************************ DATA ***********************



    // ******************** END OF DATA ********************


}

package edu.sdccd.cisc191.template;

/*
 * This class stores 2D arrays containing MenuItems, Ingredients, and their respective amounts.
 * This class also contains a recipe book which maps MenuItems and Ingredients.
 *
 * Fields:
 *  - String[] ingredientList;      <-- Holds a list of ingredients (strings for now)
 *  - MenuItems[] menuItemList;     <-- Holds a list of all menu items
 *  - int[][] ingredientInventory;  <-- Maps items from the ingredientList to the amount in stock
 *  - int[][] menuItemInventory;    <-- Maps items from the menuItemList to the amount in stock
 *  - int[][] recipeBook;           <-- Maps items from the ingredientList to each item on the menuItem list
 *  - int numIngredients;           <-- The number of ingredients in ingredientList.
 *  - int numMenuItems;             <-- The number of menu items in menuItemList.
 *  - int maxRecipeLength;          <-- The number of ingredients in the longest recipe in recipeBook.
 *
 * Required Methods:
 * ********** INGREDIENT SPECIFIC METHODS **********
 *  - int findIngredient(String ingredient);                <-- Returns the index of an ingredient in ingredientList.
 *  + void setIngredientAmount(String ingredient, int amount);- Directly sets the amount of an ingredient.
 *  + void addIngredient(String ingredient, int amount);    <-- Adds ingredients to the ingredientList.
 *  + void deleteIngredient(String ingredient);             <-- Deletes an ingredient from ingredientList and recipes
 *  + void reduceIngredient(String ingredient, int amount); <-- Reduces the amount of an ingredient in ingredientList.
 *
 *  + String[] getIngredientList();                         <-- Returns a list of all ingredients in inventory
 *  + int getIngredientAmount(String ingredient);           <-- Returns the amount of an ingredient in inventory
 * ********** END OF INGREDIENT SPECIFIC METHODS **********
 *
 * ********** MENUITEM SPECIFIC METHODS **********
 *  - int findMenuItem(String itemName);                        <-- Returns the index of a menu item in menuItemList
 *  + void setMenuItemAmount(String itemName, int amount);      <-- Directly sets the amount of an MenuItem.
 *  + void addMenuItem(MenuItem item, int amount);              <-- Adds ingredients to the menuItemList.
 *  + void deleteMenuItem(String itemName);                     <-- Deletes an MenuItem from menuItemList and recipes
 *  + void reduceMenuItem(String itemName, int amount);         <-- Reduces the amount of an MenuItem in menuItemList.4
 *
 *  + MenuItems[] getMenuItemList();                            <-- Returns a list of all menu items available.
 *  + int getMenuItemAmount(String itemName);                   <-- Returns the amount of a menu item available.
 * ********** END OF MENUITEM SPECIFIC METHODS
 *
 * ********** RECIPE SPECIFIC METHODS **********
 *  + void addToRecipe(String itemName, String ingredient, int amount); <-- Adds an ingredient to a menuItem's recipe
 *  + void removeFromRecipe(String itemName, String ingredient);        <-- Removes an ingredient from menuItem recipe
 *
 *  + int[] getRecipe(String itemName);                                 <-- Returns the recipe of a menu item.
 * ********** END OF RECIPE SPECIFIC METHODS **********
 *
 * ********** OTHER METHODS **********
 *  - void increaseIngredientListCapacity();
 *  - void increase menuItemListCapacity();
 *  - void increaseIngredientInventoryCapacity();
 *  - void increaseMenuItemInventoryCapacity();
 *  - void increaseRecipeBookItemCapacity();
 *  - void increaseRecipeBookIngredientCapacity();
 * ********** END OF OTHER METHODS ***********
 */
public class InventoryManager
{
    // ************************ DATA ***********************

    // Holds a list of all ingredients as strings.
    private String[] ingredientList;

    // Holds a list of all menu items.
    private MenuItem[] menuItemList;

    // Maps all ingredients in ingredientList to the amount that is in storage.
    //      - Column 0 is ingredient index, column 1 is amount of that ingredient.
    private int[][] ingredientInventory;

    // Maps all MenuItems in MenuItemList to the amount that is available.
    //      - Column 0 is the menuItem index, column 1 is the amount of that menu item available.
    private int[][] menuItemInventory;

    // Maps all MenuItems in MenuItemList to a set of ingredients in IngredientList.
    //      - Each row corresponds to a MenuItem.
    //      - Column 0 is the menuItem, odd and even columns alternate between ingredient index and amount.
    //
    //          - Example: [menuItemOne] [ingredientOne] [ingredientOneAmount] [IngredientTwo] [ingredientTwoAmount]
    //                     [menuItemTwo] [ingredientOne] [ingredientOneAmount] [IngredientTwo] [ingredientTwoAmount]
    private int[][] recipeBook;

    // ******************** END OF DATA ********************

    public InventoryManager()
    {
        // A new inventory should start with no ingredients or menuItems
        ingredientList = new String[0];
        menuItemList = new MenuItem[0];

        // Initialize ingredientInventory and menuItemInventory arrays as 2D arrays with 2 columns
        //      - The first column is for specific items, and the second column is for amounts.
        ingredientInventory = new int[0][2];
        menuItemInventory = new int[0][2];

        // Initialize the empty recipe book.
        recipeBook = new int[0][0];

    }



    // ******************** Ingredient Methods ********************

    public String[] getIngredientList()
    {
        // Make a copy of ingredientList and return the copy to prevent unintentional edits to original array.

        // Make an empty array with the same size as ingredientList.
        String[] ingredientListCopy = new String[ingredientList.length];   // The actual array to be returned

        // Copy all ingredients in ingredientList to the new array.
        for (int i = 0; i < ingredientList.length; i++)
        {
            ingredientListCopy[i] = ingredientList[i];
        }

        return ingredientListCopy;
    }



    // ******************** End of Ingredient Methods ********************



    // ******************** MenuItem Methods ********************

    public MenuItem[] getMenuItemList()
    {
        // Make a copy of ingredientList and return the copy to prevent unintentional edits to original array.

        // Make an empty array with the same size as ingredientList.
        MenuItem[] menuItemListCopy = new MenuItem[menuItemList.length];   // The actual array to be returned

        // Copy all ingredients in ingredientList to the new array.
        for (int i = 0; i < menuItemList.length; i++)
        {
            menuItemListCopy[i] = menuItemList[i];
        }

        return menuItemListCopy;
    }

    // ******************** End of MenuItem Methods ********************
}

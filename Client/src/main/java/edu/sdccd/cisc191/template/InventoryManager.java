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
 *
 * Required Methods:
 * ********** INGREDIENT SPECIFIC METHODS **********
 *  - int findIngredient(String ingredient);                <-- Returns the index of an ingredient in ingredientList.
 *  + void setIngredientAmount(String ingredient, int amount);- Directly sets the amount of an ingredient.
 *  + void addIngredient(String ingredient, int amount);    <-- Adds ingredients to the ingredientList.
 *  + void deleteIngredient(String ingredient);             <-- Deletes an ingredient from ingredientList and recipes
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
    //      - [X][0][0]: The Menu Item that this recipe corresponds to
    //      - [ ][X][0]: The Ingredients used in this recipe.
    //      - [ ][X][1]: The amount of the ingredient with the same second dimensional index at [X][X][0].
    private int[][][] recipeBook;

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
        recipeBook = new int[0][0][2];

    }



    // ******************** Ingredient Methods ********************

    private int findIngredient(String target)
    {
        // Search ingredientList for an ingredient with the name target.
        // If it is found, return the index of the ingredient within ingredientList.
        // If it is not found, return -1.

        int targetIndex = 0;                            // Stores the index of the target ingredient.
        String lowercaseTarget = target.toLowerCase();  // The target string in lowercase, to remove case sensitivity.

        // Check whether ingredientList is empty
        if (ingredientList.length == 0)
        {
            // If the ingredientList is empty, then the target cannot be present in the array.
            targetIndex = -1;
            return targetIndex;
        }
        else
        {
            // If there are elements in ingredientList, search each element.
            for (int i = 0; i < ingredientList.length; i++)
            {
                // Compare each element with the target string.
                if (lowercaseTarget.equals(ingredientList[i]))
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

    public void addIngredient(String ingredient, int amount)
    {
        // If ingredient is not present in ingredientList, add it to ingredientList and create an inventory slot.
        // If ingredient is present in ingredientList, add amount to the stored total.

        int ingredientIndex = 0;        // Stores the index of the ingredient if present (-1 if not)

        // Search for the ingredient in the array.
        ingredientIndex = findIngredient(ingredient);

        if (ingredientIndex == -1)
        {
            // The ingredient is not already present in the array; Space needs to be made.

            // We cannot dynamically allocate space in these arrays, so we will move all data to a new, larger array
            String[] newIngredientList = new String[ingredientList.length + 1];
            int[][] newIngredientInventory = new int[ingredientList.length + 1][2];

            // Copy all existing data to the new arrays.
            for (int i = 0; i < ingredientList.length; i++)
            {
                newIngredientList[i] = ingredientList[i];
                newIngredientInventory[i][0] = ingredientInventory[i][0];
                newIngredientInventory[i][1] = ingredientInventory[i][1];
            }

            // Add the new ingredient in all lowercase to remove case sensitivity.
            newIngredientList[newIngredientList.length - 1] = ingredient.toLowerCase();

            // Map the index of the ingredient in the first element of the inventory row.
            newIngredientInventory[newIngredientList.length - 1][0] = newIngredientList.length - 1;

            // Store the amount of the ingredient in the second element of the inventory row.
            newIngredientInventory[newIngredientList.length - 1][1] = amount;

            // Replace the original arrays with the new arrays containing the new ingredient.
            ingredientList = newIngredientList;
            ingredientInventory = newIngredientInventory;

        }
        else
        {
            // The ingredient is already present in the array.
            // Increment the quantity stored in the inventory array by amount.
            ingredientInventory[ingredientIndex][1] += amount;
        }

    }


    public void setIngredientAmount(String ingredient, int amount) throws ItemNotFoundException
    {
        // Search for the ingredient in ingredientList.
        // If the ingredient is present, alter the ingredient amount stored in ingredientInventory.
        // If the ingredient is not present, throw an ItemNotFoundException.

        int ingredientIndex = 0;        // The index of the ingredient which we want to alter.

        // Search for the ingredient in the ingredientList array.
        ingredientIndex = findIngredient(ingredient);

        // Verify that the ingredient we want to alter is actually in the array.
        if (ingredientIndex != -1)
        {
            // If the ingredient is present, set the corresponding value in the inventory to amount.
            ingredientInventory[ingredientIndex][1] = amount;
        }
        else
        {
            // The ingredient is not present in the array.
            // Throw an ItemNotFound exception.
            throw new ItemNotFoundException();
        }
    }



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

    public int getIngredientAmount(String ingredient) throws ItemNotFoundException
    {
        // Search for the ingredient in ingredientList.
        // Return the corresponding amount stored in ingredientInventory using the ingredient's index.
        // If the ingredient is not present, throw an ItemNotFoundException.

        int amount = 0;             // The value to be returned, contains the value of the ingredient (if present).
        int ingredientIndex = 0;    // Stores the index of the ingredient specified in parameter.

        // Search for the ingredient in the ingredientList array.
        ingredientIndex = findIngredient(ingredient);

        // Verify that the ingredient is actually present in the arrays.
        if (ingredientIndex != -1)
        {
            // If the ingredient is present, set amount to the value stored in ingredientInventory
            amount = ingredientInventory[ingredientIndex][1];
        }
        else
        {
            // The ingredient is not in the array.
            // Throw an exception.
            throw new ItemNotFoundException();
        }

        return amount;
    }
    // ******************** End of Ingredient Methods ********************



    // ******************** MenuItem Methods ********************

    private int findMenuItem(String itemName)
    {
        // Search ingredientList for an item with the name itemName.
        // If it is found, return the index of the menu item within menuItemList.
        // If it is not found, return -1.

        int targetIndex = 0;                            // Stores the index of the target menu Item.
        String targetName = itemName.toLowerCase();     // Stores target name in lowercase to remove case sensitivity
        String currentItemName = "";                    // Used to compare menu item names when searching the array.

        // Check whether the menuItemList is empty.
        if (menuItemList.length == 0)
        {
            // If the list is empty, then the target cannot be present.
            // Return -1.
            targetIndex = -1;
            return targetIndex;
        }
        else
        {
            // If there are elements in the list, search each element.
            for (int i = 0; i < menuItemList.length; i++)
            {
                // Make the menu item name lowercase to remove case sensitivity.
                currentItemName = menuItemList[i].getName().toLowerCase();

                // Compare each element with the target string.
                if (targetName.equals(currentItemName))
                {
                    // If the target string matches this element in the array, return this element's index.
                    targetIndex = i;
                    return targetIndex;
                }
            }

            // If we've gone through all elements in this array without encountering the target, it cannot be present.
            // Return -1.
            targetIndex= -1;
            return targetIndex;
        }
    }


    public void addMenuItem(MenuItem item, int amount)
    {
        // There cannot be two menu items with the same name;
        // Therefore, if a menu item with the same name is already present, add amount to the stored total.
        // Otherwise, add the new menu item to the list.

        int itemIndex= 0;     // Stores the index of the menu item (if it is already present).

        // Search for the item in the array using its name.
        itemIndex = findMenuItem(item.getName());

        // Course of action depends on whether the menu item is present in the array.
        if (itemIndex == -1)
        {
            // If the item is not already present in the array, space needs to be made.

            // We cannot dynamically allocate space, so all data must be moved to a new, larger array.
            MenuItem[] newMenuItemList = new MenuItem[menuItemList.length + 1];
            int[][] newMenuItemInventory = new int[menuItemList.length + 1][2];

            // Copy all existing data to the new arrays.
            for (int i = 0; i < menuItemList.length; i++)
            {
                newMenuItemList[i] = menuItemList[i];
                newMenuItemInventory[i][0] = menuItemInventory[i][0];
                newMenuItemInventory[i][1] = menuItemInventory[i][1];
            }

            // Add the new menu item to the final slot.
            newMenuItemList[newMenuItemList.length -1] = item;

            // Map the index of the menu item in the first element of the inventory row.
            newMenuItemInventory[newMenuItemList.length - 1][0] = newMenuItemList.length - 1;

            // Store the amount of the menu item in teh second element of the inventory row.
            newMenuItemInventory[newMenuItemList.length - 1][1] = amount;

            // Replace the original arrays with the new arrays containing the new Menu Item.
            menuItemList = newMenuItemList;
            menuItemInventory = newMenuItemInventory;

            // Update the recipe book to include the new Menu Item.

            // Check whether the recipe book is empty (If there are no menu items):
            if (menuItemList.length == 1)
            {
                // There are no recipes in the recipe book.
                // Create a new recipe book with one empty recipe, and map it to the new menu item.
                int[][][] newRecipeBook = new int[1][3][2];
                newRecipeBook[0][0][0] = newMenuItemList.length - 1;

                // Set recipeBook to have the new array.
                recipeBook = newRecipeBook;
            }
            else
            {
                // There are existing recipes in the recipe book.
                // Create a new recipe book with the same width as the original, but with enough slots for all items.
                int[][][] newRecipeBook = new int[recipeBook.length + 1][recipeBook[0].length][2];

                // Copy all data from recipeBook into newRecipeBook.
                for (int recipeIndex = 0; recipeIndex < recipeBook.length; recipeIndex++)
                {
                    for (int j = 0; j < recipeBook[0].length; j++)
                    {
                        newRecipeBook[recipeIndex][j][0] = recipeBook[recipeIndex][j][0];
                        newRecipeBook[recipeIndex][j][1] = recipeBook[recipeIndex][j][1];
                    }
                }

                // Map the new menu item to the final recipe slot.
                newRecipeBook[newRecipeBook.length - 1][0][0] = newRecipeBook.length - 1;

                // Set recipeBook with the new size and data.
                recipeBook = newRecipeBook;
            }
        }
        else
        {
            // The menu item is already present in the array.
            // Increment the quantity stored in the inventory array by that amount
            menuItemInventory[itemIndex][1] += amount;
        }
    }


    public void setMenuItemAmount(String itemName, int amount) throws ItemNotFoundException
    {
        // Search for the menu item in MenuItemList.
        // If the menu item is present, alter the amount stored in the menuItemInventory.
        // If the item is not present, throw an ItemNotFound Exception.

        // Search for the item in the menuItemList.
        int itemIndex = findMenuItem(itemName);

        // Verify that the item is actually in the array.
        if (itemIndex != -1)
        {
            // If the item is present, set the corresponding inventory element to amount.
            menuItemInventory[itemIndex][1] = amount;
        }
        else
        {
            // The item is not present in the array, so there is nothing to change.
            // Throw an ItemNotFound exception.
            throw new ItemNotFoundException();
        }
    }


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


    public int getMenuItemAmount(String itemName) throws ItemNotFoundException
    {
        // There cannot be two menu items with the same name, so the item's name will be used for identification.
        // Search for the target menu item in menuItemList.
        // Return the corresponding amount stored in ingredientInventory using the ingredient's index.
        // If the ingredient is not present, throw an ItemNotFoundException.

        int amount = 0;                             // The amount of the item in the inventory
        int itemIndex = findMenuItem(itemName);     // Stores the index of the ingredient in the inventory.

        // Verify that the menu item is actually present in the array.
        if (itemIndex != -1)
        {
            // The item is present, so set amount to the value stored in the inventory.
            amount = menuItemInventory[itemIndex][1];
        }
        else
        {
            // The menu item is not present.
            // Throw an ItemNotFound exception.
            throw new ItemNotFoundException();
        }

        return amount;
    }

    // ******************** End of MenuItem Methods ********************



    // ******************** Recipe Methods ********************

    /*
    public void addToRecipe(String itemName, String ingredient, int amount) throws ItemNotFoundException
    {
        // Maps an ingredient from the Ingredients Array to a MenuItem recipe & integer amount in the RecipeBook.
        // Will throw an ItemNotFoundException if:
        //      - The MenuItem does not exist.
        //      - The Ingredient does not exist.

        // Search for the ingredient and menu item.
        int ingredientIndex = findIngredient(ingredient);   // The index in IngredientList containing target ingredient
        int recipeIndex = findMenuItem(itemName);           // The index of the recipe book containing target item.
        boolean ingredientAlreadyPresent = false;           // Checks whether an ingredient is already in the recipe

        // Verify that the ingredient and menu item are present in their respective arrays.
        if ((ingredientIndex == -1) || (recipeIndex == -1))
        {
            // Either the ingredient or menu item does not exist. This is an error.
            throw new ItemNotFoundException();
        }
        else
        {
            // Check whether the ingredient already exists in the recipe.
            for (int i = 1; i < recipeBook[recipeIndex].length; i++)
            {
                // We start with i = 1 because recipeBook[x][0] will always access a menuItem index.
                // The array also alternates between ingredients and amounts, so odd indices will specify ingredients.
                if ((i % 2) == 1)
                {
                    if (ingredientIndex != recipeBook[recipeIndex][i])
                    {
                        ingredientAlreadyPresent = true;
                    }
                }
            }

            // If the ingredient is already present, do nothing.
            if (!ingredientAlreadyPresent)
            {
                // If the ingredient is not already present, add it to the recipe.

                // Locate insertion point
                for (int i = 1; i < recipeBook[recipeIndex].length; i++)
                {
                    if (recipeBook[recipeIndex][i] == null)
                    {

                    }
                }
            }
        }
    }

     */


    // ******************** End of Recipe Methods ********************
}

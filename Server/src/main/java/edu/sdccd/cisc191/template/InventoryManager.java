package edu.sdccd.cisc191.template;

import java.util.ArrayList;

public class InventoryManager
{
    // ************************ DATA ***********************

    // Change to array list.
    // Holds a list of all ingredients as strings.
    public ArrayList<Ingredient> ingredientInventoryList;

    private String[] ingredientList;

    // Holds a list of all menu items.
    private MenuItem[] menuItemList;

    // Maps all ingredients in ingredientList to the amount that is in storage.
    //      - Column 0 is ingredient index, column 1 is amount of that ingredient.
    // remove this and everything that uses it
    private int[][] ingredientInventory;

    // Maps all MenuItems in MenuItemList to the amount that is available.
    //      - Column 0 is the menuItem index, column 1 is the amount of that menu item available.
    //
    //      [Index of Item 1] [Amount of Item 1]
    //      [Index of Item 2] [Amount of Item 2]
    //      [Index of Item 3] [Amount of Item 3]
    private int[][] menuItemInventory;

    // ******************** END OF DATA ********************

    /**
     * Creates a new InventoryManager object
     */
    public InventoryManager()
    {
        // A new inventory should start with no ingredients or menuItems
        ingredientInventoryList = new ArrayList<>();
        ingredientList = new String[0];
        menuItemList = new MenuItem[0];

        // Initialize ingredientInventory and menuItemInventory arrays as 2D arrays with 2 columns
        //      - The first column is for specific items, and the second column is for amounts.
        ingredientInventory = new int[0][2];
        menuItemInventory = new int[0][2];
    }



    // change this to work with the array list
    // ******************** Ingredient Methods ********************

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

    /**
     * Adds an ingredient to ingredientInventoryList and ingredientInventory if it is not already present.
     * @param ingredient The ingredient to be added
     */
    public void addIngredient(Ingredient ingredient)
    {
        if(!ingredientInventoryList.contains(ingredient))
        {
            ingredientInventoryList.add(ingredient);
        }
        else
        {
            System.out.println("Can't add ingredient " + ingredient.getIngredientName() + " ingredient already present.");
        }
    }

    //change to work with the array list
    /**
     * Directly sets the amount of an ingredient.
     * @param ingredient The ingredient whose amount will be changed
     * @param amount The new amount of the ingredient.
     * @throws ItemNotFoundException Thrown when changing the amount of an ingredient that does not exist.
     */
    public void setIngredientAmount(Ingredient ingredient, int amount) throws ItemNotFoundException
    {
        // End goal: Change the stored amount of a menu item

        // Step 1:
        // Step 2:
        // Step 3:
        // Step 4:
    }


    //change to work with al
    /**
     * Returns a list of all ingredients in the inventory
     * @return a String[] containing all ingredients in chronological order
     */
    public String[] getIngredientList()
    {
        // Make an empty array with the same size as ingredientList.
        String[] ingredientListCopy = new String[ingredientList.length];   // The actual array to be returned

        // Copy all ingredients in ingredientList to the new array.
        for (int i = 0; i < ingredientList.length; i++)
        {
            ingredientListCopy[i] = ingredientList[i];
        }

        return ingredientListCopy;
    }

    //change
    /**
     * Returns the amount of an ingredient in the inventory
     * @param ingredient The name of the ingredient to be accessed
     * @return The amount of the ingredient in the inventory
     * @throws ItemNotFoundException Thrown when attempting to access an ingredient that does not exist.
     */
    public int getIngredientAmount(String ingredient) throws ItemNotFoundException
    {
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

    /**
     * Returns the index of a menu item in the inventory, or -1 if the item does not exist.
     * @param itemName The name of the menu item to be found.
     * @return The index of the menu item within the menuItemList array, or -1 if the item does not exist.
     */
    private int findMenuItem(String itemName)
    {
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


    /**
     * Adds a menu item to the inventory.
     * If the menu item already exists, add the amount to the total stored in the inventory.
     * @param item The MenuItem object to be stored.
     * @param amount The amount of the MenuItem to be stored.
     */
    public void addMenuItem(MenuItem item, int amount)
    {
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
        }
        else
        {
            // The menu item is already present in the array.
            // Increment the quantity stored in the inventory array by that amount
            menuItemInventory[itemIndex][1] += amount;
        }
    }

    /**
     * Directly sets the amount of a MenuItem stored in the inventory.
     * @param itemName The name of the MenuItem to be accessed.
     * @param amount The new amount to be stored in the inventory.
     * @throws ItemNotFoundException Thrown when attempting to access a MenuItem that does not exist.
     */
    public void setMenuItemAmount(String itemName, int amount) throws ItemNotFoundException
    {
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


    /**
     * Returns a list of all menu items in the inventory.
     * @return A MenuItem[] containing all menu items in the inventory in chronological order.
     */
    public MenuItem[] getMenuItemList()
    {
        // Make an empty array with the same size as ingredientList.
        MenuItem[] menuItemListCopy = new MenuItem[menuItemList.length];   // The actual array to be returned

        // Copy all ingredients in ingredientList to the new array.
        for (int i = 0; i < menuItemList.length; i++)
        {
            menuItemListCopy[i] = menuItemList[i];
        }

        return menuItemListCopy;
    }


    /**
     * Returns the amount of a MenuItem in the inventory.
     * @param itemName The name of the menu item to be accessed
     * @return The amount of the MenuItem stored in the inventory.
     * @throws ItemNotFoundException Thrown when attempting to access a menu item that does not exist.
     */
    public int getMenuItemAmount(String itemName) throws ItemNotFoundException
    {
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
}
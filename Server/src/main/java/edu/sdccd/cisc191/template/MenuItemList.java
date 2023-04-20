package edu.sdccd.cisc191.template;

import edu.sdccd.cisc191.template.Ingredient.Ingredient;
import edu.sdccd.cisc191.template.MenuNode;
import edu.sdccd.cisc191.template.MenuItem.MenuItem;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MenuItemList
{
    // ********** Variable and Object Creation ***********
    protected MenuNode head;        // Points to the first item in the inventory.
    protected MenuNode tail;        // Points to the last item in the inventory.
    private int size;               // The number of items in the inventory.
    // ******* End of Variable and Object Creation *******

    /**
     * Constructor: Creates a new Menu Item List object.
     */
    public MenuItemList()
    {
        // There are no nodes in the list yet.
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Adds a MenuNode to the beginning of this linked list.
     * @param item The MenuItem to be stored in the new node.
     */
    public void addMenuItem(MenuItem item)
    {
        if (!contains(item.getName()))
        {
            MenuNode newNode = new MenuNode(item);      // The new node to be added to the list

            // Add the new node to the beginning of the list.

            newNode.nextNode = head;
            head = newNode;

            // Check if this is the only node in the list.
            if (tail == null)
            {
                // There were no nodes before this one; this node is now both the head and the tail.
                tail = head;
            }

            // Increment size counter
            size++;
        }
    }

    /**
     * Sets the quantity of a menu item in the list to a new value.
     * @param itemName The name of the menu item to be changed.
     * @param amount The new amount of the menu item present in the inventory.
     * @return True if the item was successfully changed, false if the item is not present in the list.
     */
    public boolean setMenuItemQuantity(String itemName, int amount)
    {
        MenuNode currentNode = head;

        while (currentNode != null)
        {
            // Check whether this node contains the target menu item
            if (currentNode.item.getName().compareToIgnoreCase(itemName) == 0)
            {
                currentNode.item.setQuantity(amount);
                return true;
            }
            else
            {
                currentNode = currentNode.nextNode;
            }
        }

        return false;
    }

    public int getMenuItemQuantity(String itemName){
        MenuNode currentNode = head;
        while (currentNode != null)
        {
            // Check whether this node contains the target menu item
            if (currentNode.item.getName().compareToIgnoreCase(itemName) == 0)
            {
                return currentNode.item.getQuantity();
            }
            else
            {
                currentNode = currentNode.nextNode;
            }
        }

        return -1;
    }


    /**
     * Sets the sale price of a menu item in the list to a new value.
     * @param itemName The name of the item to be edited.
     * @param price The new sale price of the menu item to be edited.
     * @return True if the menu item was successfully changed, false if the menu item was not present in the list.
     */
    public boolean setMenuItemPrice(String itemName, double price)
    {
        MenuNode currentNode = head;

        while (currentNode != null)
        {
            // Check whether this node contains the target menu item
            if (currentNode.item.getName().compareToIgnoreCase(itemName) == 0)
            {
                currentNode.item.setSalePrice(price);
                return true;
            }
            else
            {
                currentNode = currentNode.nextNode;
            }
        }

        return false;
    }

    public boolean addToRecipe(String itemName, Ingredient ingredient){
        MenuNode currentNode = head;

        while (currentNode != null)
        {
            // Check whether this node contains the target menu item
            if (currentNode.item.getName().compareToIgnoreCase(itemName) == 0)
            {
                List<Ingredient> recipe = currentNode.item.getRecipe();
               //checks if ingredient already exists
                for(Ingredient recipeIngredient: recipe){
                    if(recipeIngredient.getIngredientName().equalsIgnoreCase(itemName)){
                        return false;
                    }
                }
                currentNode.item.addToRecipe(ingredient);
                return true;

            }
            else
            {
                currentNode = currentNode.nextNode;
            }
        }

        return false;
    }
    public List<Ingredient> getRecipe(String itemName){
        MenuNode currentNode = head;

        while (currentNode != null)
        {
            // Check whether this node contains the target menu item
            if (currentNode.item.getName().compareToIgnoreCase(itemName) == 0)
            {
                return(currentNode.item.getRecipe());
            }
            else
            {
                currentNode = currentNode.nextNode;
            }
        }
        return new ArrayList<>();
    }

    //Module 10: Uses recursion to see if menuitem exists in linked list, still need to write unit test
    private boolean containSearch(MenuNode head, String name){
        if(head==null)
            return false;
        if(head.item.getName().equalsIgnoreCase(name)){
            return true;
        }
        return containSearch(head.nextNode, name);
    }
    /**
     * Returns whether a menu item is present in the list.
     * @param name The name of the menu item to search for.
     *             There cannot be two menu items with the same name.
     * @return True if the menu item is present in the list, false otherwise.
     */
    public boolean contains(String name)
    {
        MenuNode currentNode = head;
        return containSearch(currentNode, name);
    }


    /**
     * Returns the number of different menu items stored in the inventory.
     * @return The number of nodes in the linked list, which corresponds to the number of different menu items.
     */
    public int getNumMenuItems()
    {
        return size;
    }


    /**
     * Returns a list of all menu item objects stored in this list.
     * @return An array of all menu items in this list's nodes.
     */
    public List<MenuItem> getList()
    {
        List<MenuItem> itemList = new ArrayList<>();
        MenuNode currentNode = head;

        while (currentNode != null)
        {
            itemList.add(currentNode.item);
            currentNode = currentNode.nextNode;

        }

        return itemList;
    }


    /**
     * Returns a list of all menu items in the inventory in alphabetical order.
     * This is not case-sensitive.
     * @return An alphabetically sorted list of menu items.
     */
    public List<MenuItem> getAlphabeticallySortedList()
    {
        // Integer parameter sortOption is 0 to indicate alphabetical sort.
        sortList(0);

        return getList();
    }


    /**
     * Returns a list of all menu items in the inventory.
     * The list is sorted based on the prices of each menu item, in ascending order.
     * @return A sorted list of menu items by price.
     */
    public List<MenuItem> getPriceSortedList()
    {
        // Integer parameter sortOption is 0 to indicate alphabetical sort.
        sortList(1);

        return getList();
    }

    // ******************** PRIVATE METHODS ********************

    /**
     * Deletes all nodes in this list.
     */
    private void deleteList()
    {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Sorts the nodes of this list alphabetically or by price, depending on the value of sortOption parameter.
     * @param sortOption Set this parameter to [0] to sort alphabetically.
     *                   Set this parameter to [1] to sort by price.
     *                   Other values will not change the list.
     */
    private void sortList(int sortOption)
    {
        // Make sure there is more than one element in the list
        if (size > 1)
        {
            // Copy list into array
            List<MenuItem> itemList = getList();

            // Sort the array
            if (sortOption == 0)
            {
                itemList = sortAlphabetically(itemList);
            }
            else if (sortOption == 1)
            {
                itemList = sortByPrice(itemList);
            }

            // Delete current list
            deleteList();

            // Insert each node from array into current list
            for (int i = itemList.size() - 1; i >= 0; i--)
            {
                addMenuItem(itemList.get(i));
            }
        }
    }

    //Module 11: Searching/sorting, unit test complete
    /**
     * Sorts an array of menu items alphabetically.
     * This method implements a BUBBLE SORT. More efficient algorithms are possible and should be considered.
     * @param itemList The array of menu items to be sorted.
     * @return The sorted array of menu items.
     */
    private List<MenuItem> sortAlphabetically(List<MenuItem> itemList)
    {
        boolean listSorted = false;
        String nameOne = "";
        String nameTwo = "";
        MenuItem temp;

        for (int i = 1; i < itemList.size() && !listSorted; i++)
        {
            // If the list is not sorted, we can change that later.
            listSorted = true;

            for (int j = 0; j < itemList.size() - i; j++)
            {
                // Compare the names of each item with the item directly after it.
                nameOne = itemList.get(j).getName();
                nameTwo = itemList.get(j+1).getName();

                if (nameOne.compareToIgnoreCase(nameTwo) > 0)
                {
                    listSorted = false;
                    // Swap the two items.

                    temp = itemList.get(j);
                    itemList.set(j, itemList.get(j+1));
                    itemList.set(j+1, temp);
                }
            }
        }

        return itemList;
    }


    /**
     * Sorts an array of menu items by price from low to high.
     * This method implements a BUBBLE SORT. More efficient algorithms are possible and should be considered.
     * @param itemList The array of menu items to be sorted.
     * @return The sorted array of menu items.
     */
    private List<MenuItem> sortByPrice(List<MenuItem> itemList)
    {
        boolean listSorted = false;
        double priceOne = 0.0;
        double priceTwo = 0.0;
        MenuItem temp;

        for (int i = 1; i < itemList.size() && !listSorted; i++)
        {
            // If the list is not sorted, we can change that later.
            listSorted = true;

            for (int j = 0; j < itemList.size() - i; j++)
            {
                // Compare the names of each item with the item directly after it.
                priceOne = itemList.get(j).getSalePrice();
                priceTwo = itemList.get(j+1).getSalePrice();

                if (priceOne > priceTwo)
                {
                    listSorted = false;
                    // Swap the two items.
                    temp = itemList.get(j);
                    itemList.set(j, itemList.get(j+1));
                    itemList.set(j+1, temp);
                }
            }
        }
        return itemList;
    }
}

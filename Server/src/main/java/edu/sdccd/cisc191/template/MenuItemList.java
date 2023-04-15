package edu.sdccd.cisc191.template;

import edu.sdccd.cisc191.template.MenuNode;
import edu.sdccd.cisc191.template.MenuItem.MenuItem;

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


    /**
     * Returns whether a menu item is present in the list.
     * @param name The name of the menu item to search for.
     *             There cannot be two menu items with the same name.
     * @return True if the menu item is present in the list, false otherwise.
     */
    public boolean contains(String name)
    {
        MenuNode currentNode = head;

        while (currentNode != null)
        {
            if (currentNode.item.getName().compareToIgnoreCase(name) == 0)
            {
                return true;
            }
            else
            {
                currentNode = currentNode.nextNode;
            }
        }

        return false;
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
    public MenuItem[] getList()
    {
        MenuItem[] itemList = new MenuItem[size];
        MenuNode currentNode = head;
        int index = 0;

        while (currentNode != null)
        {
            itemList[index] = currentNode.item;
            currentNode = currentNode.nextNode;
            index++;
        }

        return itemList;
    }


    /**
     * Returns a list of all menu items in the inventory in alphabetical order.
     * This is not case-sensitive.
     * @return An alphabetically sorted list of menu items.
     */
    public MenuItem[] getAlphabeticallySortedList()
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
    public MenuItem[] getPriceSortedList()
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
            MenuItem[] itemList = getList();

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
            for (int i = itemList.length - 1; i >= 0; i--)
            {
                addMenuItem(itemList[i]);
            }
        }
    }

    /**
     * Sorts an array of menu items alphabetically.
     * This method implements a BUBBLE SORT. More efficient algorithms are possible and should be considered.
     * @param itemList The array of menu items to be sorted.
     * @return The sorted array of menu items.
     */
    private MenuItem[] sortAlphabetically(MenuItem[] itemList)
    {
        boolean listSorted = false;
        String nameOne = "";
        String nameTwo = "";
        MenuItem temp;

        for (int i = 1; i < itemList.length && !listSorted; i++)
        {
            // If the list is not sorted, we can change that later.
            listSorted = true;

            for (int j = 0; j < itemList.length - i; j++)
            {
                // Compare the names of each item with the item directly after it.
                nameOne = itemList[j].getName();
                nameTwo = itemList[j + 1].getName();

                if (nameOne.compareToIgnoreCase(nameTwo) > 0)
                {
                    listSorted = false;
                    // Swap the two items.
                    temp = itemList[j];
                    itemList[j] = itemList[j+1];
                    itemList[j+1] = temp;
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
    private MenuItem[] sortByPrice(MenuItem[] itemList)
    {
        boolean listSorted = false;
        double priceOne = 0.0;
        double priceTwo = 0.0;
        MenuItem temp;

        for (int i = 1; i < itemList.length && !listSorted; i++)
        {
            // If the list is not sorted, we can change that later.
            listSorted = true;

            for (int j = 0; j < itemList.length - i; j++)
            {
                // Compare the names of each item with the item directly after it.
                priceOne = itemList[j].getSalePrice();
                priceTwo = itemList[j + 1].getSalePrice();

                if (priceOne > priceTwo)
                {
                    listSorted = false;
                    // Swap the two items.
                    temp = itemList[j];
                    itemList[j] = itemList[j+1];
                    itemList[j+1] = temp;
                }
            }
        }
        return itemList;
    }
}

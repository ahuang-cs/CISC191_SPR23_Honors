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


    public int getNumMenuItems()
    {
        return size;
    }


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


    public MenuItem[] getAlphabeticallySortedList()
    {
        // Integer parameter sortOption is 0 to indicate alphabetical sort.
        sortList(0);

        return getList();
    }


    public MenuItem[] getPriceSortedList()
    {
        // Integer parameter sortOption is 0 to indicate alphabetical sort.
        sortList(1);

        return getList();
    }



    // ******************** PRIVATE METHODS ********************

    private void deleteList()
    {
        head = null;
        tail = null;
        size = 0;
    }

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

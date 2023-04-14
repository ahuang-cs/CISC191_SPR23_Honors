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




}

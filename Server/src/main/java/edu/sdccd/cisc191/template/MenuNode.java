package edu.sdccd.cisc191.template;

import edu.sdccd.cisc191.template.MenuItem.MenuItem;

public class MenuNode
{
    // ********** Variable and Object Creation ***********
    protected MenuItem item;        // The item stored in the inventory
    protected MenuNode nextNode;    // The node after this one in the list.
    // ******* End of Variable and Object Creation *******

    /**
     * Constructor for MenuNode objects.
     * @param menuItem     The Menu Item that this node represents.
     */
    public MenuNode(MenuItem menuItem)
    {
        item  = menuItem;
    }
}

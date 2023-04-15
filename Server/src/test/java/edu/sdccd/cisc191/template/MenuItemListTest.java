package edu.sdccd.cisc191.template;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import edu.sdccd.cisc191.template.MenuItem.MenuItem;

class MenuItemListTest {

    @Test
    void addMenuItem()
    {
        MenuItemList list = new MenuItemList();

        // Check that the list starts with zero nodes.
        assertEquals(0, list.getNumMenuItems());

        // Create menu items to be added to the list.
        MenuItem cake = new MenuItem();
        MenuItem coffee = new MenuItem();
        MenuItem donut = new MenuItem();

        list.addMenuItem(cake);
        assertEquals(1, list.getNumMenuItems());
        list.addMenuItem(coffee);
        assertEquals(2, list.getNumMenuItems());
        list.addMenuItem(donut);
        assertEquals(3, list.getNumMenuItems());
    }
}
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
        cake.setName("Cake");
        MenuItem coffee = new MenuItem();
        coffee.setName("coffee");
        MenuItem donut = new MenuItem();
        donut.setName("Donut");

        list.addMenuItem(cake);
        assertEquals(1, list.getNumMenuItems());
        list.addMenuItem(coffee);
        assertEquals(2, list.getNumMenuItems());
        list.addMenuItem(donut);
        assertEquals(3, list.getNumMenuItems());

        MenuItem[] itemList = list.getList();

        assertEquals(3, itemList.length);
        assertEquals("Donut", itemList[0].getName());
        assertEquals("coffee", itemList[1].getName());
        assertEquals("Cake", itemList[2].getName());
    }

    @Test
    void alphabeticalSortTest()
    {
        MenuItemList list = new MenuItemList();

        // Create menu items to be added to the list.
        MenuItem cake = new MenuItem();
        cake.setName("Cake");
        MenuItem coffee = new MenuItem();
        coffee.setName("coffee");
        MenuItem donut = new MenuItem();
        donut.setName("Donut");

        list.addMenuItem(cake);
        list.addMenuItem(coffee);
        list.addMenuItem(donut);

        MenuItem[] itemList = list.getAlphabeticallySortedList();

        // Coffee is not capitalized to verify lack of case sensitivity.
        assertEquals("Cake", itemList[0].getName());
        assertEquals("coffee", itemList[1].getName());
        assertEquals("Donut", itemList[2].getName());

        // Verify that the list remains sorted
        itemList = list.getList();
        assertEquals(3, list.getNumMenuItems());
        assertEquals("Cake", itemList[0].getName());
        assertEquals("coffee", itemList[1].getName());
        assertEquals("Donut", itemList[2].getName());
    }

    @Test
    void priceSortTest()
    {
        MenuItemList list = new MenuItemList();

        // Create menu items to be added to the list.
        MenuItem cake = new MenuItem();
        cake.setSalePrice(3.99);
        MenuItem coffee = new MenuItem();
        coffee.setSalePrice(1.99);
        MenuItem donut = new MenuItem();
        donut.setSalePrice(2.50);

        list.addMenuItem(cake);
        list.addMenuItem(coffee);
        list.addMenuItem(donut);

        MenuItem[] itemList = list.getPriceSortedList();

        // Coffee is not capitalized to verify lack of case sensitivity.
        assertEquals(1.99, itemList[0].getSalePrice());
        assertEquals(2.50, itemList[1].getSalePrice());
        assertEquals(3.99, itemList[2].getSalePrice());

        // Verify that the list remains sorted
        itemList = list.getList();
        assertEquals(3, list.getNumMenuItems());
        assertEquals(1.99, itemList[0].getSalePrice());
        assertEquals(2.50, itemList[1].getSalePrice());
        assertEquals(3.99, itemList[2].getSalePrice());
    }
}
package edu.sdccd.cisc191.template;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import edu.sdccd.cisc191.template.MenuItem.MenuItem;

import java.util.List;

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

        List<MenuItem> itemList = list.getAlphabeticallySortedList();

        // Coffee is not capitalized to verify lack of case sensitivity.
        assertEquals("Cake", itemList.get(0).getName());
        assertEquals("coffee", itemList.get(1).getName());
        assertEquals("Donut", itemList.get(2).getName());

        // Verify that the list remains sorted
        itemList = list.getList();
        assertEquals(3, list.getNumMenuItems());
        assertEquals("Cake", itemList.get(0).getName());
        assertEquals("coffee", itemList.get(0).getName());
        assertEquals("Donut", itemList.get(0).getName());
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

        List<MenuItem> itemList = list.getPriceSortedList();

        // Coffee is not capitalized to verify lack of case sensitivity.
        assertEquals(1.99, itemList.get(0).getSalePrice());
        assertEquals(2.50, itemList.get(0).getSalePrice());
        assertEquals(3.99, itemList.get(0).getSalePrice());

        // Verify that the list remains sorted
        itemList = list.getList();
        assertEquals(3, list.getNumMenuItems());
        assertEquals(1.99, itemList[0].getSalePrice());
        assertEquals(2.50, itemList[1].getSalePrice());
        assertEquals(3.99, itemList[2].getSalePrice());
    }

    @Test
    void setMenuItemQuantityTest()
    {
        MenuItemList list = new MenuItemList();

        // Create menu items to be added to the list.
        MenuItem cake = new MenuItem();
        cake.setQuantity(10);
        cake.setName("Cake");
        MenuItem coffee = new MenuItem();
        coffee.setName("Coffee");
        coffee.setQuantity(50);
        MenuItem donut = new MenuItem();
        donut.setQuantity(30);
        donut.setName("Donut");

        list.addMenuItem(donut);
        list.addMenuItem(coffee);
        list.addMenuItem(cake);

        MenuItem[] itemList = list.getList();
        assertEquals("Cake", itemList[0].getName());
        assertEquals(10, itemList[0].getQuantity());
        assertEquals("Coffee", itemList[1].getName());
        assertEquals(50, itemList[1].getQuantity());
        assertEquals("Donut", itemList[2].getName());
        assertEquals(30, itemList[2].getQuantity());

        // Ensure that the method is not case-sensitive
        list.setMenuItemQuantity("cake", 500);
        list.setMenuItemQuantity("Coffee", 300);
        list.setMenuItemQuantity("DONUT", 200);

        itemList = list.getList();
        assertEquals("Cake", itemList[0].getName());
        assertEquals(500, itemList[0].getQuantity());
        assertEquals("Coffee", itemList[1].getName());
        assertEquals(300, itemList[1].getQuantity());
        assertEquals("Donut", itemList[2].getName());
        assertEquals(200, itemList[2].getQuantity());
    }

    @Test
    void setMenuItemPriceTest()
    {
        MenuItemList list = new MenuItemList();

        // Create menu items to be added to the list.
        MenuItem cake = new MenuItem();
        cake.setSalePrice(3.99);
        cake.setName("Cake");
        MenuItem coffee = new MenuItem();
        coffee.setName("Coffee");
        coffee.setSalePrice(1.99);
        MenuItem donut = new MenuItem();
        donut.setSalePrice(2.50);
        donut.setName("Donut");

        list.addMenuItem(donut);
        list.addMenuItem(coffee);
        list.addMenuItem(cake);

        MenuItem[] itemList = list.getList();

        assertEquals("Cake", itemList[0].getName());
        assertEquals(3.99, itemList[0].getSalePrice());
        assertEquals("Coffee", itemList[1].getName());
        assertEquals(1.99, itemList[1].getSalePrice());
        assertEquals("Donut", itemList[2].getName());
        assertEquals(2.50, itemList[2].getSalePrice());

        // Ensure that the method is not case-sensitive
        list.setMenuItemPrice("cake", 5.00);
        list.setMenuItemPrice("Coffee", 3.00);
        list.setMenuItemPrice("DONUT", 3.99);

        itemList = list.getList();

        assertEquals("Cake", itemList[0].getName());
        assertEquals(5.00, itemList[0].getSalePrice());
        assertEquals("Coffee", itemList[1].getName());
        assertEquals(3.00, itemList[1].getSalePrice());
        assertEquals("Donut", itemList[2].getName());
        assertEquals(3.99, itemList[2].getSalePrice());
    }
}
package edu.sdccd.cisc191.template;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuItemTest {

    @Test
    void getName()
    {
        // Create a new MenuItem object.
        MenuItem newItem = new MenuItem();
        MenuItem secondItem = new MenuItem();
        MenuItem thirdItem = new MenuItem();

        // Test assigning and reading names from MenuItem object
        newItem.setName("Coffee");
        secondItem.setName("Tea");
        thirdItem.setName("Decaf Coffee");
        assertEquals("Coffee", newItem.getName());
        assertEquals("Tea", secondItem.getName());
        assertEquals("Decaf Coffee", thirdItem.getName());
    }

    @Test
    void getSalePrice()
    {
        // Create a new MenuItem object.
        MenuItem newItem = new MenuItem();
        MenuItem secondItem = new MenuItem();
        MenuItem thirdItem = new MenuItem();

        // Test assigning and reading SalePrices from MenuItem object
        newItem.setSalePrice(9.99);
        secondItem.setSalePrice(5.00);
        thirdItem.setSalePrice(7.49);
        assertEquals(9.99, newItem.getSalePrice());
        assertEquals(5.00, secondItem.getSalePrice());
        assertEquals(7.49, thirdItem.getSalePrice());
    }

    @Test
    void setName() {
        // Create a new Menu Item
        MenuItem newItem = new MenuItem();

        // Test assigning a name for the first time.
        newItem.setName("Tea");
        assertEquals("Tea", newItem.getName());

        // Test changing a name that has already been assigned.
        newItem.setName("Soda");
        assertEquals("Soda", newItem.getName());
    }

    @Test
    void setSalePrice() {
        // Create a new Menu Item
        MenuItem newItem = new MenuItem();

        // Test assigning a SalePrice for the first time.
        newItem.setSalePrice(3.99);
        assertEquals(3.99, newItem.getSalePrice());

        // Test changing a SalePrice that has already been assigned.
        newItem.setSalePrice(4.50);
        assertEquals(4.50, newItem.getSalePrice());
    }

    @Test
    void testToString()
    {
        // Create a new MenuItem object.
        MenuItem newItem = new MenuItem();
        MenuItem secondItem = new MenuItem();
        MenuItem thirdItem = new MenuItem();

        // Test assigning names and reading them through the MenuItem.toString().
        newItem.setName("Coffee");
        secondItem.setName("Tea");
        thirdItem.setName("Decaf Coffee");
        assertEquals("Coffee", newItem.toString());
        assertEquals("Tea", secondItem.toString());
        assertEquals("Decaf Coffee", thirdItem.toString());
    }
}
package edu.sdccd.cisc191.server;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DrinkTest {

    @Test
    void getNameTest()
    {
        // Testing inherited getName() class.
        // Create a new Drink object.
        Drink firstDrink = new Drink();
        Drink secondDrink = new Drink();
        Drink thirdDrink = new Drink();

        // Test assigning and reading Sizes from Drink object
        firstDrink.setName("Coffee");
        secondDrink.setName("Tea");
        thirdDrink.setName("Decaf Coffee");
        assertEquals("Coffee", firstDrink.getName());
        assertEquals("Tea", secondDrink.getName());
        assertEquals("Decaf Coffee", thirdDrink.getName());

    }

    @Test
    void getSalePriceTest() {
        // Testing inheritance of getSalePrice() method from parent class
        // Create a new Drink object.
        Drink firstDrink = new Drink();
        Drink secondDrink = new Drink();
        Drink thirdDrink = new Drink();

        // Test assigning and reading SalePrices from Drink object
        firstDrink.setSalePrice(9.99);
        secondDrink.setSalePrice(5.00);
        thirdDrink.setSalePrice(7.49);
        assertEquals(9.99, firstDrink.getSalePrice());
        assertEquals(5.00, secondDrink.getSalePrice());
        assertEquals(7.49, thirdDrink.getSalePrice());
    }

    @Test
    void setNameTest() {
        // Testing inheritance of method setName() from parent
        // Create a new Drink
        Drink newDrink = new Drink();

        // Test assigning a Size for the first time.
        newDrink.setName("Tea");
        assertEquals("Tea", newDrink.getName());

        // Test changing a Size that has already been assigned.
        newDrink.setName("Soda");
        assertEquals("Soda", newDrink.getName());
    }

    @Test
    void setSalePriceTest()
    {
        // Testing inheritance of getSalePrice() method from parent class
        // Create a new Drink
        Drink newDrink = new Drink();

        // Test assigning a SalePrice for the first time.
        newDrink.setSalePrice(3.99);
        assertEquals(3.99, newDrink.getSalePrice());

        // Test changing a SalePrice that has already been assigned.
        newDrink.setSalePrice(4.50);
        assertEquals(4.50, newDrink.getSalePrice());
    }

    @Test
    void testToString()
    {
        // Testing polymorphism with toString() method
        // Create a new Drink object.
        Drink firstDrink = new Drink();
        Drink secondDrink = new Drink();
        Drink thirdDrink = new Drink();

        // Test assigning Sizes and reading them through the Drink.toString().
        firstDrink.setName("Coffee");
        secondDrink.setName("Tea");
        thirdDrink.setName("Decaf Coffee");
        firstDrink.setSize("Medium");
        secondDrink.setSize("Small");
        thirdDrink.setSize("Large");
        assertEquals("Medium Coffee", firstDrink.toString());
        assertEquals("Small Tea", secondDrink.toString());
        assertEquals("Large Decaf Coffee", thirdDrink.toString());
    }

    @Test
    void setSizeTest() {
        // Create a new Drink
        Drink newDrink = new Drink();

        // Test assigning a Size for the first time.
        newDrink.setSize("Small");
        assertEquals("Small", newDrink.getSize());

        // Test changing a Size that has already been assigned.
        newDrink.setSize("Large");
        assertEquals("Large", newDrink.getSize());
    }

    @Test
    void setHeatValue() {
        // Create a new Drink
        Drink newDrink = new Drink();

        // Test assigning a heat value for the first time.
        newDrink.setHeatValue(true);
        assertEquals(true, newDrink.getHeatValue());

        // Test changing a heat value that has already been assigned.
        newDrink.setHeatValue(false);
        assertEquals(false, newDrink.getHeatValue());
    }

    @Test
    void getSize() {
        // Create a new Drink object.
        Drink firstDrink = new Drink();
        Drink secondDrink = new Drink();
        Drink thirdDrink = new Drink();

        // Test assigning and reading SalePrices from Drink object
        firstDrink.setSize("Small");
        secondDrink.setSize("Medium");
        thirdDrink.setSize("Large");
        assertEquals("Small", firstDrink.getSize());
        assertEquals("Medium", secondDrink.getSize());
        assertEquals("Large", thirdDrink.getSize());
    }

    @Test
    void getHeatValue() {
        // Create a new Drink object.
        Drink firstDrink = new Drink();
        Drink secondDrink = new Drink();
        Drink thirdDrink = new Drink();

        // Test assigning and reading SalePrices from Drink object
        firstDrink.setHeatValue(true);
        secondDrink.setHeatValue(false);
        thirdDrink.setHeatValue(true);
        assertEquals(true, firstDrink.getHeatValue());
        assertEquals(false, secondDrink.getHeatValue());
        assertEquals(true, thirdDrink.getHeatValue());
    }
}
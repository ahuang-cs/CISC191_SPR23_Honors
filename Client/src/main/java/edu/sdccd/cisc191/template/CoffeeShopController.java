package edu.sdccd.cisc191.template;


import edu.sdccd.cisc191.template.MenuItem.MenuItem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;
import java.net.URISyntaxException;

public class CoffeeShopController extends CoffeeShop {
        InventoryManager inventoryManager = new InventoryManager();
        CoffeeShop coffeeShop = new CoffeeShop(inventoryManager);

        public CoffeeShopController(InventoryManager givenInventoryManager) {super(givenInventoryManager);}
        public void displayMenu(ActionEvent a) throws ItemNotFoundException {coffeeShop.printAllMenuItems();}
        public void addItemQuantity(ActionEvent a) {coffeeShop.addItemQuantity();}
        public void removeItemQuantity(ActionEvent a) {
                coffeeShop.subtractItemQuantity();
        }
        public void showCostcoVendorData(ActionEvent e) throws IOException, URISyntaxException {coffeeShop.costcoVendor();}
        public void showWalmartVendorData(ActionEvent e) throws IOException {coffeeShop.walmartVendor();}
        public void getLowestIngredientPrices(ActionEvent e) throws IOException {coffeeShop.getLowestIngredientPrices();}
        public void addMenuItem(ActionEvent e) {
                coffeeShop.addMenuItem();
        }
        public void printIngredientStock(ActionEvent e){coffeeShop.printIngredients();}
        public void addIngredientQuantity(ActionEvent e){addIngredientQuantity();}
        public void removeIngredientQuantity(ActionEvent e){removeIngredientQuantity();}
        public void sortAlphabetically(ActionEvent e){inventory.menuItemList.getAlphabeticallySortedList();}
        public void sortByPrice(ActionEvent e){inventory.menuItemList.getPriceSortedList();}
        public void addIngredientItem(ActionEvent e){}

}

package edu.sdccd.cisc191.template;


import edu.sdccd.cisc191.template.MenuItem.MenuItem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class CoffeeShopController extends CoffeeShop {

        public void displayMenu(ActionEvent a) throws ItemNotFoundException
        {
                printAllMenuItems();
        }
        public void addItemQuantity(ActionEvent a) {
                addItemQuantity();
        }
        public void removeItemQuantity(ActionEvent a) {
                subtractItemQuantity();
        }
        public void showCostcoVendorData(ActionEvent e) throws IOException {costcoVendor();}
        public void showWalmartVendorData(ActionEvent e) throws IOException {walmartVendor();}
        public void getLowestIngredientPrices(ActionEvent e) throws IOException {getLowestIngredientPrices();}
        public void addMenuItem(ActionEvent e) {
                addMenuItem();
        }
        public void printIngredientStock(ActionEvent e){printIngredients();}
        public void addIngredientQuantity(ActionEvent e){addIngredientQuantity();}
        public void removeIngredientQuantity(ActionEvent e){removeIngredientQuantity();}
        public void sortAlphabetically(ActionEvent e){inventory.menuItemList.getAlphabeticallySortedList();}
        public void sortByPrice(ActionEvent e){inventory.menuItemList.getPriceSortedList();}
        public void addIngredientItem(ActionEvent e){}

}

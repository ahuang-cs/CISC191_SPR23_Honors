package edu.sdccd.cisc191.template;


import javafx.event.ActionEvent;

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
        public void showVendorData(ActionEvent e) throws IOException {
                printVendor();
        }
        public void addMenuItem(ActionEvent e) {
                addMenuItem();
        }
}

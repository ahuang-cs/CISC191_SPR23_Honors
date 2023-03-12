package edu.sdccd.cisc191.template;


import javafx.event.ActionEvent;

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
        public void showVendorData(ActionEvent e){
                printVendor();
        }
        public void addMenuItem(ActionEvent e) {
                addMenuItem();
        }
}

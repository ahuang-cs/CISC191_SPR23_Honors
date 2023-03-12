package edu.sdccd.cisc191.template;


import javafx.event.ActionEvent;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CoffeeShopController extends CoffeeShop {

        public void displayMenu(ActionEvent a){
               printAll();
        }
        public void addItemQuantity(ActionEvent a) {
                addQuantity();
        }
        public void removeItemQuantity(ActionEvent a) {
                subtractQuantity();
        }
        public void showVendorData(ActionEvent e){
                printVendor();
        }
}

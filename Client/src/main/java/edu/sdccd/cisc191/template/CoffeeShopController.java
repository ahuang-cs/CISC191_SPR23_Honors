package edu.sdccd.cisc191.template;


import javafx.event.ActionEvent;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CoffeeShopController extends CoffeeShop {

        public void displayMenu(ActionEvent e){
               printAll();
        }
        public void addItemQuantity(ActionEvent e) {
                addQuantity();
        }
        public void removeItemQuantity(ActionEvent e) {
                subtractQuantity();
        }
        public void displayIngredients(ActionEvent e){
                System.out.println("Test");
        }
}

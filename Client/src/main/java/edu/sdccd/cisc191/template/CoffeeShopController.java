package edu.sdccd.cisc191.template;


import javafx.event.ActionEvent;

public class CoffeeShopController extends CoffeeShop {

        public void displayMenu(ActionEvent e){
                //System.out.println("Test");
                System.out.println("Index\t" + "Name\t\t" + "Quantity\t" + "Note");
                for (int i = 0; i < itemName.size(); i++) {
                        int value = itemQuantity.get(i);
                        String note = value < 2 ? "need restock" : " "; // if the quantity is less then 2, leave a note "need restock"
                        System.out.println((i + 1) + "\t\t" + itemName.get(i) + "\t\t" + itemQuantity.get(i) + "\t" + note);
                }
                System.out.println("\n");
        }
        public void addItemQuantity(ActionEvent e){
                System.out.println("Test");
        }
        public void removeItemQuantity(ActionEvent e){
                System.out.println("Test");
        }
        public void displayIngredients(ActionEvent e){
                System.out.println("Test");
        }
}

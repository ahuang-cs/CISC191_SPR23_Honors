
package edu.sdccd.cisc191.template;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CoffeeShop extends Application {

    static ArrayList<String> itemName = new ArrayList<>(Arrays.asList("Coffee\t", "Donut\t", "Tea\t\t", "Cake\t", "Croissant", "Juice\t"));  // initialize an empty array
    static ArrayList<Integer> itemQuantity = new ArrayList<>(Arrays.asList(10, 25, 30, 16, 20, 15));

    public static void main(String[] args) {
        //if its the users first time using the program,we can make a method where if the array length
        //is less than 0, it would print out "no items added right now"
        launch(args);

    }

    static void printAll() {
        System.out.println("Index\t" + "Name\t\t" + "Quantity\t" + "Note");
        for (int i = 0; i < itemName.size(); i++) {
            int value = itemQuantity.get(i);
            String note = value < 2 ? "need restock" : " "; // if the quantity is less then 2, leave a note "need restock"
            System.out.println((i + 1) + "\t\t" + itemName.get(i) + "\t\t" + itemQuantity.get(i) + "\t" + note);
        }
        System.out.println("\n");
    }

    static void addQuantity() {
        Scanner scanner1 = new Scanner(System.in);
        System.out.print("Which item number would you like to add? ");
        try {
            int item = scanner1.nextInt();
            System.out.println("Item " + item + " is " + itemName.get(item - 1).trim() + " which has a quantity of " + itemQuantity.get(item - 1));
            System.out.print("Enter the quantity you would like to add: ");
            Scanner scanner2 = new Scanner(System.in);
            int quantity = scanner2.nextInt();
            // when the user input a number, it must be greater than or equal zero.
            // Otherwise the user has to input again or press 0 to go back to the menu
            while (quantity < 0) {
                System.out.println("Invalid value. Please try again or press 0 to go back to the inventory");
                quantity = scanner2.nextInt();
            }
            itemQuantity.set(item - 1, quantity + itemQuantity.get(item - 1));
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("Invalid index. Please try again!");
        }
        //exception handling with the input which is not a number
        catch (InputMismatchException ime) {
            System.out.println("Your input is invalid, please try again");
        }
    }

    static void subtractQuantity() {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Which item number would you like to subtract?");

        try {
            int item = scanner1.nextInt();
            System.out.println("Item " + item + " is " + itemName.get(item - 1).trim() + " which has a quantity of " + itemQuantity.get(item - 1));
            System.out.print("Enter the quantity you would like to subtract: ");
            Scanner scanner2 = new Scanner(System.in);
            int quantity = scanner2.nextInt();
            if ((quantity < 0) || quantity > itemQuantity.get(item - 1)) {
                System.out.println("Invalid value. Please try again or press 0 to go back to the inventory");
                quantity = scanner2.nextInt();
            }
            itemQuantity.set(item - 1, itemQuantity.get(item - 1) - quantity); //set the value at index of item-1
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("Invalid index. Please try again!");
        }
        //exception handling with the input which is not a number
        catch (InputMismatchException ime) {
            System.out.println("Your input is invalid, please try again");
        }
    }


    @Override
    public void start(Stage stage) throws Exception {

        try {
            Parent shopMenu = FXMLLoader.load(getClass().getResource("/CoffeeShop.fxml"));
            Scene scene = new Scene(shopMenu);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}




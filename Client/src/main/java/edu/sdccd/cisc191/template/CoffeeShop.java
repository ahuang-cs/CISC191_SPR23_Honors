
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

    static InventoryManager inventory;      // Manages the inventory of Menu Items and Ingredients.

    static ArrayList<String> itemName = new ArrayList<>(Arrays.asList("Coffee\t", "Donut\t", "Tea\t\t", "Cake\t", "Croissant", "Juice\t"));  // initialize an empty array
    static ArrayList<Integer> itemQuantity = new ArrayList<>(Arrays.asList(10, 25, 30, 16, 20, 15));
    /*
    static final String[][] navMenu = new String[][] {  {"1","Display the menu"},
                                                        {"2", "Add item quantity"},
                                                        {"3", "Subtract item quantity"},
                                                        {"4", "Quit" }};
    */
    public static void main(String[] args) {

        inventory = new InventoryManager();

        launch(args);

    }

    static void printAllMenuItems() throws ItemNotFoundException
    {
        MenuItem[] menuItems = inventory.getMenuItemList();

        // New code
        if (menuItems.length == 0)
        {
            System.out.println("There are no Menu Items in the inventory right now.");
        }
        else
        {
            String menuItemName = "";
            double menuItemPrice = 0.0;

            System.out.println("*************** Menu Items ***************");

            System.out.println("Menu Item:             Quantity:  Price:  ");

            for (int i = 0; i < menuItems.length; i++)
            {
                menuItemName = menuItems[i].getName();
                menuItemPrice = menuItems[i].getSalePrice();
                System.out.printf("%-22s %-10d %.2f\n", menuItemName, inventory.getMenuItemAmount(menuItemName), menuItemPrice);
            }
            System.out.println("");
        }
    }

    static void addQuantity()
    {
        Scanner keyboard = new Scanner(System.in);
        String userInputName = "";
        int userInputAmount = 0;
        boolean badInput = false;

        do
        {
            System.out.print("Which menu item would you like to add? ");
            userInputName = keyboard.nextLine();
            System.out.print("How much of this item would you like to add? ");
            userInputAmount = keyboard.nextInt();

            try
            {
                // Check to make sure that the user isn't trying to enter a negative amount.
                if (userInputAmount >= 0)
                {
                    inventory.setMenuItemAmount(userInputName, userInputAmount + inventory.getMenuItemAmount(userInputName));
                }
                else
                {
                    System.out.println("That is an error; You cannot add a negative amount of a menu item.");
                    badInput = true;
                }
            }
            catch (ItemNotFoundException e)
            {
                System.out.println("That is an error: " + userInputName + " is not an item in the menu.");
                badInput = true;
            }
            catch (Exception e)
            {
                System.out.println("An Error has occurred: Invalid Input");
                badInput = true;
            }

        } while(badInput);

        System.out.println("The amount of " + userInputName + " has successfully been increased by " + userInputAmount);
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
            while ((quantity < 0) || quantity > itemQuantity.get(item - 1)){
                System.out.println("Invalid value. Please try again or press 0 to go back to the inventory");
                quantity = scanner2.nextInt();}
            itemQuantity.set(item - 1, itemQuantity.get(item - 1) - quantity); //set the value at index of item-1

        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("Invalid index. Please try again!");
        }
        //exception handling with the input which is not a number
        catch(InputMismatchException ime) {
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
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    static void printVendor() {
        System.out.println("Index\t" + "Vendor Name\t\t" + "Item Name\t\t" + "Unit\t" + "Quantity\t" + "Note");
        Vendors costco = new Vendors("Costco");
        VendorData costcoCSV = new VendorDataCSV(costco);
        int count = 1;

        for (VendorIngredientPrices vendorIngredientPrice : costcoCSV.importVendorIngredients()) {
            System.out.println("\t" + count+ "\t" + vendorIngredientPrice.getVendor().getName() + "\t\t\t"
                    + vendorIngredientPrice.getIngredient().getIngredientName() + "\t\t"
                    + vendorIngredientPrice.getIngredient().getUnit() + "\t\t"
                    + vendorIngredientPrice.getIngredient().getQuantity() + "\t\t");
            count++;

        }
        System.out.println("\n");
    }
}




        /*
        //        int option = 0;
//        while (true) {
//            option = displayMenu();-=
//            switch (option) {
//                case 1:
//                    printAll(); //Display the items
//                    break;
//                case 2:
//                    addQuantity(); //add to the item quantity
//                    break;
//                case 3:
//                    subtractQuantity(); //subtract the item quantity
//                    break;
//                case 4:
//                    System.out.println("Exiting...");
//                    System.exit(0);
//                default:
//                    System.out.println("Invalid choice, try again");
//                    break;
//            }
//        }


        scene1 = new Scene(layout1, 800, 400);

        //Button 5, 6, 7, 8 in scene2
        Button button5 = new Button("Back");
        button5.setOnAction(e -> window.setScene(scene1));//When we click on the button, the scene changes to scene 1
        Button button6 = new Button("Drink");
       // button6.setOnAction(e -> new Drink());
        Button button7 = new Button("Pastry");
       // button7.setOnAction(e -> new Pastry());
        Button button8 = new Button("exit");
        button8.setOnAction(e -> window.close());

        //Layout 2
        Stage window2 = new Stage();
        VBox layout2 = new VBox (20);
        layout2.getChildren().addAll(button5,button6,button7,button8);

        scene2 = new Scene(layout2,600, 300);

        window.setScene(scene1);
        window2.setScene(scene2);
        window.setTitle("SDCCD CAFETERIA");
        window.show();

         */

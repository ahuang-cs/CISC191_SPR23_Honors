
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

    static void addItemQuantity()
    {
        // Verify that there exist menu items to modify
        if (inventory.getMenuItemList().length > 0)
        {
            Scanner keyboard = new Scanner(System.in);
            String userInputName = "";
            int userInputAmount = 0;
            int finalItemAmount = 0;
            boolean badInput = false;

            do
            {
                System.out.print("Which menu item would you like to change? ");
                userInputName = keyboard.nextLine();
                System.out.print("How much of this item would you like to add? ");
                badInput = false;

                try
                {
                    userInputAmount = keyboard.nextInt();
                    finalItemAmount = inventory.getMenuItemAmount(userInputName) + userInputAmount;
                    inventory.setMenuItemAmount(userInputName, finalItemAmount);
                }
                catch (ItemNotFoundException e)
                {
                    System.out.println("That is an error: " + userInputName + " is not an item in the menu.");
                    keyboard.nextLine();
                    badInput = true;
                }
                catch (InputMismatchException e)
                {
                    System.out.println("The value you entered is not an integer. Please enter a positive integer value.");
                    keyboard.nextLine();
                    badInput = true;
                }
                catch (Exception e)
                {
                    System.out.println("An Error has occurred: Invalid Input");
                    keyboard.nextLine();
                    badInput = true;
                }

                if (!badInput && (userInputAmount < 0))
                {
                    // The user input a negative number
                    // Undo the erroneous calculation
                    try
                    {
                        inventory.setMenuItemAmount(userInputName, finalItemAmount - userInputAmount);
                    }
                    catch (ItemNotFoundException e)
                    {
                        // Do nothing.
                    }

                    // Print out an error message
                    System.out.println("This is an error: You cannot add a negative amount of a menu item.");
                    keyboard.nextLine();
                    badInput = true;
                }
            } while(badInput);

            System.out.println("The amount of " + userInputName + " has successfully been increased by " + userInputAmount);
        }
        else
        {
            System.out.println("There are no Menu Items to modify.");
        }
    }

    static void subtractItemQuantity()
    {
        if (inventory.getMenuItemList().length > 0)
        {
            Scanner keyboard = new Scanner(System.in);
            String userInputName = "";
            int userInputAmount = 0;
            int finalItemAmount = 0;
            boolean badInput = false;

            do
            {
                badInput = false;

                System.out.print("Which Menu Item would you like to change? ");
                userInputName = keyboard.nextLine();
                System.out.println("How much of this item would you like to remove?");

                // Validate user input.
                try
                {
                    userInputAmount = keyboard.nextInt();
                    finalItemAmount = inventory.getMenuItemAmount(userInputName) - userInputAmount;
                    inventory.setMenuItemAmount(userInputName, finalItemAmount);
                }
                catch (ItemNotFoundException e)
                {
                    System.out.println("That is an error: " + userInputName + " is not an item in the menu.");
                    keyboard.nextLine();
                    badInput = true;
                }
                catch(InputMismatchException e)
                {
                    System.out.println("The value you entered is not an integer. Please enter a positive integer value.");
                    keyboard.nextLine();
                    badInput = true;
                }
                catch (Exception e)
                {
                    System.out.println("An error has occurred: Invalid Input");
                    keyboard.nextLine();
                    badInput = true;
                }

                if (!badInput && userInputAmount < 0)
                {
                    // The user input a negative number, effectively adding the amount to the inventory.
                    // Undo erroneous calculation.
                    try
                    {
                        inventory.setMenuItemAmount(userInputName, finalItemAmount + userInputAmount);
                    }
                    catch (ItemNotFoundException e)
                    {
                        // Do nothing.
                    }

                    // Print out error message.
                    System.out.println("This is an error: You cannot remove a negative amount of a menu item.");
                    keyboard.nextLine();
                    badInput = true;
                }
                else if (!badInput && finalItemAmount < 0)
                {
                    // The user attempted to remove more of the menu item than there is present in the inventory.
                    // Undo erroneous Calculation
                    try
                    {
                        inventory.setMenuItemAmount(userInputName, finalItemAmount + userInputAmount);
                    }
                    catch (ItemNotFoundException e)
                    {
                        // Do nothing.
                    }

                    System.out.println("This is an error: You cannot remove " + userInputAmount + " of this item.");
                    System.out.print("There are only " + (finalItemAmount + userInputAmount) + " of this item ");
                    System.out.println("in the inventory.");
                    keyboard.nextLine();
                    badInput = true;
                }
            } while(badInput);

            System.out.println("The amount of " + userInputName + " has successfully been decreased by " + userInputAmount);
        }
        else
        {
            System.out.println("There are no Menu Items to modify.");
        }

    }

    static void addMenuItem()
    {
        Scanner keyboard = new Scanner(System.in);

        // Prompt the user for input and store that input in userChoice.
        int userChoice = showMenuItemOptions();

        // Process the user input
        switch (userChoice)
        {
            case 1:
            {
                Coffee newCoffee = new Coffee();

                System.out.print("Enter the name of this Menu Item: ");
                newCoffee.setName(keyboard.nextLine());
                System.out.print("Enter the sale price: ");
                newCoffee.setSalePrice(keyboard.nextDouble());
                System.out.println("Enter the amount of this Menu Item to be added to the inventory: ");

                inventory.addMenuItem(newCoffee, keyboard.nextInt());

                System.out.println(newCoffee.getName() + " has been successfully added to the inventory.");

                break;
            }
            case 2:
            {
                Donut newDonut = new Donut();

                System.out.print("Enter the name of this Menu Item: ");
                newDonut.setName(keyboard.nextLine());
                System.out.print("Enter the sale price: ");
                newDonut.setSalePrice(keyboard.nextDouble());
                System.out.println("Enter the amount of this Menu Item to be added to the inventory: ");

                inventory.addMenuItem(newDonut, keyboard.nextInt());

                System.out.println(newDonut.getName() + " has been successfully added to the inventory.");
                break;
            }
            case 3:
            {
                Drink newDrink = new Drink();

                System.out.print("Enter the name of this Menu Item: ");
                newDrink.setName(keyboard.nextLine());
                System.out.print("Enter the sale price: ");
                newDrink.setSalePrice(keyboard.nextDouble());
                System.out.println("Enter the amount of this Menu Item to be added to the inventory: ");

                inventory.addMenuItem(newDrink, keyboard.nextInt());

                System.out.println(newDrink.getName() + " has been successfully added to the inventory.");
                break;
            }
            case 4:
            {
                Pastry newPastry = new Pastry();

                System.out.print("Enter the name of this Menu Item: ");
                newPastry.setName(keyboard.nextLine());
                System.out.print("Enter the sale price: ");
                newPastry.setSalePrice(keyboard.nextDouble());
                System.out.println("Enter the amount of this Menu Item to be added to the inventory: ");

                inventory.addMenuItem(newPastry, keyboard.nextInt());

                System.out.println(newPastry.getName() + " has been successfully added to the inventory.");
                break;
            }
            case 5:
            {
                MenuItem newItem = new MenuItem();

                System.out.print("Enter the name of this Menu Item: ");
                newItem.setName(keyboard.nextLine());
                System.out.print("Enter the sale price: ");
                newItem.setSalePrice(keyboard.nextDouble());
                System.out.println("Enter the amount of this Menu Item to be added to the inventory: ");

                inventory.addMenuItem(newItem, keyboard.nextInt());

                System.out.println(newItem.getName() + " has been successfully added to the inventory.");
                break;
            }
        }

    }

    /**
     * Prompts the user to make a selection for a type of Menu Item to be added in addMenuItem().
     * Validates user input and returns the selection.
     * @return An integer corresponding to a specific menu option.
     */
    static int showMenuItemOptions()
    {
        Scanner keyboard = new Scanner(System.in);
        int userChoice = 0;
        boolean badInput = false;

        // Display the menu and retrieve user input until a proper value has been reached.
        do
        {
            badInput = false;

            System.out.println("What type of Menu Item would you like to add?");
            System.out.println("[1]: Coffee");
            System.out.println("[2]: Donut");
            System.out.println("[3]: Miscellaneous Drink");
            System.out.println("[4]: Miscellaneous Pastry");
            System.out.println("[5]: Other");
            System.out.print("Enter the number of your choice, then press <ENTER>: ");

            // Receive and validate user input.
            try
            {
                userChoice = keyboard.nextInt();
            }
            catch(InputMismatchException e)
            {
                System.out.println("The value you entered is not an integer. Please enter an integer from 1 - 5.");
                keyboard.nextLine();
                badInput = true;
            }
            catch(Exception e)
            {
                System.out.println("An error has occurred; Please enter an integer from 1-5.");
                keyboard.nextLine();
                badInput = true;
            }

            // Make sure the user input is from 1-5.
            if (!badInput && ((userChoice < 1) || (userChoice > 5)))
            {
                System.out.println(userChoice + " is not a valid option.");
                System.out.println("Please select a valid menu option from [1] to [5].");
                keyboard.nextLine();
                badInput = true;
            }

        } while (badInput);

        return userChoice;
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

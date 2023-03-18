
package edu.sdccd.cisc191.template;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CoffeeShop extends Application {

    static InventoryManager inventory;      // Manages the inventory of Menu Items and Ingredients.

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

            System.out.println("***************************** Menu Items *****************************");

            System.out.println("Menu Item:                                         Quantity:  Price:  ");

            for (int i = 0; i < menuItems.length; i++)
            {
                menuItemName = menuItems[i].getName();
                menuItemPrice = menuItems[i].getSalePrice();
                System.out.printf("%-50s %-10d %.2f\n", menuItemName, inventory.getMenuItemAmount(menuItemName), menuItemPrice);
            }

            System.out.println("**********************************************************************");
            System.out.println("\n");
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
        boolean badInput = false;
        String itemName = "";
        double itemPrice = 0.0;
        int itemAmount = 0;

        // Prompt the user for input and store that input in userChoice.
        int userChoice = showMenuItemOptions();

        // Prompt the user to enter the name of the menu item to be created.
        System.out.print("Enter the name of this Menu Item: ");
        itemName = keyboard.nextLine();

        // Prompt the user to enter the price of the menu item to be created.
        // Validate user input.
        do
        {
            badInput = false;

            System.out.print("Enter the sale price: ");
            // Catch the item price
            try
            {
                itemPrice = keyboard.nextDouble();
            }
            catch (InputMismatchException e)
            {
                System.out.println("ERROR: That is not a valid sale price. ");
                System.out.println("Please enter a positive decimal value for the sale price.");
                keyboard.nextLine();
                badInput = true;
            }
            catch (Exception e)
            {
                System.out.println("ERROR: An error has occurred with your input.");
                System.out.println("Please enter a positive decimal value for the sale price. ");
                keyboard.nextLine();
                badInput = true;
            }

            // Check whether the item price is negative.
            if (itemPrice < 0)
            {
                System.out.println("ERROR: " + itemPrice + " is negative and is therefore not a valid item price.");
                System.out.println("Please enter a positive decimal value for the sale price.");
                keyboard.nextLine();
                badInput = true;
            }
        } while (badInput);

        // Prompt the user to enter the amount of the item to be added into the inventory.
        // Validate user input.
        do
        {
            badInput = false;

            System.out.println("Enter the amount of this Menu Item to be added to the inventory: ");
            // Catch the item price
            try
            {
                itemAmount = keyboard.nextInt();
            }
            catch (InputMismatchException e)
            {
                System.out.println("ERROR: That is not a valid amount. ");
                System.out.println("Please enter a positive integer value for the amount.");
                keyboard.nextLine();
                badInput = true;
            }
            catch (Exception e)
            {
                System.out.println("ERROR: An error has occurred with your input.");
                System.out.println("Please enter a positive integer value for the amount.");
                keyboard.nextLine();
                badInput = true;
            }

            // Check whether the item price is negative.
            if (itemAmount < 0)
            {
                System.out.println("ERROR: " + itemAmount + " is negative and is therefore not a valid input.");
                System.out.println("Please enter a positive integer value for the amount to be added to the inventory.");
                keyboard.nextLine();
                badInput = true;
            }
        } while (badInput);

        // Process the user input
        switch (userChoice)
        {
            case 1:
            {
                Coffee newItem = new Coffee();
                newItem.setName(itemName);
                newItem.setSalePrice(itemPrice);
                inventory.addMenuItem(newItem, itemAmount);
                System.out.println(newItem.getName() + " has been successfully added to the inventory.");
                break;
            }
            case 2:
            {
                Donut newItem = new Donut();
                newItem.setName(itemName);
                newItem.setSalePrice(itemPrice);
                inventory.addMenuItem(newItem, itemAmount);
                System.out.println(newItem.getName() + " has been successfully added to the inventory.");
                break;
            }
            case 3:
            {
                Drink newItem = new Drink();
                newItem.setName(itemName);
                newItem.setSalePrice(itemPrice);
                inventory.addMenuItem(newItem, itemAmount);
                System.out.println(newItem.getName() + " has been successfully added to the inventory.");
                break;
            }
            case 4:
            {
                Pastry newItem = new Pastry();
                newItem.setName(itemName);
                newItem.setSalePrice(itemPrice);
                inventory.addMenuItem(newItem, itemAmount);
                System.out.println(newItem.getName() + " has been successfully added to the inventory.");
                break;
            }
            case 5:
            {
                MenuItem newItem = new MenuItem();
                newItem.setName(itemName);
                newItem.setSalePrice(itemPrice);
                inventory.addMenuItem(newItem, itemAmount);
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










    public void addNewIngredient(){
        Scanner keyboard = new Scanner(System.in);

        String ingredientName;
        double quantity;

        System.out.println("Ingredient name: ");

        ingredientName = keyboard.nextLine();

        System.out.println("Enter the amount of this ingredient in storage: ");

    }




















}
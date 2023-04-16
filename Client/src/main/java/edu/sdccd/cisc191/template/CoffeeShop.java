
package edu.sdccd.cisc191.template;

import edu.sdccd.cisc191.template.Ingredient.Ingredient;
import edu.sdccd.cisc191.template.MenuItem.MenuItem;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CoffeeShop{
    static InventoryManager inventory;      // Manages the inventory of Menu Items and Ingredients.

    public static void main(String[] args) {
        inventory = new InventoryManager();
    }

    static void printAllMenuItems() throws ItemNotFoundException
    {
        List<MenuItem> menuItems = inventory.getMenuItemList();
        // New code
        if (menuItems.size() == 0)
        {
            System.out.println("There are no Menu Items in the inventory right now.");
        }
        else
        {
            String menuItemName = "";
            double menuItemPrice = 0.0;

            System.out.println("***************************** Menu Items *****************************");

            System.out.println("Menu Item:                                         Quantity:  Price:  ");

            for (MenuItem menuItem : menuItems) {
                menuItemName = menuItem.getName();
                menuItemPrice = menuItem.getSalePrice();
                //.getMenuItemAmount not working
                //System.out.printf("%-50s %-10d %.2f\n", menuItemName, inventory.getMenuItemAmount(menuItemName), menuItemPrice);
                System.out.printf("%-50s %-10d %.2f\n", menuItemName, 1, menuItemPrice);
            }

            System.out.println("**********************************************************************");
            System.out.println("\n");
        }
    }

    static void addItemQuantity()
    {
        // Verify that there exist menu items to modify
        if (inventory.getMenuItemList().size() > 0)
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
        if (inventory.getMenuItemList().size() > 0)
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
        MenuItem newItem = new MenuItem();
        List<Ingredient> recipe = new ArrayList<>();
        switch (userChoice)
        {
            case 1: //coffee
            {
                newItem.setName(itemName);
                newItem.setSalePrice(itemPrice);
                recipe.add(new Ingredient("Coffee beans", Ingredient.Units.OZ, 0.4));
                recipe.add(new Ingredient("Creamer", Ingredient.Units.fluidOZ, 0.5));
                newItem.setRecipe();
                break;
            }
            case 2: //donut
            {
                newItem.setName(itemName);
                newItem.setSalePrice(itemPrice);


            }
            case 3: //other
            {
                newItem.setName(itemName);
                newItem.setSalePrice(itemPrice);
                break;
            }

        }
        inventory.addMenuItem(newItem, itemAmount);
        System.out.println(newItem.getName() + " has been successfully added to the inventory.");

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
            System.out.println("[3]: Other");
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
            if (!badInput && ((userChoice < 1) || (userChoice > 3)))
            {
                System.out.println(userChoice + " is not a valid option.");
                System.out.println("Please select a valid menu option from [1] to [5].");
                keyboard.nextLine();
                badInput = true;
            }

        } while (badInput);

        return userChoice;
    }


    static void printVendor() {
        System.out.println("Index\t" + "Vendor Name\t\t" + "Item Name\t\t" + "Unit\t" + "Quantity\t" + "Note");
        Vendor costco = new Vendor("Costco");
        VendorData costcoCSV = new VendorDataCSV(costco);
        int count = 1;
        try {
            List<VendorIngredientPrices> allVendorIngredients = costcoCSV.importVendorIngredients();
            for (VendorIngredientPrices vendorIngredientPrice : allVendorIngredients) {
                System.out.println("\t" + count+ "\t" + vendorIngredientPrice.getVendor().getName() + "\t\t\t"
                        + vendorIngredientPrice.getIngredient().getIngredientName() + "\t\t"
                        + vendorIngredientPrice.getIngredient().getUnit() + "\t\t");
                count++;

            }
            System.out.println("\n");
        }catch (URISyntaxException e){
            System.out.println("URI Error importing"+e);
        }
        catch (IOException e){
            System.out.println("IO Error importing "+e);
        }

    }
}
package edu.sdccd.cisc191.template;

import java.net.*;
import java.io.*;

/**
 * This program opens a connection to a computer specified
 * as the first command-line argument.  If no command-line
 * argument is given, it prompts the user for a computer
 * to connect to.  The connection is made to
 * the port specified by LISTENING_PORT.  The program reads one
 * line of text from the connection and then closes the
 * connection.  It displays the text that it read on
 * standard output.  This program is meant to be used with
 * the server program, DateServer, which sends the current
 * date and time on the computer where the server is running.
 */

public class Client {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void startConnection(String ip, int port) throws IOException {
        clientSocket = new Socket(ip, port);
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    public CustomerResponse sendRequest() throws Exception {
        out.println(CustomerRequest.toJSON(new CustomerRequest(1)));
        return CustomerResponse.fromJSON(in.readLine());
    }

    public void stopConnection() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
    }
    public static void main(String[] args)
    {
        // Testing here (Will be deleted in future commit)
        MenuItem item = new MenuItem();

        // Testing default constructor:
        System.out.println("Default name: " + item.getName());
        System.out.println("Default price: " + item.getSalePrice());
        System.out.println("Default toString: " + item);
        //creating a new line
        System.out.println();

        // Testing setter methods:
        System.out.println("Changing values...");
        item.setName("Foodstuffs");
        item.setSalePrice(9.99);

        // Printing Results:
        System.out.println("New name: " + item.getName());
        System.out.println("New price: " + item.getSalePrice());
        System.out.println("New toString: " + item);
        //creating a new line
        System.out.println();


        Ingredient flour = new Ingredient ("Flour");
        Ingredient sugar = new Ingredient ("Sugar");
        Ingredient water = new Ingredient ("Water");
        Ingredient escargot = new Ingredient ("Escargot");
        Ingredient egg =  new Ingredient ("Egg");

        // Adding stuff to the recipe.
        System.out.println("Adding stuff to the recipe...");
        Recipe itemRecipe = new Recipe(new Ingredient[]{
                flour,
                flour,
                sugar,
                water,
                escargot,
                egg
        });

        item.setRecipe(itemRecipe);
        itemRecipe.printIngredientList();

        //creating a new line
        System.out.println();

        // Removing items from recipe:
        System.out.println("Removing items from recipe:");
        item.getRecipe().removeIngredient(escargot);

        itemRecipe.printIngredientList();

        //creating a new line
        System.out.println();

        // Demonstrating one-way access capabilities
        System.out.println("Adding recipe from the accessor method:");
        item.getRecipe().addIngredient(new Ingredient ("Wine"));

        itemRecipe.printIngredientList();

        //creating a new line
        System.out.println();

        // Removing invalid items from recipe:
        System.out.println("Attempting to remove invalid items from recipe:");
        itemRecipe.removeIngredient(new Ingredient ("Gasoline"));

        //creating a new line
        System.out.println();

        // Clearing recipe:
        System.out.println("Clearing Recipe: ");
        itemRecipe.clearIngredients();

        itemRecipe.printIngredientList();

        //creating a new line
        System.out.println();

        //Testing Drink Class
        System.out.println("Testing Drink Class: ");

        Ingredient[] classicCappuccinoIngredients = {
                new Ingredient("Coffee"),
                new Ingredient("Milk"),
                new Ingredient("Milk Foam")
        };

        Drink classicCappuccino = new Drink("Cappuccino Classico", 3.99, Size.small, true);
        classicCappuccino.setRecipe(new Recipe(classicCappuccinoIngredients));
        classicCappuccino.getRecipe().printIngredientList();
        classicCappuccino.setVolume(8);


        System.out.println(classicCappuccino + ", " + classicCappuccino.getVolume() + " oz.");

        // ********** TESTING INGREDIENT CLASS ***********
        System.out.println("\n\nMaking a new ingredient: \n");
        Ingredient heavyCream = new Ingredient("Heavy Cream");

        System.out.println("Ingredient name: " + heavyCream.getName());
        System.out.println("Ingredient price: " + heavyCream.getUnitPrice());
        System.out.println("Ingredient Expiry Date: " + heavyCream.getExpirationDate());
        System.out.println("Ingredient is Organic? " + heavyCream.getOrganic());
        System.out.println("Ingredient has Caffeine? " + heavyCream.getCaffeine());
        System.out.println("Ingredient has Gluten? " + heavyCream.getGluten());
        System.out.println("Ingredient is Vegan Friendly? " + heavyCream.getVeganFriendly());

        // Testing Ingredient Mutators

        System.out.println("\nTesting Ingredient Setter Methods: \n");
        heavyCream.setName("Instant Coffee Mix");
        heavyCream.setUnitPrice(8.79);
        heavyCream.setExpirationDate("April 15");
        heavyCream.setOrganic(false);
        heavyCream.setCaffeine(true);
        heavyCream.setGluten(true);
        heavyCream.setVeganFriendly(true);

        // Printing Changed Information:

        System.out.println("Ingredient name: " + heavyCream.getName());
        System.out.println("Ingredient price: " + heavyCream.getUnitPrice());
        System.out.println("Ingredient Expiry Date: " + heavyCream.getExpirationDate());
        System.out.println("Ingredient is Organic? " + heavyCream.getOrganic());
        System.out.println("Ingredient has Caffeine? " + heavyCream.getCaffeine());
        System.out.println("Ingredient has Gluten? " + heavyCream.getGluten());
        System.out.println("Ingredient is Vegan Friendly? " + heavyCream.getVeganFriendly());

        // Testing CountedIngredient Class
        System.out.println("\nCreating a new Counted Ingredient... ");
        CountedIngredient eggs = new CountedIngredient("Eggs", 12);

        System.out.println("Ingredient Name: " + eggs.getName());
        System.out.println("Ingredient Amount: " + eggs.getQuantity());

        System.out.println("Adding two eggs...");
        eggs.addQuantity(2);
        System.out.println("Ingredient Amount: " + eggs.getQuantity());

        System.out.println("Removing six eggs...");
        eggs.removeQuantity(6);
        System.out.println("Ingredient Amount: " + eggs.getQuantity());

        System.out.println("Removing all eggs...");
        eggs.setQuantity(0);
        System.out.println("Ingredient Amount: " + eggs.getQuantity());

        System.out.println("Refrigeration... " + eggs.getRefrigerated());
        eggs.setRefrigerated(true);
        System.out.println("Refrigeration... " + eggs.getRefrigerated());















        /*
        Client client = new Client();
        try {
            client.startConnection("127.0.0.1", 4444);
            System.out.println(client.sendRequest().toString());
            client.stopConnection();
        } catch(Exception e) {
            e.printStackTrace();
        }
        */

    }   // End public static void main(String[] args)
} //end class Client


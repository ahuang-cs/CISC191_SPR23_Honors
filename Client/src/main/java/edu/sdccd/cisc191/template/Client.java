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
        MenuItem foodstuffs = new MenuItem();

        // Testing default constructor:
        System.out.println("Default name: " + foodstuffs.getName());
        System.out.println("Default price: " + foodstuffs.getSalePrice());
        System.out.println("Default toString: " + foodstuffs);

        // Testing setter methods:
        System.out.println("Changing values... \n");
        foodstuffs.setName("Foodstuffs");
        foodstuffs.setSalePrice(9.99);

        // Printing Results:
        System.out.println("New name: " + foodstuffs.getName());
        System.out.println("New price: " + foodstuffs.getSalePrice());
        System.out.println("New toString: " + foodstuffs);

        // Adding stuff to the recipe.
        System.out.println("Adding stuff to the recipe... \n");
        foodstuffs.addToRecipe("Flour");
        foodstuffs.addToRecipe("Sugar");
        foodstuffs.addToRecipe("Water");
        foodstuffs.addToRecipe("Escargot");
        foodstuffs.addToRecipe("Eggs");

        // Printing recipe
        for (int i = 0; i < foodstuffs.getRecipe().length; i++)
        {
            System.out.println(foodstuffs.getRecipe()[i]);
        }

        // Removing items from recipe:
        System.out.println("Removing items from recipe:");
        foodstuffs.removeFromRecipe("Escargot");

        // Printing recipe:
        System.out.println("New Recipe: ");
        for (int i = 0; i < foodstuffs.getRecipe().length; i++)
        {
            System.out.println(foodstuffs.getRecipe()[i]);
        }

        // Demonstrating one-way access capabilities
        System.out.println("Adding recipe from the accessor method:");
        foodstuffs.getRecipe()[2] = "Wine";

        // Printing Recipe:
        System.out.println("New Recipe: ");
        for (int i = 0; i < foodstuffs.getRecipe().length; i++)
        {
            System.out.println(foodstuffs.getRecipe()[i]);
        }

        // Clearing recipe:
        System.out.println("Clearing Recipe: ");
        foodstuffs.clearRecipe();

        // Printing recipe:
        System.out.println("New Recipe: ");
        for (int i = 0; i < foodstuffs.getRecipe().length; i++)
        {
            System.out.println(foodstuffs.getRecipe()[i]);
        }
        System.out.println("\n");

        System.out.println("Testing Drink Class: \n");

        Drink classicCappuccino = new Drink("Cappuccino Classico", 3.99, "small", true);
        classicCappuccino.addToRecipe("Double Espresso");
        classicCappuccino.addToRecipe("Milk");
        classicCappuccino.addToRecipe("Milk Foam");
        classicCappuccino.setVolume(8);

        for (int i = 0; i < classicCappuccino.getRecipe().length; i++)
        {
            System.out.println(classicCappuccino.getRecipe()[i]);
        }

        System.out.println(classicCappuccino + ", " + classicCappuccino.getVolume() + " oz.");












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


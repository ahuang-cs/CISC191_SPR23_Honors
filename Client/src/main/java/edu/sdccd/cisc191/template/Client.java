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

        // Testing setter methods:
        System.out.println("Changing values... \n");
        item.setName("Foodstuffs");
        item.setSalePrice(9.99);

        // Printing Results:
        System.out.println("New name: " + item.getName());
        System.out.println("New price: " + item.getSalePrice());
        System.out.println("New toString: " + item);

        // Adding stuff to the recipe.
        System.out.println("Adding stuff to the recipe... \n");
        item.addToRecipe("Flour");
        item.addToRecipe("Flour");      //To test that you cannot add two of the same ingredient
        item.addToRecipe("Sugar");
        item.addToRecipe("Water");
        item.addToRecipe("Escargot");
        item.addToRecipe("Eggs");

        // Printing recipe
        for (int i = 0; i < item.getRecipe().length; i++)
        {
            System.out.println(item.getRecipe()[i]);
        }

        // Removing items from recipe:
        System.out.println("Removing items from recipe:");
        item.removeFromRecipe("Escargot");

        // Printing recipe:
        System.out.println("New Recipe: ");
        for (int i = 0; i < item.getRecipe().length; i++)
        {
            System.out.println(item.getRecipe()[i]);
        }

        // Demonstrating one-way access capabilities
        System.out.println("Adding recipe from the accessor method:");
        item.getRecipe()[2] = "Wine";

        // Printing Recipe:
        System.out.println("New Recipe: ");
        for (int i = 0; i < item.getRecipe().length; i++)
        {
            System.out.println(item.getRecipe()[i]);
        }

        // Clearing recipe:
        System.out.println("Clearing Recipe: ");
        item.clearRecipe();

        // Printing recipe:
        System.out.println("New Recipe: ");
        for (int i = 0; i < item.getRecipe().length; i++)
        {
            System.out.println(item.getRecipe()[i]);
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


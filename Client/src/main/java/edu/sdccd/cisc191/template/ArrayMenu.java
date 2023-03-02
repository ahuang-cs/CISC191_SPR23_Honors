package edu.sdccd.cisc191.template;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;


public class ArrayMenu {


    //string array(menu item)
    static ArrayList<String> array = new ArrayList<>();  // initialize an empty array


    static ArrayList<Integer> quantityArray = new ArrayList<>();


    public static void main(String[] args) {
        //if its the users first time using the program,we can make a method where if the array length
        //is less than 0, it would print out "no items added right now"
        String[] items = new String[0];
        displayItems(items);





        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Get value at index"); //inputs index and returns  the item menu
            System.out.println("2. Enter menu item and quantity"); //-enter the item menu and quanity
            System.out.println("3. Find index of value"); //-will find the index of what item is inputted
            System.out.println("4. Print all values"); //-print the menu
            System.out.println("5. Delete value at index"); //-will delete the item and quanity
            System.out.println("6. Restock item"); //- replaces the quantity
            System.out.println("7. Shrink array"); //- Not inputted yet
            System.out.println("8. Quit");

            System.out.print("Enter choice: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    getAtIndex();
                    break;
                case "2":
                    setAtIndex();
                    break;
                case "3":
                    findIndexOf();
                    break;
                case "4":
                    printAll();
                    break;
                case "5":
                    deleteAtIndex();
                    break;
                case "6":
                    addQuantity();
                    break;
                case "7":
                    //shrink();
                    break;
                case "8":
                    System.out.println("Exiting");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice, try again");
                    break;
            }
        }
    }

    public static void displayItems (String[] items){
        if (items.length == 0) {
            System.out.println("No items added right now");
            return;
        }


        for (String item : items) {
            System.out.println(item);
        }
    }


    static void getAtIndex() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter index #: ");
            int index = scanner.nextInt();
            System.out.println("Value at index " + index + " is " + array.get(index));
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("Invalid index");
        }
    }


    static void setAtIndex() {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter menu item: ");
        String value = scanner.next();
        array.add(value);
        System.out.println("Enter item quantity");
        int quantity = scanner.nextInt();
        quantityArray.add(quantity);
        System.out.println("Menu item set");


    }


    static void findIndexOf() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter value: ");
        String value = scanner.next();
        int index = array.indexOf(value);
        if (index == -1) {
            System.out.println(value + " not found in array");
        } else {
            System.out.println("Index of " + value + " is " + index);
        }
    }


    static void printAll() {
        for (int i = 0; i < array.size(); i++) {
            System.out.println((i + 1) + "\t" + array.get(i) + "\t" + quantityArray.get(i));
        }
    }


    static void deleteAtIndex() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter index: ");
            int index = scanner.nextInt();
            array.remove(index);
            System.out.println("Value deleted");
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("Invalid index");
        }
    }

    static void addQuantity() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What items would you like to add");
        int item = scanner.nextInt();
        System.out.println("Enter how many items you would like to restock");
        int quantity = scanner.nextInt();
        for (int i = 0; i < quantityArray.size(); i++) {
            //testing
            quantityArray.set(item - 1, quantity);
            //quantityArray[item - 1] = quantityArray[item - 1] +quantity;


        }


    }


//    static void expand() {
//        Scanner scanner = new Scanner(System.in);
//        try {
//            System.out.print("Enter size: ");
//            int size = scanner.nextInt();
//            for (int i = 0; i < size; i++) {
//                array.add(null);
//            }
//            System.out.println("Array expanded");
//        } catch (NumberFormatException e) {
//            System.out.println("Invalid size");
//        }
//    }
}





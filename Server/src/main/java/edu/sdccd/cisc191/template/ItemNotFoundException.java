package edu.sdccd.cisc191.template;

/*
 * This class is a special exception that is thrown when someone tries to access an item that does not exist in an
 * inventory.
 */
public class ItemNotFoundException extends Exception
{
    public ItemNotFoundException()
    {
        super("Item does not exist.");
    }
}

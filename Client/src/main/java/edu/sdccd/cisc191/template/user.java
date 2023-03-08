package edu.sdccd.cisc191.template;
//We use this just to display an example for Homepage

public class user {
    private String MenuItem;
    private int MenuIndex;
    private int Quantity;


    // add constuctor

    public user(int menuIndex,String menuItem,  int quantity) {
        this.MenuIndex = menuIndex;
        this.MenuItem = menuItem;
        this.Quantity = quantity;
    }



    public int getMenuIndex() {
        return MenuIndex;
    }
    public String getMenuItem() {
        return MenuItem;
    }

    public int getQuantity() {
        return Quantity;
    }




}

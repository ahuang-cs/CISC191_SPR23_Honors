package edu.sdccd.cisc191.template;
//this is for the add data page for the gui
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.net.URL;
import java.util.ResourceBundle;


public class tableViewScene2{
    /*//this is for the gui to display the array as columns in a table view
     */
    private int index;
    private String item;
    private int itemQuantity;

    public tableViewScene2(int index, String item, int itemQuantity) {
        this.index = index;
        this.item = item;
        this.itemQuantity = itemQuantity;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }
}

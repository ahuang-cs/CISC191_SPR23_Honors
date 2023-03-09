package edu.sdccd.cisc191.template;

public interface DrinksInterface {
    // calls on all the variables in the Drink class,
    void setSize(String newSize);
    //size of the drink
    void setVolume(int newVolume);
    //volume of the drink
    void setHeatValue(boolean isHot);
    // hot or not for the drink
    String getSize();
    // returns the size
    int getVolume();
    // returns the volume in ounces
    boolean getHeatValue();

    String toString();
    // this is just a string representation of the drink
}

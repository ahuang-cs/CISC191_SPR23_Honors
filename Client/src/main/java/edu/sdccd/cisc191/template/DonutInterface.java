package edu.sdccd.cisc191.template;

public interface DonutInterface {
    //methods from the donut class
    void addSprinkles();
    void removeSprinkles();
    void addGlaze();
    void removeGlaze();
    void addFilling(String fillingType);
    void removeFilling();
    //the boolean make sure we have the right state for the donut property
    boolean hasSprinkles();
    boolean isGlazed();
    boolean hasFilling();
    String getFillingType();
}



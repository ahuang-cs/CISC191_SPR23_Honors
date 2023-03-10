package edu.sdccd.cisc191.template;

public interface CoffeeInterface {
    // this implements the coffee class and defines several methods related to making different types of coffee.
    public void makeCoffee();
    void makeLatte(String espressoType, String milkType, boolean hasFoam, String flavor);
    void makeCappuccino(int espresso, int steamedMilk, int foam, String flavor);
    void makeFrozen(boolean isBlended, String flavor);
    void makeIced(boolean hasMilk);
}

//class coffee implements CoffeeInterface {
//
//    public void makeCoffee() {
//        // uses  coffee recipe
//    }
//
//    public void makeLatte(String espressoType, String milkType, boolean hasFoam, String flavor) {
//        // uses our Latte recipe
//    }
//
//    public void makeCappuccino(int espresso, int steamedMilk, int foam, String flavor) {
//        // uses our cappuccino recipe
//    }
//
//    public void makeFrozen(boolean isBlended, String flavor) {
//        // uses our frozen coffee recipe
//    }
//
//    public void makeIced(boolean hasMilk) {
//        // uses our iced coffee recipe
//    }
}

package edu.sdccd.cisc191.template;

public class Vendors {
    String name;

    public Vendors(){};


    public Vendors(String newName) {
        setName(newName);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

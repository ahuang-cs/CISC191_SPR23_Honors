package edu.sdccd.cisc191.template;

public class Vendor {
    String name;

    public Vendor(){};


    public Vendor(String newName) {
        setName(newName);

    }
    public static Vendor valueOf(String str) {
        String strname = String.valueOf(str);
        return new Vendor(strname);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

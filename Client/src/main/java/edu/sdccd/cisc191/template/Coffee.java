package edu.sdccd.cisc191.template;

//Created a class for Coffee
public class Coffee extends Drink
{
    private String roast;           //The type of roast of the Coffee being served
    private boolean hasSugar;       //Determines if the coffee has sugars or not

    public Coffee()
    {
        super();
        roast = "Dark";
        hasSugar = false;
    }

    public String getRoast() {
        return roast;
    }

    public void setRoast(String roast) {
        this.roast = roast;
    }

    public boolean isHasSugar() {
        return hasSugar;
    }

    public void setHasSugar(boolean hasSugar) {
        this.hasSugar = hasSugar;
    }
}

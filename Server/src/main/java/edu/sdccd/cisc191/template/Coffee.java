package edu.sdccd.cisc191.template;

//Created a class for Coffee
public class Coffee extends Drink
{
    private String roast;           // The type of roast of the Coffee being served (None specified by default).
    private boolean hasSugar;       // Determines if the coffee has sugars or not (false by default).

    /**
     * Constructor: Creates a new Coffee object with empty default values for all fields.
     *              hasSugar is set to false by default.
     */
    public Coffee()
    {
        super();
        roast = "";
        hasSugar = false;
    }

    /**
     * Returns the roast used to make this specific Coffee.
     * @return A string specifying the Roast name.
     */
    public String getRoast() {
        return roast;
    }

    /**
     * Sets the value of a String that specifies the type of Roast used to make this type of coffee.
     * @param roast A string with the name of the roast.
     */
    public void setRoast(String roast) {
        this.roast = roast;
    }

    /**
     * Returns whether or not the coffee has sugar.
     * @return A boolean value that is true when the coffee has sugar, false otherwise.
     */
    public boolean hasSugar() {
        return hasSugar;
    }

    /**
     * Specifies whether or not the coffee has sugar.
     * @param hasSugar True if the coffee has sugar, false otherwise.
     */
    public void setHasSugar(boolean hasSugar) {
        this.hasSugar = hasSugar;
    }
}

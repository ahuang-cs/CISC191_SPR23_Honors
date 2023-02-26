package edu.sdccd.cisc191.template;
/*
Example:
        Coffee
             TYPE
                - Black
                - Latte
                - Cappuccino

                - Frozen
                - Iced

            INGREDIENTS
                - Sugar
                - Drizzle
                    - Carmel
                    - Mocha
                    - Vanilla
                - Milk
                    - Almond
                    - Coconut
                -Creamer
                    -Hazelnut
                    -Vanilla
                    -Carmel
                    -Sweet Cream
 */
//Created a class for Coffee
public class Coffee extends Drink{
        public String creamer;      //Flavor of Creamer(Hazelnut-Vanilla-Carmel-Sweet_Cream)
        public String milk;         //Alternate milk derivative(Almond-Coconut)
        public String drizzle;          //Flavor of drizzle(Vanilla-Carmel-Mocha)

        // Default Constructor
        public Coffee(){
            super();
            this.creamer = "Hazelnut";
            this.milk = "Almond";
            this.drizzle = "Mocha";
        }

        /**
         * Constructor - creates an object of type Coffee
         * @param name The name of the drink
         * @param size The size of the drink (small, medium, large)
         * @param isHot Whether or not the coffee is hot.
         * @param creamer The type of creamer used.
         * @param milk The type of milk used in the drink.
         * @param drizzle The type of drizzle used on the drink.
         */
        public Coffee(String name, double price, String size, boolean isHot, String creamer, String milk, String drizzle)
        {
             super(name, price, size, isHot);
             this.creamer = creamer;
             this.milk = milk;
             this.drizzle = drizzle;
        }

        //Created and inner Class for a Standard cup of coffee with the options of cream, sugar, black
        private class Standard extends Coffee{
                private String roast;           //The type of roast of the Coffee being served
                private boolean hasSugar;       //Determines if the coffee has sugars or not

        }
        //Created an inner Class for to place the Lattes recipe
        private class Latte{

        }
        //Created an inner Class for to place the Cappuccinos recipe
        private class Cappuccino{

        }
        //Created an inner Class for to place the Frozen Coffees recipe
        private class Frozen{

        }
        //Created an inner Class for to place the Iced Coffees recipe
        private class Iced{

        }

}

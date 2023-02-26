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
            private String espressoType;   // The type of espresso used
            private String milkType;       // The type of milk used
            private boolean hasFoam;       // Whether or not the latte has foam
            private String flavor;         // Any additional flavor added to the latte

            public Latte(String espressoType, String milkType, boolean hasFoam, String flavor) {
                this.espressoType = espressoType;
                this.milkType = milkType;
                this.hasFoam = hasFoam;
                this.flavor = flavor;
            }

        }
        //Created an inner Class for to place the Cappuccinos recipe
        private class Cappuccino{
            private int espresso;       // Amount of espresso shots used
            private int steamedMilk;    // Amount of steamed milk used
            private int foam;           // Amount of foam used
            private String flavor;      // Optional flavoring

            public Cappuccino(int espresso, int steamedMilk, int foam, String flavor) {
                this.espresso = espresso;
                this.steamedMilk = steamedMilk;
                this.foam = foam;
                this.flavor = flavor;
            }

        }
        //Created an inner Class for to place the Frozen Coffees recipe
        private class Frozen{
            private boolean isBlended;  // Whether or not the frozen coffee is blended.
            private String flavor;      // The flavor of the frozen coffee.

            public Frozen() {
                super();
                this.isBlended = true;
                this.flavor = "Vanilla";
            }
            public Frozen(String name, double price, String size, boolean isHot, boolean isBlended, String flavor) {
                //super(name, price, size, isHot);
                this.isBlended = isBlended;
                this.flavor = flavor;
            }


        }
        //Created an inner Class for to place the Iced Coffees recipe
        private class Iced{
            private boolean hasMilk;
        }
    public Iced(){
        super();
        this.hasMilk = true;
    }
    // im not too sure what i can do here...

}

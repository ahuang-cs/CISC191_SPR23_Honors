package edu.sdccd.cisc191.template;

//import com.opencsv.CSVReader;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.sdccd.cisc191.template.Ingredient.Ingredient;

import java.io.*;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class VendorDataCSV implements VendorData {
    private Vendor vendor;

    public VendorDataCSV() {
        //vendor = newVendor;
    }

    public static void writeToCostcoFile() throws IOException {
        /** convert a list/JAVA into JSON format **/
        ObjectMapper mapper = new ObjectMapper();
        List<CostcoCSV> list = new ArrayList<>();

        //Add the ingredients to the list
        CostcoCSV costco1 = new CostcoCSV("Creamer", Ingredient.Units.GAL, 5.99);
        list.add(costco1);

        CostcoCSV costco2 = new CostcoCSV("Coffee Beans", Ingredient.Units.LB, 14.99);
        list.add(costco2);

        CostcoCSV costco3 = new CostcoCSV("Sugar", Ingredient.Units.LB, 29.99);
        list.add(costco3);

        CostcoCSV costco4 = new CostcoCSV("Milk", Ingredient.Units.GAL, 5.99);
        list.add(costco4);

        CostcoCSV costco5 = new CostcoCSV("Yeast", Ingredient.Units.LB, 4.99);
        list.add(costco5);

        CostcoCSV costco6 = new CostcoCSV("Eggs", Ingredient.Units.NUM, 0.99);
        list.add(costco6);

        CostcoCSV costco7 = new CostcoCSV("Butter", Ingredient.Units.LB, 4.99);
        list.add(costco7);

        CostcoCSV costco8 = new CostcoCSV("Flour", Ingredient.Units.LB, 1.99);
        list.add(costco8);

        //convert these ingredient data into Jason format and write to a new file
        mapper.writeValue(new File("Costco.json"), list); //write to a Jason file
    }

    @Override
    public List<CostcoCSV> importCostcoVendor() throws URISyntaxException, IOException {

        /** convert a list/JAVA into JSON format **/
       ObjectMapper mapper = new ObjectMapper();

        /** convert a JSON format into JAVA **/
       // ObjectMapper mapper1 = new ObjectMapper();
        File file = new File("Costco.json");

        /**convert JSON format into Object**/
        List<CostcoCSV> costcoList = mapper.readValue(file, new TypeReference<List<CostcoCSV>>() {
        });

        return costcoList;
    }

    public static void writeToWalmartFile() throws IOException {
        /** convert a list/JAVA into JSON format **/
        ObjectMapper mapper = new ObjectMapper();
        List<WalmartCSV> list = new ArrayList<>();

        //Add the ingredients to the list
        WalmartCSV costco1 = new WalmartCSV("Creamer", Ingredient.Units.GAL, 5.99);
        list.add(costco1);

        WalmartCSV costco2 = new WalmartCSV("Coffee Beans", Ingredient.Units.LB, 12.99);
        list.add(costco2);

        WalmartCSV costco3 = new WalmartCSV("Sugar", Ingredient.Units.LB, 28.99);
        list.add(costco3);

        WalmartCSV costco4 = new WalmartCSV("Milk", Ingredient.Units.GAL, 6.99);
        list.add(costco4);

        WalmartCSV costco5 = new WalmartCSV("Yeast", Ingredient.Units.LB, 5.99);
        list.add(costco5);

        WalmartCSV costco6 = new WalmartCSV("Eggs", Ingredient.Units.NUM, 0.99);
        list.add(costco6);

        WalmartCSV costco7 = new WalmartCSV("Butter", Ingredient.Units.LB, 4.99);
        list.add(costco7);

        WalmartCSV costco8 = new WalmartCSV("Flour", Ingredient.Units.LB, 1.99);
        list.add(costco8);

        //convert these ingredient data into Jason format and write to a new file
        String jsonData = mapper.writeValueAsString(list); //convert our Object into Jason data
        mapper.writeValue(new File("Walmart.json"), list); //write to a Jason file
    }
    public List<WalmartCSV> importWalmartVendor () throws URISyntaxException, IOException {


        /** convert a JSON format into JAVA **/
        ObjectMapper mapper = new ObjectMapper();
        File file = new File("Walmart.json");

        /**convert JSON format into Object**/
        List<WalmartCSV> walmartList = mapper.readValue(file, new TypeReference<List<WalmartCSV>>() {
        });

        return walmartList;
    }
}







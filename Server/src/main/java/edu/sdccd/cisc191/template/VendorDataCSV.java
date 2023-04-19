package edu.sdccd.cisc191.template;

//import com.opencsv.CSVReader;

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

    @Override
    public List<CostcoCSV> importVendorIngredients () throws URISyntaxException, IOException {

        /** convert a list/JAVA into JSON format **/
        ObjectMapper mapper = new ObjectMapper();
        List<CostcoCSV> list = new ArrayList<>();

        //Add the ingredients to the list
        CostcoCSV costco1 = new CostcoCSV("Cream", Ingredient.Units.GAL, 5.99);
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
        String jsonData = mapper.writeValueAsString(list); //convert our Object into Jason data
        mapper.writeValue(new File("data.json"), list); //write to a Jason file

        /** convert a JSON format into JAVA **/
        ObjectMapper mapper1 = new ObjectMapper();

        /**convert JSON format into Object**/
        List<CostcoCSV> list2 = mapper1.readValue(jsonData, new TypeReference<List<CostcoCSV>>() {
        });

        return list2;
    }
}







package edu.sdccd.cisc191.template;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.sdccd.cisc191.template.Ingredient.Ingredient;
import jdk.nashorn.internal.parser.JSONParser;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VendorDataCSVTest {

    @Test
    public void vendorDataCSVTest() throws IOException, URISyntaxException {
//        ObjectMapper mapper = new ObjectMapper();
//        List<CostcoCSV> list = null;
//        VendorDataCSV exportList = new VendorDataCSV();
//        list = exportList.importCostcoVendor();
//        File jsonFile = new File("Costco.json");

//        // Create a list of CostcoCSV objects to test
//        List<CostcoCSV> expectedList = new ArrayList<>();
//        expectedList.add(new CostcoCSV("Item 1",  10.99));
//        expectedList.add(new CostcoCSV("Item 2", 5.99));
//
//        // Serialize the list to JSON and write it to a file
//        ObjectMapper mapper = new ObjectMapper();
//        String json = mapper.writeValueAsString(expectedList);
//        File jsonFile = new File("Costco.json");
//        mapper.writeValue(jsonFile, expectedList);
//
//        // Deserialize the JSON from the file and compare it to the original list
//        VendorDataCSV vendorDataCSV = new VendorDataCSV();
//        List<CostcoCSV> actualList = vendorDataCSV().importCostcoVendor();
//        assertEquals(expectedList, actualList);

        // Clean up the file after the test completes
        //jsonFile.delete();

    }

}
package edu.sdccd.cisc191.template;

//import com.opencsv.CSVReader;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.CsvToBeanBuilder;
import edu.sdccd.cisc191.template.Ingredient.Ingredient;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class VendorDataCSV implements VendorData {
    private Vendor vendor;

    public VendorDataCSV(Vendor newVendor) {
        vendor = newVendor;
    }

    @Override
    public List<VendorIngredientPrices> importVendorIngredients () throws URISyntaxException, IOException {
        CSVReader csvReader = new CSVReaderBuilder(new InputStreamReader(new URL("VendorData.CSV").openStream()))
                .withSkipLines(1) // skip header row
                .build();

        List<CostcoCSV> costcoCSVList = new CsvToBeanBuilder<CostcoCSV>(csvReader)
                .withType(CostcoCSV.class)
                .build()
                .parse(); //parse the file into CostcoCSV class

        List<VendorIngredientPrices> vendorIngredientPriceList = new ArrayList<>();
        for (CostcoCSV costcoCSV : costcoCSVList) {
            VendorIngredientPrices vendorIngredientPrice = new VendorIngredientPrices(vendor, new Ingredient(costcoCSV.getIngredientName(), costcoCSV.getUnit()), costcoCSV.getPrice());
            vendorIngredientPriceList.add(vendorIngredientPrice);
        }
        return vendorIngredientPriceList;
    }
}







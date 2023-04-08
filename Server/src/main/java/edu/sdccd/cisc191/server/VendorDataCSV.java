package edu.sdccd.cisc191.server;

//import com.opencsv.CSVReader;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.CsvToBeanBuilder;
import edu.sdccd.cisc191.common.entities.Vendor;

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
            VendorIngredientPrices vendorIngredientPrice = new VendorIngredientPrices(vendor, new Ingredient(costcoCSV.getIngredientName(), costcoCSV.getUnit(), costcoCSV.getQuantity()), costcoCSV.getPrice());
            vendorIngredientPriceList.add(vendorIngredientPrice);
        }
        return vendorIngredientPriceList;
    }
}



//        BufferedReader reader;
//
//    {
//        try {
//            reader = new BufferedReader(new FileReader("VendorData.CSV"));
//            Scanner scanner = new Scanner(reader);
//            String nextLine = scanner.nextLine();
//
//            //split the file into parts
//            String[] vendorIngredientPrice = nextLine.split(",");
//
//            //get the component of our vendor data
//            String strVendor = vendorIngredientPrice[1];
//            String strIngredientName = vendorIngredientPrice[2];
//            String strIngredientUnit = vendorIngredientPrice[3];
//            String strIngredientQuantity = vendorIngredientPrice[4];
//            String strCostPerUnit = vendorIngredientPrice[5];
//
//            //create a vendor data
//            VendorIngredientPrices vendorIngredientPrices = new VendorIngredientPrices();
//
//            Vendors vendor = Vendors.valueOf(strVendor);
//
//            String ingredientName = new String(strIngredientName);
//            Ingredient.Units ingredientUnit = Ingredient.Units.valueOf(strIngredientUnit);
//            double ingredientQuantity = Double.parseDouble(strIngredientQuantity);
//            Ingredient ingredient = new Ingredient(ingredientName, ingredientUnit, ingredientQuantity);
//
//            double costPerUnit = Double.parseDouble(strCostPerUnit);
//
//            //set the values to the collection list
//            vendorIngredientPrices.setVendor(vendor);
//            vendorIngredientPrices.setIngredient(ingredient);
//            vendorIngredientPrices.setCostPerUnit(costPerUnit);
//
//            System.out.println("cost per unit before move: " +  vendorIngredientPrices.toString());
//            //move the vendor
//
//
//            System.out.println("Next Line: " + nextLine);
//        } catch (FileNotFoundException e) {
//            Logger.getLogger(VendorDataCSV.class.getName()).log(Level.SEVERE, null,e); //if something went wrong
//            throw new RuntimeException(e);
//        }
//    }


// Path path = Paths.get(ClassLoader.getSystemResource("VendorData.csv").toURI());
// public List<VendorIngredientPrices> readVendorData(Path filePath) throws URISyntaxException {



//        //public static void writeVendorData() {
//        Vendors costco = new Vendors("Costco");
//        VendorData costcoCSV = new VendorDataCSV(costco);
//        int count = 1;
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter("VendorData.CSV"));
//            writer.write("Index\t" + "Vendor Name\t\t" + "Item Name\t\t" + "Unit\t" + "Quantity\t" + "Note" + "\n");
//            for (VendorIngredientPrices vendorIngredientPrice : costcoCSV.importVendorIngredients()) {
//                writer.write("\t" + count + "\t" + vendorIngredientPrice.getVendor().getName() + "\t\t\t"
//                        + vendorIngredientPrice.getIngredient().getIngredientName() + "\t\t"
//                        + vendorIngredientPrice.getIngredient().getUnit() + "\t\t"
//                        + vendorIngredientPrice.getIngredient().getQuantity() + "\t\t");
//                count++;
//                writer.write("\n");
//            }
//            writer.close();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }






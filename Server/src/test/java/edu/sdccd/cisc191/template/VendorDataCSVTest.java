package edu.sdccd.cisc191.template;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.sdccd.cisc191.template.Ingredient.Ingredient;
import static org.junit.jupiter.api.Assertions.*;

class VendorDataCSVTest {

    @Test
    public void vendorDataCSVTest() {
        VendorDataCSV vendorDataCSV = new VendorDataCSV();
        //List<CostcoCSV> list = new List<>(vendorDataCSV.importVendorIngredients());

        try {
            for(CostcoCSV index: vendorDataCSV.importCostcoVendor()) {
                System.out.println(index.getIngredientName());
                System.out.println(index.getUnit());
                System.out.println(index.getPrice());
            }
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    public void importCostcoVendorTest() throws URISyntaxException, IOException
    {
        

    }


    @Test
    public void testCostcoVendorData()throws IOException, URISyntaxException {
        VendorDataCSV exportList = new VendorDataCSV();


        List<CostcoCSV> list = exportList.importCostcoVendor();

        CostcoCSV expectedData = new CostcoCSV("Eggs", Ingredient.Units.NUM, 0.99);

        boolean containsExpectedData = false;

        for (CostcoCSV item : list) {
            if (item.getIngredientName().equals(expectedData.getIngredientName())
                    && item.getUnit().equals(expectedData.getUnit())
                    && item.getPrice() == expectedData.getPrice()) {
                containsExpectedData = true;
                break;


            }
        }
        assertEquals(true, containsExpectedData);
    }
}



package edu.sdccd.cisc191.template;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

class VendorDataCSVTest {
    @Test
    public void vendorDataCSVTest() {
        VendorDataCSV vendorDataCSV = new VendorDataCSV(new Vendor("Costco"));
        try {
            for(VendorIngredientPrices index: vendorDataCSV.importVendorIngredients()) {
                System.out.println(index.getVendor().getName());
                System.out.println(index.getIngredient().getIngredientName());
                System.out.println(index.getIngredient().getQuantity());
                System.out.println(index.getIngredient().getUnit());
                System.out.println(index.getCostPerUnit());
            }
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
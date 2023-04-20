package edu.sdccd.cisc191.template;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public interface VendorData {
    public List<CostcoCSV> importCostcoVendor() throws URISyntaxException, IOException;
    public List<WalmartCSV> importWalmartVendor() throws URISyntaxException, IOException;
}

package edu.sdccd.cisc191.template;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public interface VendorData {
    List<VendorDataCSV> importVendorData() throws URISyntaxException, IOException;
    void exportVendorData(VendorDataCSV VendorDataCSV) throws URISyntaxException, IOException;
}

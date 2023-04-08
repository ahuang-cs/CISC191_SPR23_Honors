package edu.sdccd.cisc191.server.repositories;

import edu.sdccd.cisc191.common.entities.Vendor;
import org.springframework.data.repository.CrudRepository;

public interface VendorRepository extends CrudRepository<Vendor, String> {
}

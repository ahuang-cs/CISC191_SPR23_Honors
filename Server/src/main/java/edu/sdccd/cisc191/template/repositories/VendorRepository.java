package edu.sdccd.cisc191.template.repositories;

import edu.sdccd.cisc191.template.entities.Vendor;
import org.springframework.data.repository.CrudRepository;

public interface VendorRepository extends CrudRepository<Vendor, String> {
}

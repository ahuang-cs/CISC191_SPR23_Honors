package edu.sdccd.cisc191.template.MenuItem;

import edu.sdccd.cisc191.template.MenuItem.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
}

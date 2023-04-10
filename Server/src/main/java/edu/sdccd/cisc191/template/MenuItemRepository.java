package edu.sdccd.cisc191.template;

import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.*;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
}

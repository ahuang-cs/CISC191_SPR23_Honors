package edu.sdccd.cisc191.template.MenuItem;

public class MenuItemNotFoundException extends RuntimeException {
    MenuItemNotFoundException(Long id) {
        super("Could not find employee " + id);
    }
}

package edu.sdccd.cisc191.template.MenuItem;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MenuItemController {
    private final MenuItemRepository repository;
    MenuItemController(MenuItemRepository repository) {
        this.repository = repository;
    }
    @GetMapping("/MenuItems")
    List<MenuItem> all() {
        return repository.findAll();
    }
    @PostMapping("/MenuItems")
    MenuItem newEmployee(@RequestBody MenuItem newMenuItem) {
        return repository.save(newMenuItem);
    }
    @GetMapping("/MenuItems/{id}")
    MenuItem one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new MenuItemNotFoundException(id));
    }
}

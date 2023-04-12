package edu.sdccd.cisc191.template.Ingredient;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IngredientController {
    private final IngredientRepository repository;
    IngredientController(IngredientRepository repository){this.repository = repository;}
    @GetMapping("/Ingredients")
    List<Ingredient> all() {
        return repository.findAll();
    }
    @PostMapping("/Ingredients")
    Ingredient newIngredient(@RequestBody Ingredient newIngredient) {
        return repository.save(newIngredient);
    }
    @GetMapping("/Ingredients/{id}")
    Ingredient one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IngredientNotFoundException(id));
    }
    @GetMapping("/deleteIngredients")
    List<Ingredient> delete() {
        repository.deleteAll();
        return repository.findAll();
    }

}

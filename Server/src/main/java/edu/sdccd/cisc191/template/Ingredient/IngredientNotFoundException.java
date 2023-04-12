package edu.sdccd.cisc191.template.Ingredient;

public class IngredientNotFoundException extends RuntimeException {
    IngredientNotFoundException(Long id) {
        super("Could not find ingredient " + id);
    }
}

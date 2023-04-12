package edu.sdccd.cisc191.template;

import edu.sdccd.cisc191.template.Ingredient.Ingredient;
import edu.sdccd.cisc191.template.Ingredient.IngredientRepository;
import edu.sdccd.cisc191.template.MenuItem.MenuItem;
import edu.sdccd.cisc191.template.MenuItem.MenuItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringServer {
    public static void main(String[] args){
        SpringApplication.run(SpringServer.class, args);
    }
    @Bean
    CommandLineRunner initDatabase(IngredientRepository repository) {
        return args -> {
            List<Ingredient> ingredientList= new ArrayList<>();
            ingredientList.add(new Ingredient("Coffee Beans", Ingredient.Units.LB));
            ingredientList.add(new Ingredient("Creamer", Ingredient.Units.OZ));
            ingredientList.add(new Ingredient("Sugar", Ingredient.Units.LB));
            ingredientList.add(new Ingredient("Flour", Ingredient.Units.LB));
            ingredientList.add(new Ingredient("Butter", Ingredient.Units.LB));
            for(int i=0;i<ingredientList.size();i++) {
                Ingredient ingredientToAdd = ingredientList.get(i);
                ingredientToAdd.setId(new Long(i));
                repository.save(ingredientToAdd);
            }
        };
    }
}

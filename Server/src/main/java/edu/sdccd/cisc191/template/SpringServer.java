package edu.sdccd.cisc191.template;

import edu.sdccd.cisc191.template.MenuItem.MenuItem;
import edu.sdccd.cisc191.template.MenuItem.MenuItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringServer {
    public static void main(String[] args){
        SpringApplication.run(SpringServer.class, args);
    }
    @Bean
    CommandLineRunner initDatabase(MenuItemRepository repository) {
        return args -> {

        };
    }
}

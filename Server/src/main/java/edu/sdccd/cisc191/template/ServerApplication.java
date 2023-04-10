package edu.sdccd.cisc191.template;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ServerApplication {
    public static void main(String[] args){
        SpringApplication.run(ServerApplication.class, args);
    }
    @Bean
    CommandLineRunner initDatabase(MenuItemRepository repository) {
        repository.save(new MenuItem("Coffee", 10.0));
        repository.save(new MenuItem("Bagel", 5.0));

    }
}

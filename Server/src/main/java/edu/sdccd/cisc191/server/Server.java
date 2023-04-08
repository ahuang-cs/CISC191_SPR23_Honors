package edu.sdccd.cisc191.server;

import edu.sdccd.cisc191.common.entities.Vendor;
import edu.sdccd.cisc191.server.repositories.VendorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Server {

    public static void main(String[] args) {
        SpringApplication.run(Server.class, args);
    }

    @Bean
    public CommandLineRunner demo(VendorRepository repository) {
        return (args) -> {
            // save a few customers
            repository.save(new Vendor("Costco"));
            repository.save(new Vendor("Vons"));
        };
    }
}

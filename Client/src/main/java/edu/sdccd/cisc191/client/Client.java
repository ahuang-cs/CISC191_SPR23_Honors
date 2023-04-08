package edu.sdccd.cisc191.client;

import edu.sdccd.cisc191.common.entities.Vendor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Client {

    public static void main(String[] args) {
        SpringApplication.run(Client.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {
            Vendor[] vendors = restTemplate.getForObject(
                    "http://localhost:8080/vendors", Vendor[].class);

            for(Vendor vendor: vendors) {
                System.out.println(vendor.getName());
            }
        };
    }
}
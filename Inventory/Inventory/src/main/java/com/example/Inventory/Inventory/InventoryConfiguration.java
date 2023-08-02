package com.example.Inventory.Inventory;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InventoryConfiguration {

    @Bean
    CommandLineRunner commandLineRunner(InventoryRepository repository) {
        return args -> {
        };
    }
}

package net.achchamakmaki.inventoryservice;

import net.achchamakmaki.inventoryservice.entities.Product;
import net.achchamakmaki.inventoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository){
        return args ->{
            productRepository.save(Product.builder().id("tt1").name("phone").price(2900).quantity(12)
                    .build());
            productRepository.save(Product.builder().id("tt2").name("phone").price(2900).quantity(12)
                .build());
            productRepository.save(Product.builder().id("tt3").name("phone").price(2900).quantity(12)
                .build());
        };


    }

}

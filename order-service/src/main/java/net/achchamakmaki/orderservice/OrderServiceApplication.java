package net.achchamakmaki.orderservice;

import net.achchamakmaki.orderservice.entities.Order;
import net.achchamakmaki.orderservice.entities.OrderState;
import net.achchamakmaki.orderservice.entities.ProductItem;
import net.achchamakmaki.orderservice.model.Product;
import net.achchamakmaki.orderservice.repositories.OrderRepository;
import net.achchamakmaki.orderservice.repositories.ProductItemRepository;
import net.achchamakmaki.orderservice.restClients.InventoryRestClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class OrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner commandLineRunner(
            OrderRepository orderRepository,
            ProductItemRepository productItemRepository,
            InventoryRestClient inventoryRestClient
            ){
        return args -> {
            //List<Product> allProduct = inventoryRestClient.getAllProduct();
            List<String> productsIds = List.of("tt1","tt2","tt3");
            for (int i = 0; i < 5; i++) {
                Order order = Order.builder()
                        .id(UUID.randomUUID().toString())
                        .date(LocalDate.now())
                        .state(OrderState.PENDING)
                        .build();
                Order save = orderRepository.save(order);
                productsIds.forEach(pId -> {
                    ProductItem productItem = ProductItem.builder()
                            .productId(pId)
                            .quantity(new Random().nextInt(20))
                            .price(Math.random()*6000+120)
                            .order(save)
                            .build();

                    productItemRepository.save(productItem);
                });
            }

        };
    }

}

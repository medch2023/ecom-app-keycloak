package net.achchamakmaki.inventoryservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@AllArgsConstructor @NoArgsConstructor @ToString @Builder @Getter @Setter @Data
public class Product {
    @Id
    private String id;
    private String name;
    private double price;
    private int quantity;
}

package net.achchamakmaki.inventoryservice.repository;

import net.achchamakmaki.inventoryservice.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}

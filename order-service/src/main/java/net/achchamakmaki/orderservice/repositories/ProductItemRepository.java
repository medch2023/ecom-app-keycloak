package net.achchamakmaki.orderservice.repositories;

import net.achchamakmaki.orderservice.entities.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductItemRepository extends JpaRepository<ProductItem, Long> {
}

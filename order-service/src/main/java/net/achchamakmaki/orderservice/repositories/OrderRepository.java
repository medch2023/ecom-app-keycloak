package net.achchamakmaki.orderservice.repositories;

import net.achchamakmaki.orderservice.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String> {
}

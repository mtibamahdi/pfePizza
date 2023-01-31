package tn.inteldev.costumerservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.inteldev.costumerservice.entites.OrderLine;

public interface OrderLineRepository extends JpaRepository<OrderLine, Long> {
}
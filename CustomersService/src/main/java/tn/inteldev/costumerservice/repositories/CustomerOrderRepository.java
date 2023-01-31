package tn.inteldev.costumerservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.inteldev.costumerservice.entites.CustomerOrder;

public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Long> {
}
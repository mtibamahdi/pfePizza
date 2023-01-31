package tn.inteldev.costumerservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.inteldev.costumerservice.entites.Pizza;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {
}
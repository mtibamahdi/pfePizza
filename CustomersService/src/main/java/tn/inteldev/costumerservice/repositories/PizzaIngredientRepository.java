package tn.inteldev.costumerservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.inteldev.costumerservice.entites.PizzaIngredient;

public interface PizzaIngredientRepository extends JpaRepository<PizzaIngredient, Long> {
}
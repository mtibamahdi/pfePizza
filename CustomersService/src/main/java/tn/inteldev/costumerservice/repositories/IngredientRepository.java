package tn.inteldev.costumerservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.inteldev.costumerservice.entites.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
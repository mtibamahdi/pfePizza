package tn.inteldev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.inteldev.entites.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
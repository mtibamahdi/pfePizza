package tn.inteldev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.inteldev.entites.ExtraIngredient;

public interface ExtraIngredientRepository extends JpaRepository<ExtraIngredient, Long> {
}
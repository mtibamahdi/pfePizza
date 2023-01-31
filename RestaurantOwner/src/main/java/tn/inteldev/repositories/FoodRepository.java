package tn.inteldev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.inteldev.entites.Food;

public interface FoodRepository extends JpaRepository<Food, Long> {
}
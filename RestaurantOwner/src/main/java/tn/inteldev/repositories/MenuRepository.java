package tn.inteldev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.inteldev.entites.Menu;

public interface MenuRepository extends JpaRepository<Menu, Long> {
}
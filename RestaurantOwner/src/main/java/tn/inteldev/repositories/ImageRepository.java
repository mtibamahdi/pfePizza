package tn.inteldev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.inteldev.entites.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
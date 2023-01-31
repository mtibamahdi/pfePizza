package tn.inteldev.costumerservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.inteldev.costumerservice.entites.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
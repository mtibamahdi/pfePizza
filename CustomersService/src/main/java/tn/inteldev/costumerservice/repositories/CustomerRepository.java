package tn.inteldev.costumerservice.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import tn.inteldev.costumerservice.entites.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}

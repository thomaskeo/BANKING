package fr.iut.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.iut.banking.entities.Customer;

/**
 *
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}

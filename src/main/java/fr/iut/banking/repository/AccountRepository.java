package fr.iut.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.iut.banking.entities.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{
}
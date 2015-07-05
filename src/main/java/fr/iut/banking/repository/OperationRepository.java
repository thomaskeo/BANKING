package fr.iut.banking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.iut.banking.entities.Account;
import fr.iut.banking.entities.Operation;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Long>{
	
	List<Operation> findByAccount(Account acc);
}
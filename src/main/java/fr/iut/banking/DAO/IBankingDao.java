package fr.iut.banking.DAO;

import java.util.List;

import fr.iut.banking.entities.Account;
import fr.iut.banking.entities.Customer;
import fr.iut.banking.entities.Operation;

public interface IBankingDao {
	
	public Customer addClient(Customer c);


	public void addEmployeToGroupe(Long codeEmp, Long codeGr);
	public Account addCompte(Account cp, Long codeCli, Long codeEmp);
	public Operation addOperation(Operation op, String codeCpte, Long codeEmp);
	
	public Account consulterCompte(String codeCpte);
	public List<Operation> consulterOperations(String codeCpte);
	public Customer consulterClient(Long codeCli);
	public List<Customer> consulterClients(String mc);
	public List<Account> getComptesByClient(Long codeCli);
	public List<Account> getComptesByEmploye(Long codeEmp);
	

}

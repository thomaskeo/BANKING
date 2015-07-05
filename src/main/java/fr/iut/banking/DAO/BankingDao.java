package fr.iut.banking.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.ComponentScan;

import fr.iut.banking.entities.Account;
import fr.iut.banking.entities.Customer;
import fr.iut.banking.entities.Operation;
@ComponentScan
public class BankingDao {
    
    //Spécifier l'annotation @PersistenceContext, JPA configuré avec Spring
	@PersistenceContext
	//Pour gérer la persistence
	private EntityManager em;

	public Customer addCustomer(Customer customer) {
		em.persist(customer);
		return customer;
	}

	public Account addAccount(Account account, Long codeCustomer) {
		//Connaissance du client donc on va le rechercher
		Customer customer=em.find(Customer.class, codeCustomer);
		//Associer le client au compte
		account.setCustomer(customer);
		em.persist(account);
		return account;
	}

	public Operation addOperation(Operation operation, String codeAccount) {
		//Utilisation de la méthode consultAccount car c'est la même que find
		Account account=consultAccount(codeAccount);
		operation.setAccount(account);
		return operation;
	}

	public Account consultAccount(String codeAccount) {
		//Connaissance du compte donc on va le rechercher
		Account account=em.find(Account.class, codeAccount);
		//Si il n'y a pas de compte donc compte inexistant
		if(account==null) throw new RuntimeException("Account" +codeAccount+ "not found");
		return account;
	}

	public List<Operation> consultOperations(String codeAccount, int position, int numberOperation) {
		//Utilisation d'une requête JPA lorsqu'on utilise une liste, on va rechercher les opérations dont je connais le code du compte
		Query requete=em.createQuery("select operation from Operation where Operation.account.codeAccount=:x order by operation.dateOperation desc");
		requete.setParameter("x", codeAccount);
		//Récupérer la requête à partir de quelle position
		requete.setFirstResult(position);
		requete.setMaxResults(numberOperation);
		return requete.getResultList();
	}

	public Customer consultCustomer(Long codeCustomer) {
		//Connaissance du client donc on va le rechercher
		Customer customer=em.find(Customer.class, codeCustomer);
		//Si il n'y a pas de client donc client inexistant
		if(customer==null) throw new RuntimeException("Customer not found");
		return customer;
	}

	public List<Customer> consultCustomers(String nameCustomer) {
		//Utilisation d'une requête JPA lorsqu'on utilise une liste, on va rechercher les clients dont je connais une partie du nom du client
			Query req = em.createQuery("select c from Client c where c.nomClient like :x");
		req.setParameter("x", "%"+nameCustomer+"%");
		return req.getResultList();
	}

	public List<Account> getAccount(Long codeCustomer) {
		//Utilisation d'une requête JPA lorsqu'on utilise une liste, on va rechercher les comptes dont je connais le code du client
		Query req = em.createQuery("select cp from Compte cp where cp.client.CodeClient=:x");
		req.setParameter("x", codeCustomer);
		return req.getResultList();
	}
	
	public long getNumberOperation(String numberAccout){
		Query requete=em.createQuery("select count(operation) from Operation where operation.account.codeAccount=:x");
		requete.setParameter("X", numberAccout);
		return (Long) requete.getResultList().get(0);
	}
    
	
	

}

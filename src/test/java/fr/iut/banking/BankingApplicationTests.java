package fr.iut.banking;

import static org.junit.Assert.fail;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.iut.banking.BankingApplication;
import fr.iut.banking.DAO.BankingDao;
import fr.iut.banking.entities.Account;
import fr.iut.banking.entities.Customer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class BankingApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	private BankingDao bankingDao;
	
	@Test
	public void testAddClient() {
		
		Customer customer = new Customer();
		List<Account> account = null;
		customer.setAccount(account);
		String addressCustomer = "9 rue des champs";
		customer.setAddressCustomer(addressCustomer);
		Long codeCustomer = (long) 72;
		customer.setCodeCustomer(codeCustomer);
		String nameCustomer = "Clément";
		customer.setNameCustomer(nameCustomer);
		bankingDao.addCustomer(customer);
		
		Long id = customer.getCodeCustomer();
		Assert.assertNotNull(id);
		
		Customer newCustomer = bankingDao.consultCustomer(id);
		
		Assert.assertEquals("9 rue des champs", newCustomer.getAddressCustomer());
		Assert.assertEquals("Clémment" , newCustomer.getNameCustomer());
		
		
	}

	@Test
	public void testAddEmployeToGroupe() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddCompte() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddOperation() {
		fail("Not yet implemented");
	}

	@Test
	public void testConsulterCompte() {
		fail("Not yet implemented");
	}

	@Test
	public void testConsulterOperations() {
		fail("Not yet implemented");
	}

	@Test
	public void testConsulterClient() {
		fail("Not yet implemented");
	}

	@Test
	public void testConsulterClients() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetComptesByClient() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetComptesByEmploye() {
		fail("Not yet implemented");
	}

}

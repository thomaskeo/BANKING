package fr.iut.banking.services;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.iut.banking.dto.AccountDTO;
import fr.iut.banking.dto.AccountDetailedDTO;
import fr.iut.banking.dto.CustomerDTO;
import fr.iut.banking.dto.OperationDTO;
import fr.iut.banking.entities.Account;
import fr.iut.banking.entities.Customer;
import fr.iut.banking.entities.Operation;
import fr.iut.banking.repository.AccountRepository;
import fr.iut.banking.repository.CustomerRepository;
import fr.iut.banking.repository.OperationRepository;

@Service
@Transactional
public class AccountService {
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private OperationRepository operationRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired BankingDTOMapper mapper;
	
	 @Inject
	    public AccountService(final AccountRepository accountRepository) {
	        this.accountRepository = accountRepository;
	    }

	public AccountDTO postAccount(long customerId, String name, String type) {
		
	
		Customer customer = customerRepository.getOne(customerId);
		
		if(customer == null){
			 throw new IllegalArgumentException("Error customer wrong id!");
		}
		
		Account account  = new Account(name, type, customer);
		
		accountRepository.save(account);
		customerRepository.save(customer);
		
		AccountDTO accountDTO = mapper.map(account, AccountDTO.class);
		
		return accountDTO;
		
	}

	public Iterable<Account> getAllAccounts() {
		return accountRepository.findAll();
	}

	public AccountDTO getAccountById(Long id) {
		Account tmpres = accountRepository.findOne(id);
		return mapper.map(tmpres, AccountDTO.class);
	}

	
	public AccountDetailedDTO getAccountDetailedById(Long id) {
		Account tmpres = accountRepository.findOne(id);
		AccountDetailedDTO res = mapper.map(tmpres, AccountDetailedDTO.class);
		
		List<Operation> ops = operationRepository.findByAccount(tmpres);
		res.setOperations(mapper.mapAsList(ops, OperationDTO.class));
		return res;
	}

}

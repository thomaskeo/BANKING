/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.iut.banking.services;

import fr.iut.banking.dto.AccountDetailedDTO;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.iut.banking.dto.CustomerDTO;
import fr.iut.banking.dto.OperationDTO;
import fr.iut.banking.entities.Account;
import fr.iut.banking.entities.Customer;
import fr.iut.banking.entities.Operation;
import fr.iut.banking.repository.AccountRepository;
import fr.iut.banking.repository.CustomerRepository;
import fr.iut.banking.repository.OperationRepository;
import java.util.List;

/**
 *
 * @author asus
 */
@Service
@Transactional
public class CustomerService {
	@Autowired BankingDTOMapper mapper;
        
	private CustomerRepository customerRepository;
        private AccountRepository accountRepository;
        @Autowired
	private OperationRepository operationRepository;
	
	 @Inject
	    public CustomerService(final CustomerRepository customerRepository) {
	        this.customerRepository = customerRepository;
	    }

	public Customer postCustomer( Customer customer) {
		return customerRepository.save(customer);
	}

	public Iterable<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	public CustomerDTO getCustomerById(Long id) {
		Customer tmpres = customerRepository.findOne(id);
		return mapper.map(tmpres, CustomerDTO.class);
	}
        
        

	

}

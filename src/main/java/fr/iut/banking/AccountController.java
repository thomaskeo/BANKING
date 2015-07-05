package fr.iut.banking;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.iut.banking.dto.AccountDTO;
import fr.iut.banking.dto.OperationDTO;
import fr.iut.banking.services.AccountService;
import fr.iut.banking.services.CustomerService;
import fr.iut.banking.services.OperationService;


@RestController
public class AccountController {

	private final static Logger LOGGER = Logger.getLogger(AccountController.class.getName());
	 @Autowired
	 private AccountService accountService;
	 @Autowired
	 private CustomerService customerService;
	 @Autowired
	 private OperationService operationService;
	 
	 @RequestMapping("/api/account")
	    public String index() {
	        return "Greetings from Spring Boot!";
	    }
	 @RequestMapping(value = "/api/account/{accountId}/{customerId}", method = RequestMethod.GET, produces = "application/json")
	 public AccountDTO getAccount(@PathVariable(value = "accountId") Long accountId, @PathVariable(value = "customerId") Long customerId, @RequestParam(value = "details", required = false) boolean details) {
		
		 AccountDTO acc = null;
		
		 if(details){
			  acc = accountService.getAccountDetailedById(accountId);

		 }else{
			  acc = accountService.getAccountById(accountId);

		 }
		  

		 if (acc != null) {
	            LOGGER.info("getting the account with id : "+accountId+" with custmer id is " + customerId);
	            
	        }
	      
		 
		 if(acc.getCustomer().getCodeCustomer() != customerId){
			 throw new IllegalArgumentException("Error customer wrong id!");
		 }
	     
	      return acc;
	      
	 }
	 
	 
	 @RequestMapping(value = "/api/account/{customerId}", method = RequestMethod.POST, produces = "application/json")
	 public AccountDTO postAccount( @PathVariable(value = "customerId") Long customerId, @RequestParam(value = "name", required = true) String name,
			 @RequestParam(value = "type", required = true) int type) {
		 
		 String typeString = "";
		 
		 if(type == 1){
			 typeString = "CURRENT";
		 }else if(type == 2){
			 typeString = "SAVINGS";
		 }
		 
		AccountDTO acc = accountService.postAccount(customerId, name, typeString);
		
		if(acc == null){
			 throw new IllegalArgumentException("Error this account does not exist!");
		}
		
		return acc;
	 }
	 
	 
	 @RequestMapping(value = "/api/account/balance/{customerId}", method = RequestMethod.PUT, produces = "application/json")
	 public AccountDTO putAccount(@PathVariable(value = "customerId") Long customerId, @RequestParam(value = "accountId", required = true) Long accountId, @RequestParam(value = "amount", required = true) double amount,
			 @RequestParam(value = "type", required = true) int type, @RequestParam(value = "transferAccountId", required = false) Long transferAccountId) {
		 
		 String typeString = "";
		 
		 if(type == 1){
			 typeString = "DEPOSIT";
			 transferAccountId = null;
		 }else if(type == 2){
			 typeString = "WITHDRAW";
			 transferAccountId = null;
		 }else if(type == 3){
			 typeString = "TRANSFER";
		 }
		 
		 if(("TRANSFER").equals(typeString) && transferAccountId == null){
			 throw new IllegalArgumentException("Transfered account identifier is required!");
		 }
	
		
	
		operationService.postOperation(accountId, typeString, amount, transferAccountId);

		return  accountService.getAccountDetailedById(accountId);

		
	 }
	 
	 
	 
}

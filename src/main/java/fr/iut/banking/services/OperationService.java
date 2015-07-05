/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.iut.banking.services;

import fr.iut.banking.dto.OperationDTO;
import fr.iut.banking.entities.Account;
import fr.iut.banking.entities.Operation;
import fr.iut.banking.repository.AccountRepository;
import fr.iut.banking.repository.OperationRepository;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class OperationService {
    
	@Autowired
	private OperationRepository operationRepository;
	@Autowired
	private AccountRepository accountRepository;

	@Autowired BankingDTOMapper mapper;
    
    @Inject
	    public OperationService(final OperationRepository operationRepository) {
	        this.operationRepository = operationRepository;
	    }
            
            public OperationDTO postOperation(long accountId, String type, double amount, Long transferAccountId) {
            	
            	Account account = accountRepository.getOne(accountId);
        		
        		if(account == null){
        			 throw new IllegalArgumentException("Error account wrong id!");
        		}
        		
        		accountRepository.save(account);

        		Operation operation  = new Operation();
        		
        		double balance = 0;
        		
        		 switch (type) {
                 case "DEPOSIT":
                	 balance = account.getBalance() + amount;
         			
         			if(("CURRENT").equals(account.getType()) && balance > 25000){
         				
            			 throw new IllegalArgumentException("Error the defined limit has been exceeded");

         			}else if(("SAVINGS").equals(account.getType()) && balance > 85000){
         				
           			 throw new IllegalArgumentException("Error the defined limit has been exceeded");
         			}
         			account.setBalance(balance);
         		
         			operation.setOperationType(type);
         			operation.setAccount(account);
         			operation.setAmount(amount);
                	 
                          break;
                          
                 case "WITHDRAW":
                	 balance = account.getBalance() - amount;
                	 
                	 if(("SAVINGS").equals(account.getType())){
                		 throw new IllegalArgumentException("Error you can not withdraw a savings account!");

                	 }
         			
         			if(balance < -1000){
         				
            			 throw new IllegalArgumentException("Error the overdraft has been exceeded");

         			}
         			account.setBalance(balance);
         		
         			operation.setOperationType(type);
         			operation.setAccount(account);
         			operation.setAmount(amount);
                	 
                          break;
                          
                 case "TRANSFER":
                	 if(transferAccountId == 0){
            			 throw new IllegalArgumentException("Error the transfer account identifier is required!");
                	 }
                	 
                	 Account transferAccount =  accountRepository.getOne(transferAccountId);
                	 
        			if(transferAccount == null){
               			 throw new IllegalArgumentException("Error account wrong id!");
               		}
                	accountRepository.save(transferAccount);
        			
        			double withDrawBalance = account.getBalance() - amount;
        			double depositBalance = transferAccount.getBalance() + amount;
        			
        			if(("SAVINGS").equals(account.getType()) || ("SAVINGS").equals(transferAccount.getType())){
               		 throw new IllegalArgumentException("Error you can not transfer money with a savings account!");

        			}
        			
        			
        			if(depositBalance > 25000){
         				
           			 throw new IllegalArgumentException("Error transfer: the defined limit has been exceeded");

        			}
        			
        			
         			if(withDrawBalance < -1000){
         				
           			 throw new IllegalArgumentException("Error transfer: the overdraft has been exceeded");

        			}
         			
         			account.setBalance(withDrawBalance);
         			transferAccount.setBalance(depositBalance);
             		double transferorAmount = -amount;
             		
         			operation.setOperationType(type);
         			operation.setAccount(account);
         			operation.setAmount(transferorAmount);
         			
         			Operation transferOperation = new Operation(type, amount, transferAccount);
         			operationRepository.save(transferOperation);

                	 break;
                          
                 default: 
        			 throw new IllegalArgumentException("The type of operation is unkown!");
        		 }
        		        		
        		 
          		operationRepository.save(operation);

        		
        		OperationDTO operationDTO = mapper.map(operation, OperationDTO.class);
        		
        		return operationDTO;
                
	}
            
    public Iterable<Operation> getAllOperations(){
        return operationRepository.findAll();
    }
        
    public OperationDTO getOperationByAccountId(Account acc) {
    	
	List<Operation> tmpres = operationRepository.findByAccount(acc);
	
	return mapper.map(tmpres, OperationDTO.class);
	
    }
        
    
    
}

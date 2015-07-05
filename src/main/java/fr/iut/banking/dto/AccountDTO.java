package fr.iut.banking.dto;

import java.io.Serializable;
import java.util.Date;



public class AccountDTO implements Serializable{

	private Long accountId;
	
	private String name;
	
	private Date dateCreation;
	
	private double balance;
	
	private String type;
	
	private CustomerDTO customer;


	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public CustomerDTO getCustomer() {
		return customer;
	}

        public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}
	
	
	
}

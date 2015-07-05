package fr.iut.banking.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;





@Entity
@Table(name="ACCOUNT")
public class Account {
	
	@Id
	@GeneratedValue
	private Long accountId;
	
	private String name;
	
	private String type;
	
	private Date dateCreation;
	
	private double balance;
		
	@OneToOne()
	private Customer customer;
	
	
	 @OneToMany(targetEntity=Operation.class ,mappedBy="account",fetch=FetchType.LAZY)
	private List<Operation> operations = new ArrayList<Operation>();


	public Long getAccountId() {
		return accountId;
	}
	public void setCodeAccount(Long accountId) {
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
	public double setBalance(double balance) {
		return this.balance = balance;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	public Account(String name, String type, Customer customer) {
		super();
		this.type = type;
		this.name = name;
		this.dateCreation = new Date();
		this.balance = 0;
		this.customer = customer;
	}
	
	public Account() {
	}	
	
	

}

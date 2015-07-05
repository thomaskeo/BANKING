package fr.iut.banking.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="OPERATION")
public class Operation {
	
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long numberOperation;
	 
	private String operationType;
	
	private Date dateOperation;
	 
	private double amount;
	 
	@ManyToOne()
	private Account account;
	
	public Long getNumberOperation() {
		return numberOperation;
	}
	public void setNumberOperation(Long numberOperation) {
		this.numberOperation = numberOperation;
	}
	public Date getDateOperation() {
		return dateOperation;
	}
	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	
	public Operation(String type, double amount, Account account) {
		
		this.operationType = type;
		this.amount = amount;
		this.dateOperation = new Date();
		this.account = account;
	}
	
	public Operation() {
		this.dateOperation = new Date();

	}
	
	public String getOperationType() {
		return operationType;
	}
	public void setOperationType(String type) {
		this.operationType = type;
	}
	
	
}
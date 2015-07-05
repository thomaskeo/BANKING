package fr.iut.banking.dto;

import java.io.Serializable;
import java.util.Date;



public class OperationDTO implements Serializable{

	private Long numberOperation;
	 
	private String operationType;
	
	private Date dateOperation;
	 
	private double amount;
	
	private AccountDTO account;

	public Long getNumberOperation() {
		return numberOperation;
	}

	public void setNumberOperation(Long numberOperation) {
		this.numberOperation = numberOperation;
	}

	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String type) {
		this.operationType = type;
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

	public AccountDTO getAccount() {
		return account;
	}

	public void setAccount(AccountDTO account) {
		this.account = account;
	}
	
	
	
}

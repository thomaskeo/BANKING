package fr.iut.banking.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.iut.banking.entities.Account;

public class CustomerDTO implements Serializable {
	

	private Long codeCustomer;
	
	private String nameCustomer;
	
	private String addressCustomer;
	


	public Long getCodeCustomer() {
		return codeCustomer;
	}

	public void setCodeCustomer(Long codeCustomer) {
		this.codeCustomer = codeCustomer;
	}

	public String getNameCustomer() {
		return nameCustomer;
	}

	public void setNameCustomer(String nameCustomer) {
		this.nameCustomer = nameCustomer;
	}

	public String getAddressCustomer() {
		return addressCustomer;
	}

	public void setAddressCustomer(String addressCustomer) {
		this.addressCustomer = addressCustomer;
	}

	

	 
	 

}

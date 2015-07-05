package fr.iut.banking.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name="CUSTOMER")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="codeCustomer", scope=Customer.class)
public class Customer {
	 @Id
	 //Générer automatiquement 1+1
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codeCustomer;
	private String nameCustomer;
	private String addressCustomer;
	//Pour les collections, association bidirectionnelle, le mode LAZY = on n'effectue la jointure sql qu'à la demande
	 @OneToMany(targetEntity=Account.class ,mappedBy="customer",fetch=FetchType.LAZY)
	private List<Account> account = new ArrayList<Account>();
	 
	 
	 
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
	public Collection<Account> getAccount() {
		return account;
	}
	public void setAccount(List<Account> account) {
		this.account = account;
	}
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(String nameCustomer, String addressCustomer) {
		super();
		this.nameCustomer = nameCustomer;
		this.addressCustomer = addressCustomer;
	}
}
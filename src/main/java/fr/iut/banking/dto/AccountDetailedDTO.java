package fr.iut.banking.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class AccountDetailedDTO extends AccountDTO implements Serializable{

	private List<OperationDTO> operations;
	
	public List<OperationDTO> getOperations() {
		return operations;
	}

	public void setOperations(List<OperationDTO> operations) {
		this.operations = operations;
	}
	
	
	
}

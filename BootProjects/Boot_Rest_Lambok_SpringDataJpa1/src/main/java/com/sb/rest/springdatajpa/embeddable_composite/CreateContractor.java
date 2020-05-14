package com.sb.rest.springdatajpa.embeddable_composite;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CreateContractor")
public class CreateContractor {
    
	@EmbeddedId
	private ContractorId contractorId;
	
	private String contractorName;

	public ContractorId getContractorId() {
		return contractorId;
	}

	public void setContractorId(ContractorId contractorId) {
		this.contractorId = contractorId;
	}

	public String getContractorName() {
		return contractorName;
	}

	public void setContractorName(String contractorName) {
		this.contractorName = contractorName;
	}
	

}

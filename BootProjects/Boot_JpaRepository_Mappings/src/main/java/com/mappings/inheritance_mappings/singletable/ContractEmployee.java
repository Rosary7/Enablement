package com.mappings.inheritancemappings.singletable;

import java.time.LocalDate;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Contract")
@DiscriminatorColumn(name = "EMPLOYMENT_TYPE",discriminatorType=DiscriminatorType.STRING)
public class ContractEmployee extends Employee {
	 private LocalDate contractStartDate;
	 private LocalDate contractEndDate;
	 private String agencyName;
	 
	public LocalDate getContractStartDate() {
		return contractStartDate;
	}
	public void setContractStartDate(LocalDate contractStartDate) {
		this.contractStartDate = contractStartDate;
	}
	public LocalDate getContractEndDate() {
		return contractEndDate;
	}
	public void setContractEndDate(LocalDate contractEndDate) {
		this.contractEndDate = contractEndDate;
	}
	public String getAgencyName() {
		return agencyName;
	}
	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}
	 
	 
}

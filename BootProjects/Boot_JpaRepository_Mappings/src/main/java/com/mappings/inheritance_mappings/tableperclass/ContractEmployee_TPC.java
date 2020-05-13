package com.mappings.inheritance_mappings.tableperclass;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Contract_TPC")
public class ContractEmployee_TPC extends Employee_TPC {
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

package com.sb.rest.springdatajpa.joinedtable;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="ContractEmployee")
@DiscriminatorValue("Contract")
@PrimaryKeyJoinColumn(name="empId")
public class ContractEmployee extends Emp_JT {
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

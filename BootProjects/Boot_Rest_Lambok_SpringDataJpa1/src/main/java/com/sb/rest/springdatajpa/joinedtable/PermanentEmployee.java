package com.sb.rest.springdatajpa.joinedtable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="PermanentEmployee")
@DiscriminatorValue("Permanent")
@PrimaryKeyJoinColumn(name="empId")
public class PermanentEmployee extends Emp_JT {
 
    private String costCenter;
    private Float totalLeaves;
 
	public String getCostCenter() {
		return costCenter;
	}
	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}
	public Float getTotalLeaves() {
		return totalLeaves;
	}
	public void setTotalLeaves(Float totalLeaves) {
		this.totalLeaves = totalLeaves;
	}
    
    
}


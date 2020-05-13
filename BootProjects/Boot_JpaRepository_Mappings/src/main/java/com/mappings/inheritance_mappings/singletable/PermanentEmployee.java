package com.mappings.inheritancemappings.singletable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Permanent")
@DiscriminatorColumn(name = "EMPLOYMENT_TYPE",discriminatorType=DiscriminatorType.STRING)
public class PermanentEmployee extends Employee {
 
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


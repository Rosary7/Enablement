package com.mappings.inheritance_mappings.tableperclass;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Permanent_TPC")
public class PermanentEmployee_TPC extends Employee_TPC {
 
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


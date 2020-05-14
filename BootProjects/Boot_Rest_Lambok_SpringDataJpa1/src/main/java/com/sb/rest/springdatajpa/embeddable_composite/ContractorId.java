package com.sb.rest.springdatajpa.embeddable_composite;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ContractorId implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "empId")
    private String empId;
	
    @Column(name = "organization")
    private String organization;
    
    public ContractorId(){}
    
	public ContractorId(String empId, String organization) {
		super();
		this.empId = empId;
		this.organization = organization;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((empId == null) ? 0 : empId.hashCode());
		result = prime * result + ((organization == null) ? 0 : organization.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContractorId other = (ContractorId) obj;
		if (empId == null) {
			if (other.empId != null)
				return false;
		} else if (!empId.equals(other.empId))
			return false;
		if (organization == null) {
			if (other.organization != null)
				return false;
		} else if (!organization.equals(other.organization))
			return false;
		return true;
	}
    
	
    

}

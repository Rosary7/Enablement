package com.sb;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sb.rest.springdatajpa.embeddable_composite.ContractorId;
import com.sb.rest.springdatajpa.embeddable_composite.CreateContractor;
import com.sb.rest.springdatajpa.embeddable_composite.CreateContractorRepository;
import com.sb.rest.springdatajpa.joinedtable.ContractEmployee;
import com.sb.rest.springdatajpa.joinedtable.Emp_JTRepository;
import com.sb.rest.springdatajpa.joinedtable.PermanentEmployee;

@SpringBootApplication
public class BootRestLambokSpringDataJpa1Application implements CommandLineRunner {

	// Joined Table - inheritance mapping
	@Autowired
	private Emp_JTRepository emp_JTRepository;
	
	// Composite key - CreateContractor
	@Autowired
	private CreateContractorRepository createContractorRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(BootRestLambokSpringDataJpa1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		joinedTable_LoadTestData_And_Test();
		using_embeddedAndEmbeddedId();
	}
	
private void joinedTable_LoadTestData_And_Test(){
		
		// Clean up employee table
		emp_JTRepository.deleteAllInBatch();

		// Create Contract Employee
		ContractEmployee contractEmp = new ContractEmployee();
		contractEmp.setEmpId(2000L);
		contractEmp.setEmpName("Peter");
		contractEmp.setContractStartDate(LocalDate.parse("2020-05-10"));
		contractEmp.setContractEndDate(LocalDate.parse("2022-05-10"));
		contractEmp.setAgencyName("TimesJobs");

		// Create Permanent Employee
		PermanentEmployee permanentEmployee = new PermanentEmployee();
		permanentEmployee.setEmpId(2001L);
		permanentEmployee.setEmpName("Vinod");
		permanentEmployee.setTotalLeaves(10.5F);
		permanentEmployee.setCostCenter("TMP-12");

		emp_JTRepository.saveAll(Arrays.asList(permanentEmployee, contractEmp));
	}

	private void using_embeddedAndEmbeddedId(){
		ContractorId contractorId = new ContractorId();
		contractorId.setEmpId("12");
		contractorId.setOrganization("XYZ");
		
		CreateContractor createContractor = new CreateContractor();
		createContractor.setContractorId(contractorId);
		createContractor.setContractorName("Aru");
		
		createContractorRepository.save(createContractor);
	}

}

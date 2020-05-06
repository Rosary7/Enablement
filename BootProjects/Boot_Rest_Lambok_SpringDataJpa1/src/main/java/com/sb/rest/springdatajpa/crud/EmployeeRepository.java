package com.sb.rest.springdatajpa.crud;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	// Custom query
	@Query("select emp from Employee emp where emp.firstName = :firstName")
	List <Employee> getAllEmpByFirstName(@Param("firstName") String firstName);
	
	// Custom query
	@Query("select emp from Employee emp where emp.lastName = :lastName")
	List <Employee> getAllEmpByLastName(@Param("lastName") String lastName);
	
	// Using  'query method name' ,with 'Or' keyword
	List <Employee> findByFirstNameOrLastName(String firstName, String lastName);

}

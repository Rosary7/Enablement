package com.sb.rest.springdatajpa.crud;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmployeeService {
	@Autowired
    private EmployeeRepository employeeRepository;

	public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
      
    public List <Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
    
    public Employee getEmployeeById(Long employeeId) throws RecordNotFoundException {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        if(!employee.isPresent())
            throw new RecordNotFoundException("Could not find employee with id- " + employeeId);
 
        return employee.get();
    }
    
    public Employee getEmpById(Long employeeId) throws RecordNotFoundException  {
    	// Get the entity if exist or,if it does not exist,throw an exception
    	Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
    	Employee emp = optionalEmployee.orElseThrow(() -> new RecordNotFoundException(employeeId.toString()));
        return emp;
    }
    
    public Employee updateEmpById(Long employeeId, Employee employee) throws RecordNotFoundException  {
    	// Get the entity if exist or,if it does not exist,throw an exception
    	Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
    	Employee emp = optionalEmployee.orElseThrow(() -> new RecordNotFoundException(employeeId.toString()));

    	emp.setFirstName(employee.getFirstName());
    	emp.setLastName(employee.getFirstName());
    	emp.setEmailId(employee.getEmailId());
    	
    	return employeeRepository.save(emp);
    }
    
  public List <Employee> getAllEmpByFirstName(String firstName) {
      return employeeRepository.getAllEmpByFirstName(firstName);
  }
  
  public List <Employee> getAllEmpByLastName(String lastName)  {
	  return employeeRepository.getAllEmpByLastName(lastName);
  }
  
  public List <Employee> getByFirstNameOrLastName(String firstName,String lastName)  {
	  return employeeRepository.findByFirstNameOrLastName(firstName,lastName);
  }
  
}

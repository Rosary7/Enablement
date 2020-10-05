package learn.springrest.crud.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import learn.springrest.crud.dao.EmployeeDao;
import learn.springrest.crud.exception.RecordNotFoundException;
import learn.springrest.crud.model.Employee;
import learn.springrest.crud.repository.EmployeeRepository;

@Service
public class EmployeeService {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);
	
	@Autowired
    private EmployeeRepository employeeRepository;
	
	@Autowired
	private EmployeeDao employeeDao;
	
	// Save an employee
	@Transactional
	public Employee createEmployee(Employee employee) {
		logger.info("......Entering createEmployee()");
        return employeeRepository.save(employee);
    }
	
	// Retrieve all employees
	public List <Employee> getAllEmployees() {
		logger.info("......Entering getAllEmployees()");
        return employeeRepository.findAll();
    }
	
	// Get employee By Id
	public Employee getEmployeeById(Long employeeId) throws RecordNotFoundException {
		logger.info("......Entering getEmployeeById()");
	    Optional<Employee> employee = employeeRepository.findById(employeeId);
	    if(!employee.isPresent())
	      throw new RecordNotFoundException("Could not find employee with id- " + employeeId);
	 
	    return employee.get();
	}
	
	// Update employee By Id
	public Employee updateEmpById(Long employeeId, Employee employee) throws RecordNotFoundException  {
		logger.info("......Entering updateEmpById()");
		// Get the entity if exist or,if it does not exist,throw an exception
    	Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
    	Employee emp = optionalEmployee.orElseThrow(() -> new RecordNotFoundException(employeeId.toString()));

    	emp.setFirstName(employee.getFirstName());
    	emp.setLastName(employee.getFirstName());
    	emp.setEmailId(employee.getEmailId());
    	
    	return employeeRepository.save(emp);
    }
	
 	
 	/*************************************************************
 	     USING DAO
 	 *************************************************************/
	
	// Save an employee
	//@Transactional
	public void createEmployeeUsingDAO(Employee employee) {
		logger.info("......Entering createEmployeeUsingDAO()");
        employeeDao.save(employee);
    }
	
	// Using DAO
	// Retrieve all employees 
		public List <Employee> getAllEmployeesUsingDAO() {
			logger.info("......Entering getAllEmployeesUsingDAO()");
	        return employeeDao.getAll();
	    }
		
		
}

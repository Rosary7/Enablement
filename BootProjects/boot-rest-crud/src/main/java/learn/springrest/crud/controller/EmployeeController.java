package learn.springrest.crud.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import learn.springrest.crud.exception.RecordNotFoundException;
import learn.springrest.crud.model.Employee;
import learn.springrest.crud.service.EmployeeService;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	// http://localhost:8080/api/v1/createEmployee

	@Autowired
    private EmployeeService employeeService;
	
	// Save an employee
    @PostMapping(
    		value="/createEmployee",
    		consumes = MediaType.APPLICATION_JSON_VALUE, 
    		produces ={ MediaType.APPLICATION_JSON_VALUE})
    public Employee createEmployee(@RequestBody Employee employee) {
    	logger.info("....Entering createEmployee()");
        return employeeService.createEmployee(employee);
    }
    
    // Retrieve all employees
    @RequestMapping(
    		path = "/getAllEmployees", 
    		method=RequestMethod.GET, 
    		produces ={ MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List <Employee> getAllEmployees() {
    	logger.info("....Entering getAllEmployees()");
        return employeeService.getAllEmployees();
    }
    
    // Get employee By Id
 	@GetMapping("/getEmployeeById/{id}")
     public ResponseEntity <Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId) 
     		throws RecordNotFoundException
     {
     	logger.info("....Entering getEmployeeById()");
     	Employee emp = employeeService.getEmployeeById(employeeId);
     	return new ResponseEntity<Employee>(emp, HttpStatus.OK);
     }
    
    // Update employee By Id
 	@PutMapping("/updateEmpById/{id}")
    public ResponseEntity <Employee> updateEmpById(@PathVariable(value = "id") Long employeeId, 
    											   @RequestBody Employee employee) throws RecordNotFoundException
    {
    	logger.info("....Entering updateEmpById()");
    	Employee emp = employeeService.updateEmpById(employeeId, employee);
    	return ResponseEntity.ok().body(emp);
    }
 	
 	/*************************************************************
 	     USING DAO
 	 *************************************************************/
 	
	// Save an employee
    @PostMapping(
    		value="/createEmployeeUsingDAO",
    		consumes = MediaType.APPLICATION_JSON_VALUE, 
    		produces ={ MediaType.TEXT_PLAIN_VALUE})
    public String createEmployeeUsingDAO(@RequestBody Employee employee) {
    	logger.info("....Entering createEmployeeUsingDAO()");
         employeeService.createEmployeeUsingDAO(employee);
         return "Employee created";
    }
    
 	// Using DAO
 	@RequestMapping(
    		path = "/getAllEmployeesUsingDao", 
    		method=RequestMethod.GET, 
    		produces ={ MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List <Employee> getAllEmployeesUsingDAO() {
    	logger.info("....Entering getAllEmployeesUsingDAO()");
        return employeeService.getAllEmployeesUsingDAO();
    }
 	
}

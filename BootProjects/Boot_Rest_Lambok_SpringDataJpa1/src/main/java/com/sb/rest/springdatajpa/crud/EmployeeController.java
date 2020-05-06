package com.sb.rest.springdatajpa.crud;

import java.util.List;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
			
	@Autowired
    private EmployeeService employeeService;

    @PostMapping(
    		value="/createEmployee",
    		consumes = MediaType.APPLICATION_JSON_VALUE, 
    		produces ={ MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Employee createEmployee(@Valid @RequestBody Employee employee) {
    	logger.info("....Entering createEmployee()");
        return employeeService.createEmployee(employee);
    }
    
    @RequestMapping(
    		path = "/getAllEmployees", 
    		method=RequestMethod.GET, 
    		produces ={ MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List <Employee> getAllEmployees() {
    	logger.info("....Entering getAllEmployees()");
        return employeeService.getAllEmployees();
    }
    
    /*
     * The error msg is added to the response.
     * 
     *   {
     *   	 "timestamp": "2020-04-28T09:04:09.854+0000",
     *   	 "status": 404,
     *       "error": "Not Found",
     *       "message": "Could not find employee with id- 211",
     *       "path": "/api/v1/getEmployeeById/21"
     *  }
     */
    @GetMapping("/getEmployeeById/{id}")
    public ResponseEntity <Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId) 
    		throws RecordNotFoundException
    {
    	logger.info("....Entering getEmployeeById()");
    	Employee emp = employeeService.getEmployeeById(employeeId);
    	return new ResponseEntity<Employee>(emp, HttpStatus.OK);
    }
    
    @GetMapping("/getEmpById/{id}")
    public ResponseEntity <Employee> getEmpById(@PathVariable(value = "id") Long employeeId) 
    		throws RecordNotFoundException
    {
    	logger.info("....Entering getEmpById()");
    	Employee emp = employeeService.getEmpById(employeeId);
    	return ResponseEntity.ok().body(emp);
    }

    @PutMapping("/updateEmpById/{id}")
    public ResponseEntity <Employee> updateEmpById(@PathVariable(value = "id") Long employeeId, 
    											   @RequestBody Employee employee) throws RecordNotFoundException
    {
    	logger.info("....Entering updateEmpById()");
    	Employee emp = employeeService.updateEmpById(employeeId, employee);
    	return ResponseEntity.ok().body(emp);
    }
    
	// Custom query and @PathVariable
    @RequestMapping(path = "/getAllEmpByFirstName/{firstName}")
    public List <Employee> getAllEmpByFirstName(@PathVariable(value = "firstName") String firstName) {
    	logger.info("....Entering getAllEmpByFirstName()");
        return employeeService.getAllEmpByFirstName(firstName);
    }
    
    // Custom query and @RequestParam
    @RequestMapping(path = "/getAllEmpByLastName")
    public List <Employee> getAllEmpByLastName(@RequestParam String lastName) {
    	logger.info("....Entering getAllEmpByLastName()");
        return employeeService.getAllEmpByLastName(lastName);
    }
    
    //  Using  'query method name' ,with 'Or' keyword
    @RequestMapping(path = "/getByFirstNameOrLastName")
    public List <Employee> getByFirstNameOrLastName(String firstName,String lastName) {
    	logger.info("....Entering getAllEmpByLastName()");
        return employeeService.getByFirstNameOrLastName(firstName,lastName);
    }
}


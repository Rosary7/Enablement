package learn.springrest.crud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class HeloWorldController {
	
private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	// http://localhost:8080/api/v1/heloworld1
	@RequestMapping(path = "/heloworld1",
			produces = MediaType.TEXT_PLAIN_VALUE,
			method=RequestMethod.GET)
    public String helowWorld1() {
    	logger.info("....Entering helowWorld1()");
        return "Helo World 1";
    }
	
	 // http://localhost:8080/api/v1/heloworld2
	 @GetMapping(path = "/heloworld2",produces = MediaType.TEXT_PLAIN_VALUE)
	 public String helowWorld2() {
	   	logger.info("....Entering helowWorld2()");
	    return "Helo World 2";
	 }
	 
	// http://localhost:8080/api/v1/heloworld3
	 @RequestMapping(path = "/heloworld3")
	 public String helowWorld3() {
	   	logger.info("....Entering helowWorld3()");
	    return "Helo World 3";
	 }
		
}

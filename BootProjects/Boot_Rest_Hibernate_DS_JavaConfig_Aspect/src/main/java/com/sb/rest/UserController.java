package com.sb.rest;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
@RequestMapping("/api/v1")

/**
 *  Logging implemented using Aspect (LoggingAspectConfig.java)
 */
public class UserController {
	
	//private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
    private UserService userService;
	
    @PostMapping(
    		value="/addUser1",
    		consumes = MediaType.APPLICATION_JSON_VALUE, 
    		produces ={ MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public User addUser1(@Valid @RequestBody User user) {
    	//logger.info("....Entering addUser1()");
        return userService.addUser1(user);
    }
    
    @PostMapping(
    		value="/addUser2",
    		consumes = MediaType.APPLICATION_JSON_VALUE, 
    		produces ={ MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public User addUser2(@Valid @RequestBody User user) {
    	//logger.info("....Entering addUser2()");
        return userService.addUser2(user);
    }
    
	@RequestMapping(
	  	path = "/getAllUsers", 
	  	method=RequestMethod.GET, 
	   produces ={ MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public List <User> getAllUsers() {
	   //logger.info("....Entering getAllUsers()");
	   return userService.getAllUsers();
	}
	
 
    
}


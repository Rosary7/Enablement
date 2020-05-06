package com.sb.rest.springdatajpa.lambok;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/*
 * @Slf4j - Using 'lombok' library
 */

@Slf4j  //	'lombok' library
@RestController
@RequestMapping("/api/v1")
public class UserController {
	
	@Autowired
    private UserService userService;

    @PostMapping(
    		value="/createUser",
    		consumes = MediaType.APPLICATION_JSON_VALUE, 
    		produces ={ MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public User createUser(@Valid @RequestBody User employee) {
    	log.info("....Entering createUser()");
        return userService.createUser(employee);
    }
    
    @RequestMapping(
    		path = "/getAllUsers", 
    		method=RequestMethod.GET, 
    		produces ={ MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List <User> getAllUsers() {
    	log.info("....Entering getAllUsers()");
        return userService.getAllUsers();
    }
   
    @PutMapping("/updateUserById/{id}")
    public ResponseEntity <User> updateUserById(@PathVariable(value = "id") Long userId, 
    											   @RequestBody User user) throws RecordNotFoundException
    {
    	log.info("....Entering updateUserById()");
    	User usr = userService.updateUserById(userId, user);
    	return ResponseEntity.ok().body(usr);
    }
    
}

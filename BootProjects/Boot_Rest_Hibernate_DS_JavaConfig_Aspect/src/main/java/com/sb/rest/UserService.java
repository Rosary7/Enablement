package com.sb.rest;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
    private UserDao userDao;
	
	public User addUser1(User user) {
		logger.info("....Entering addUser1()");
        return userDao.addUser1(user);
    }
	
	public User addUser2(User user) {
		logger.info("....Entering addUser2()");
        return userDao.addUser2(user);
    }
	
    public List <User> getAllUsers() {
    	logger.info("....Entering getAllUsers()");
        return userDao.getAllUsers();
    }
    

}

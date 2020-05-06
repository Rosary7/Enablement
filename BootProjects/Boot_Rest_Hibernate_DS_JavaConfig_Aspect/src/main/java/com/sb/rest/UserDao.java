package com.sb.rest;

import java.util.List;

public interface UserDao {
	public User addUser1(User user);
	public User addUser2(User user);
	List <User> getAllUsers();
	
}



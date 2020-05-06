package com.sb.rest.springdatajpa.lambok;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
    private UserRepository userRepository;

	public User createUser(User user) {
        return userRepository.save(user);
    }
      
    public List <User> getAllUsers() {
        return userRepository.findAll();
    }
    
    public User updateUserById(Long userId, User usr) throws RecordNotFoundException  {
    	// Get the entity if exist or,if it does not exist,throw an exception
    	Optional<User> optionalUser = userRepository.findById(userId);
    	User user = optionalUser.orElseThrow(() -> new RecordNotFoundException(userId.toString()));

    	user.setFirstName(usr.getFirstName());
    	user.setLastName(usr.getFirstName());
    	user.setEmailId(usr.getEmailId());
    	
    	return userRepository.save(user);
    }
}

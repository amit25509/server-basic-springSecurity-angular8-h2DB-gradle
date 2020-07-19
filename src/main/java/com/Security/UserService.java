package com.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;
	
	public User register(User user) {
		return userRepo.save(user);
	}
	
	public User getUserByEmailId(String email) {
		return userRepo.findByEmailId(email);
	}
	
	public User getUserByEmailIdAndPassword(String email, String password) {
		return userRepo.findByEmailIdAndPassword(email, password);
	}
	
}

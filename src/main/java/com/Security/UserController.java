package com.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public User register(@RequestBody User user) throws Exception {
		String tempEmail= user.getEmailId();
		if(tempEmail != null && !"".equals(tempEmail)) {
			User userobj= userService.getUserByEmailId(tempEmail);
			if(userobj !=null) {
				throw new Exception("user with "+ tempEmail +" already exists");
			}
		}
		User userobj=null;
		return userobj=userService.register(user);
	}
	
	@PostMapping("/login")
	public User login(@RequestBody User user) throws Exception {
		String tempEmail = user.getEmailId();
		String tempPass= user.getPassword();
		User userobj=null;
		if(tempEmail != null && tempPass !=null) {
			userobj= userService.getUserByEmailIdAndPassword(tempEmail, tempPass);
		}
		if(userobj == null) {
			throw new Exception("bad credentials");
		}
		return userobj;
	}
}

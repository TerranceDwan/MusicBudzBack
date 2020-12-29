package com.budz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.budz.models.User;
import com.budz.service.UserService;

@RestController
@RequestMapping(path = "/user")
@CrossOrigin
public class UserController {
	
	@Autowired
	private UserService UserService;
	
	@PostMapping("/createUser")
	public void createUser(@RequestParam String email, 
							@RequestParam String password, 
							@RequestParam String username,
							@RequestParam String firstName,
							@RequestParam String lastName) 
	{
		User user = new User(email, password, username, firstName, lastName);
		UserService.createUser(user);
	}
	
	@PostMapping("/login")
	public User login(@RequestParam String usernameOrEmail, @RequestParam String password) {
		return UserService.login(usernameOrEmail, password);
	}
	
	@GetMapping("/usersByUsername")
	public List<User> userByUsername(@RequestParam String query) {
		return UserService.getUsersByUsername(query);
	}
	
	@GetMapping("/userById")
	public User userById(@RequestParam int id) {
		return UserService.getUserById(id);
	}
	
//	@GetMapping("/getFriends")
//	public List<User> getFriends(@RequestParam int id) {
//		return UserService.getFriends(id);
//	}
	
	@PatchMapping("/updateUser")
	public void updateUser(@RequestParam int id,
							@RequestParam String email, 
							@RequestParam String password, 
							@RequestParam String username,
							@RequestParam String firstName,
							@RequestParam String lastName) 
	{
		User user = new User(id,email,password,username,firstName,lastName);
		UserService.updateUser(user);
	}
	
	@DeleteMapping("/deleteAccount")
	public void deleteAccount(@RequestParam int id) {
		UserService.deleteAccount(id);
	}
}

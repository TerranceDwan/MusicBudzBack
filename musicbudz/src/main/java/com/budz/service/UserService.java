package com.budz.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.budz.models.User;
import com.budz.repository.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	public void createUser(User user) {
		if(user.getEmail().isBlank() || 
			user.getFirstName().isBlank() || 
			user.getLastName().isBlank() || 
			user.getUserName().isBlank() || 
			user.getPassword().isBlank()
		) {
			throw new IllegalArgumentException("One or More fields were blank");
		} else if(!User.emailIsValid(user.getEmail())) {
			throw new IllegalArgumentException("Invalid Email Input");
		} else if(User.emailIsValid(user.getUserName())) {
			throw new IllegalArgumentException("Username is too similar to an email address");
		} else if(user.getUserName().trim().length() < 3) {
			throw new IllegalArgumentException("Username must contain more than 3 characters");
		} else if(user.getPassword().trim().length() < 8) {
			throw new IllegalArgumentException("Passwords must contain more than 8 characters");
		} else {
			userRepo.save(user);
		}
	}
	
	public User login(String usernameOrEmail, String password) {
		if(User.emailIsValid(usernameOrEmail)) {
			return userRepo.loginEmail(usernameOrEmail, password);
		}else if (!usernameOrEmail.isBlank() && !password.isBlank()){
			return userRepo.loginUserName(usernameOrEmail, password);
		}else {
			throw new IllegalArgumentException("Both fields require input");
		}

	}
	
	public List<User> getUsersByUsername(String query) {
		if(query.length() < 3) {
			throw new IllegalArgumentException("No Usernames Exist with less than 3 characters");
		} else {
			return userRepo.getUsersByUserName(query);
		}
	}
	
	public User getUserById(int userId) {
		return userRepo.findById(userId).get();
	}
	
	public List<User> getFriends(int userId){
		return Arrays.asList(
				new User(1, "email@email.com", "password", "user1", "John", "Doe"),
				new User(2, "email", "password", "user2", "Jeff", "Doe"),
				new User(3, "email@email.com", "pass", "user3", "Jim", "Doe"),
				new User(4, "emailemail.com", "password", "us", "Jim", "Doe"),
				new User(5, "email@email.com", "abc", "user5", "", "Doe"),
				new User(6, "email@email.com", "pass", "user6", "Jim", "")
				);
	}
	
	public void updateUser(User user) {
		if(user.getEmail().isBlank() || 
			user.getFirstName().isBlank() || 
			user.getLastName().isBlank() || 
			user.getUserName().isBlank() || 
			user.getPassword().isBlank()
		) {
			throw new IllegalArgumentException("One or More fields were blank");
		} else if(!User.emailIsValid(user.getEmail())) {
			throw new IllegalArgumentException("Invalid Email Input");
		} else if(User.emailIsValid(user.getUserName())) {
			throw new IllegalArgumentException("Username is too similar to an email address");
		} else if(user.getUserName().trim().length() < 3) {
			throw new IllegalArgumentException("Username must contain more than 3 characters");
		} else if(user.getPassword().trim().length() < 8) {
			throw new IllegalArgumentException("Passwords must contain more than 8 characters");
		} else {
			userRepo.save(user);
		}
	}
	
	public void deleteAccount(int id) {
		userRepo.deleteById(id);
	}

}

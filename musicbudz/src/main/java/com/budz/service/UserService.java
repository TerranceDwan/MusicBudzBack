package com.budz.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.budz.models.User;
import com.budz.repository.RelationshipRepo;
import com.budz.repository.UserRepo;
import com.budz.utility.StringUtil;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	public void createUser(User user) {
		if(StringUtil.isBlank(user.getEmail()) || 
			StringUtil.isBlank(user.getFirstName()) || 
			StringUtil.isBlank(user.getLastName()) || 
			StringUtil.isBlank(user.getUserName()) || 
			StringUtil.isBlank(user.getPassword())
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
		}else if (!StringUtil.isBlank(usernameOrEmail) && !StringUtil.isBlank(password)){
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
	
//	public List<User> getFriends(int userId){
//		return userRepo.getFriends(userId);
//	}
	
	public void updateUser(User user) {
		if(StringUtil.isBlank(user.getEmail()) || 
				StringUtil.isBlank(user.getFirstName()) || 
				StringUtil.isBlank(user.getLastName()) || 
				StringUtil.isBlank(user.getUserName()) || 
				StringUtil.isBlank(user.getPassword())
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

package com.budz.service;

import java.util.ArrayList;

import com.budz.models.User;
import com.budz.repository.UserRepo;
import com.budz.repository.UserRepoImpl;

public class UserService {
	
	private UserRepo userRepo;
	
	public UserService() {
		this.userRepo = new UserRepoImpl();
	}
	
	public void createUser(User user) {
		userRepo.createUser(user);;
	}
	
	public User login(String usernameOrEmail, String password) {
		return new User();
	}
	
	public ArrayList<User> getUsersByUsername(String query) {
		return new ArrayList<User>();
	}
	
	public User getUserDataById(int userId) {
		return new User();
	}
	
	public ArrayList<User> getFriends(int userId){
		return new ArrayList<User>();
	}
	
	public void updateUser(User user) {
		
	}
	
	public void deleteAccount(int userId) {
		
	}

}

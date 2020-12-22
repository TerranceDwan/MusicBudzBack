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
		userRepo.save(user);
	}
	
	public User login(String usernameOrEmail, String password) {
		if(usernameOrEmail.contains("@")) {
			return userRepo.loginEmail(usernameOrEmail, password);
		}else {
			return userRepo.loginUserName(usernameOrEmail, password);
		}

	}
	
	public List<User> getUsersByUsername(String query) {
		return userRepo.getUsersByUserName(query);
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
		userRepo.save(user);
	}
	
	public void deleteAccount(int id) {
		userRepo.deleteById(id);
	}

}

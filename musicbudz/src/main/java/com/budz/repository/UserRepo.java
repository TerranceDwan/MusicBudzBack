package com.budz.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.budz.models.User;

public interface UserRepo extends CrudRepository<User, Integer> {

//	ArrayList<User> getAllUsers();
//	ArrayList<User> getUsersByUsername(String query);
//	User loginWithEmail(String email, String password);
//	User loginWithUsername(String username, String password);
//	User getUserDataById(int userId);
//	ArrayList<User> getFriends(int userId);
//	void updateUserData(User user);
//	void deleteAccount(int userId);
}

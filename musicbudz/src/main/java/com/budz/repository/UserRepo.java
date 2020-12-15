package com.budz.repository;

import java.util.ArrayList;

import com.budz.models.User;

public interface UserRepo {

	void createUser(String email, String password, String userName, String firstName, String lastName);
	ArrayList<User> getAllUsers();
	User loginWithEmail(String email, String password);
	User loginWithUsername(String username, String password);
	User getUserData(int userId);
	ArrayList<User> getFriends(int userId);
	void updateUserData(User user);
	void deleteAccount(int userId);
}

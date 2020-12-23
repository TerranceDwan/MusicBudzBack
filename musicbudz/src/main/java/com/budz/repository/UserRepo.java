package com.budz.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.budz.models.User;

public interface UserRepo extends CrudRepository<User, Integer> {
	
	User findByEmail(String email);
	
	@Query("select u from User u where u.userName like %:userName%")
	ArrayList<User> getUsersByUserName(String userName);
	
	@Query("select u from User u where u.email = :email AND u.password = :password")
	User loginEmail(String email, String password);

	@Query("select u from User u where u.userName = :userName AND u.password = :password")
	User loginUserName(String userName, String password);
	
	
}

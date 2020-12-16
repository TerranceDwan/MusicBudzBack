package com.budz;

import static org.mockito.Mockito.mock;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.budz.models.User;
import com.budz.repository.UserRepoImpl;
import com.budz.service.UserService;


public class UserTests {
	@InjectMocks
	private static UserService userService;
	
	@Mock private UserRepoImpl userRepo = mock(UserRepoImpl.class);
	
	ArrayList<User> users = new ArrayList<User>();
	
	@BeforeClass
	public void setUp() {
		userService = new UserService();
	}
	
	@BeforeEach
	public void before() {
		User user1 = new User(1, "email@email.com", "password", "user1", "John", "Doe");
		User user2 = new User(2, "email", "password", "user2", "Jeff", "Doe");
		User user3 = new User(3, "email@email.com", "pass", "user3", "Jim", "Doe");
		User user4 = new User(4, "email@email.com", "pass", "", "Jim", "Doe");
		User user5 = new User(5, "email@email.com", "pass", "user5", "", "Doe");
		User user6 = new User(6, "email@email.com", "pass", "user6", "Jim", "");
		users.add(user1);
		users.add(user2);
		users.add(user3);
		users.add(user4);
		users.add(user5);
		users.add(user6);
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void createUser(){
		Mockito.doNothing().when(userRepo).createUser(Mockito.any());
		
		userService.createUser(users.get(0));
		
		Mockito.verify(userRepo).createUser(Mockito.any());
	}
	
	@Test
	public void createUserBadEmail() {
		userService.createUser(users.get(1));
		
		Mockito.verifyNoInteractions(userRepo);
	}
	
	@Test
	public void createUserShortPassword() {
		userService.createUser(users.get(2));
		
		Mockito.verifyNoInteractions(userRepo);
	}
	
	@Test
	public void createUserNoUsername() {
		userService.createUser(users.get(3));
		
		Mockito.verifyNoInteractions(userRepo);
	}
	
	@Test
	public void createUserNoFirstName() {
		userService.createUser(users.get(4));
		
		Mockito.verifyNoInteractions(userRepo);
	}
	
	@Test
	public void createUserNoLastName() {
		userService.createUser(users.get(5));
		
		Mockito.verifyNoInteractions(userRepo);
	}
	
	@Test
	public void loginWithEmail() {
		Mockito.doReturn(users.get(0)).when(userRepo).loginWithEmail(Mockito.any(), Mockito.any());
		
		userService.login(users.get(0).getEmail(), users.get(0).getPassword());
		
		Mockito.verify(userRepo).loginWithEmail(Mockito.any(), Mockito.any());
	}
	
	@Test
	public void loginWithUsername() {
		Mockito.doReturn(users.get(0)).when(userRepo).loginWithUsername(Mockito.any(), Mockito.any());
		
		userService.login(users.get(0).getUserName(), users.get(0).getPassword());
		
		Mockito.verify(userRepo).loginWithUsername(Mockito.any(), Mockito.any());
	}
	
	@Test
	public void loginWithEmptyField() {
		userService.login(users.get(0).getUserName(), "");
		userService.login("", users.get(0).getPassword());
		
		Mockito.verifyNoInteractions(userRepo);
	}

}

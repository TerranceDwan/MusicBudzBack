package com.budz.service;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.budz.MusicBudzApplication;
import com.budz.models.User;
import com.budz.repository.UserRepo;

@SpringBootTest(classes=MusicBudzApplication.class)
@RunWith(SpringRunner.class)
public class UserServiceTest {
	
	ArrayList<User> users = new ArrayList<User>();
	
	@Autowired
	private UserService userService;
	
	@MockBean
	private UserRepo userRepo;
	
	@Before
	public void setUp() {
		
	}
	
	@BeforeEach
	public void beforeEach() {
		User user1 = new User(1, "email@email.com", "password", "user1", "John", "Doe");
		User user2 = new User(2, "email", "password", "user2", "Jeff", "Doe");
		User user3 = new User(3, "email@email.com", "pass", "user3", "Jim", "Doe");
		User user4 = new User(4, "emailemail.com", "password", "us", "Jim", "Doe");
		User user5 = new User(5, "email@email.com", "abc", "user5", "", "Doe");
		User user6 = new User(6, "email@email.com", "pass", "user6", "Jim", "");
		users.add(user1);
		users.add(user2);
		users.add(user3);
		users.add(user4);
		users.add(user5);
		users.add(user6);
	}
	
//	------------------------ Create User Method --------------------------
	
	@Test
	public void createUser(){
		System.out.println("Test");
		Mockito.doReturn(users.get(0)).when(userRepo).save(Mockito.any());
		
		userService.createUser(users.get(0));
		
		Mockito.verify(userRepo).save(Mockito.any());
	}
	
	@Test
	public void createUserBadEmail() {
		userService.createUser(users.get(1));
		userService.createUser(users.get(3));
		
		Mockito.verifyNoInteractions(userRepo);
	}
	
	@Test
	public void createUserShortPassword() {
		userService.createUser(users.get(2));
		userService.createUser(users.get(4));
		
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
	
//	----------------------  Login Method -------------------------
	
	@Test
	public void loginWithEmail() {
		Mockito.doReturn(users.get(0)).when(userRepo).loginEmail(Mockito.any(), Mockito.any());
		
		userService.login(users.get(0).getEmail(), users.get(0).getPassword());
		
		Mockito.verify(userRepo).loginEmail(Mockito.any(), Mockito.any());
	}
	
	@Test
	public void loginWithUsername() {
		Mockito.doReturn(users.get(0)).when(userRepo).loginUserName(Mockito.any(), Mockito.any());
		
		userService.login(users.get(0).getUserName(), users.get(0).getPassword());
		
		Mockito.verify(userRepo).loginUserName(Mockito.any(), Mockito.any());
	}
	
	@Test
	public void loginWithEmptyField() {
		userService.login(users.get(0).getUserName(), "");
		userService.login("", users.get(0).getPassword());
		userService.login("", "");
		
		Mockito.verifyNoInteractions(userRepo);
	}
	
//	----------------------  Get Users By Username Method -------------------------

	@Test
	public void searchUserByUsername() {
		Mockito.doReturn(users).when(userRepo).getUsersByUserName(Mockito.any());
		
		// Searching Usernames with Use in them
		userService.getUsersByUsername("use");
		
		Mockito.verify(userRepo).getUsersByUserName(Mockito.any());
	}
	
	@Test
	public void searchUsersByUsernameLessThan3Characters(){
		userService.getUsersByUsername("us");
		
		Mockito.verifyNoInteractions(userRepo);
	}
	
//	----------------------  Get User By Id -------------------------
	
	@Test
	public void getUserByUserId() {
		Mockito.doReturn(Optional.of(users.get(0))).when(userRepo).findById(Mockito.anyInt());
		
		userService.getUserById(1);
		
		Mockito.verify(userRepo).findById(Mockito.anyInt());
	}

//	----------------------  Get Friends -------------------------

//	@Test
//	public void getFriends() {
//		Mockito.doReturn(users).when(userRepo).getFriends(Mockito.anyInt());
//		
//		userService.getFriends(1);
//		
//		Mockito.verify(userRepo).getFriends(Mockito.anyInt());
//	}
	
//	----------------------  Update User -------------------------

	@Test
	public void updateUser() {
		Mockito.doReturn(users.get(0)).when(userRepo).save(Mockito.any());
		
		userService.updateUser(users.get(0));
		
		Mockito.verify(userRepo).save(Mockito.any());
	}
	
	@Test
	public void updateUserBadEmail() {
		userService.updateUser(users.get(1));
		userService.updateUser(users.get(1));
		
		Mockito.verifyNoInteractions(userRepo);
	}
	
	@Test
	public void updateUserShortPassword() {
		userService.updateUser(users.get(2));
		userService.updateUser(users.get(4));
		
		Mockito.verifyNoInteractions(userRepo);
	}
	
//	----------------------  Delete User -------------------------
	@Test
	public void deleteUser() {
		Mockito.doNothing().when(userRepo).deleteById(Mockito.anyInt());
		
		userService.deleteAccount(0);
		
		Mockito.verify(userRepo).deleteById(Mockito.anyInt());
	}
}

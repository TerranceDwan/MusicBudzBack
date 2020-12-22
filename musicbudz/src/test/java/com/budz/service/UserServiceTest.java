package com.budz.service;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

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
	private UserRepo userRepo = Mockito.mock(UserRepo.class);
	
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
	
	@Test
	public void createUser() {
		Mockito.doReturn(users.get(0)).when(userRepo).save(Mockito.any());
		
		userService.createUser(users.get(0));
		
		Mockito.verify(userRepo.save(Mockito.any()));
	}
}

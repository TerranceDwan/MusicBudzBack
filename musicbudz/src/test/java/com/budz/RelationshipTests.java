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
import com.budz.repository.RelationshipRepoImpl;
import com.budz.service.RelationshipService;

public class RelationshipTests {
	@InjectMocks
	private static RelationshipService relationshipService;
	
	@Mock private RelationshipRepoImpl relationshipRepo = mock(RelationshipRepoImpl.class);
	
	ArrayList<User> users = new ArrayList<User>();
	
	@BeforeClass
	public void setUp() {
		relationshipService = new RelationshipService();
	}
	
	@BeforeEach
	public void before() {
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
		MockitoAnnotations.openMocks(this);
	}
	
//	------------------------ Add Friend --------------------------
	
	@Test
	public void addFriend() {
		Mockito.doNothing().when(relationshipRepo).addFriend(Mockito.anyInt(), Mockito.anyInt());
		
		relationshipService.addFriend(1, 2);
		
		Mockito.verify(relationshipRepo).addFriend(Mockito.anyInt(), Mockito.anyInt());
	}
	
	@Test
	public void addFriendSameUserId() {		
		relationshipService.addFriend(2, 2);
		
		Mockito.verifyNoInteractions(relationshipRepo);
	}
	
//	------------------------ Get Friend Requests --------------------------
	
	@Test
	public void getFriendRequests() {
		Mockito.doReturn(users).when(relationshipRepo).getFriendRequest(Mockito.anyInt());
		
		relationshipService.getFriendRequests(users.get(0));
		
		Mockito.verify(relationshipRepo).getFriendRequest(Mockito.anyInt());
	}
	
//	------------------------ Accept Friend Requests --------------------------

	@Test
	public void acceptFriendRequest() {
		Mockito.doNothing().when(relationshipRepo).acceptFriendRequest(Mockito.anyInt(), Mockito.anyInt());
		
		relationshipService.approveFriendRequest(users.get(0), 2);
		
		Mockito.verify(relationshipRepo).acceptFriendRequest(Mockito.anyInt(), Mockito.anyInt());
	}
	
	@Test
	public void acceptFriendRequestSameUserId() {		
		relationshipService.approveFriendRequest(users.get(1), 2);
		
		Mockito.verifyNoInteractions(relationshipRepo);
	}
	
//	------------------------ Deny Friend Requests --------------------------

	@Test
	public void denyFriendRequest() {
		Mockito.doNothing().when(relationshipRepo).denyFriendRequest(Mockito.anyInt(), Mockito.anyInt());
		
		relationshipService.denyFriendRequest(users.get(0), 2);
		
		Mockito.verify(relationshipRepo).denyFriendRequest(Mockito.anyInt(), Mockito.anyInt());
	}
	
	@Test
	public void denyFriendRequestSameUserId() {		
		relationshipService.denyFriendRequest(users.get(1), 2);
		
		Mockito.verifyNoInteractions(relationshipRepo);
	}
	
//	------------------------ Delete Friend --------------------------

	@Test
	public void deleteRelationship() {
		Mockito.doNothing().when(relationshipRepo).deleteFriend(Mockito.anyInt(), Mockito.anyInt());
		
		relationshipService.deleteRelationship(users.get(0), 2);
		
		Mockito.verify(relationshipRepo).deleteFriend(Mockito.anyInt(), Mockito.anyInt());
	}
	
	@Test
	public void deleteRelationshipSameUserId() {		
		relationshipService.deleteRelationship(users.get(1), 2);
		
		Mockito.verifyNoInteractions(relationshipRepo);
	}

//------------------------ Delete All Friend --------------------------

	@Test
	public void deleteAllRelationship() {
		Mockito.doNothing().when(relationshipRepo).deleteAllFriends(Mockito.anyInt());
		
		relationshipService.deleteAllRelationshipsForUser(users.get(0));
		
		Mockito.verify(relationshipRepo).deleteAllFriends(Mockito.anyInt());
	}
}


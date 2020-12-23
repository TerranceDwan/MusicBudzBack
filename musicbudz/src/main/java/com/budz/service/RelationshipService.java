package com.budz.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.budz.models.User;
import com.budz.repository.RelationshipRepo;

@Service
public class RelationshipService {
	
	@Autowired
	private RelationshipRepo relationshipRepo;

	public void addFriend(int userId, int friendId) {
		relationshipRepo.addFriend(userId, friendId);
	}
	
	public ArrayList<User> getFriendRequests(int userId){
		return relationshipRepo.getFriendRequest(userId);
	}
	
	public void approveFriendRequest(int userId, int friendId) {
		relationshipRepo.acceptFriendRequest(userId, friendId);
	}
	
	public void denyFriendRequest(int userId, int friendId) {
		relationshipRepo.denyFriendRequest(userId, friendId);
	}
	
	public void deleteRelationship(int userId, int friendId) {
		relationshipRepo.deleteFriend(userId, friendId);
	}
	
	public void deleteAllRelationshipsForUser(int userId) {
		relationshipRepo.deleteAllFriends(userId);
	}
}

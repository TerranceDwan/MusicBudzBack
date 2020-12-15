package com.budz.service;

import java.util.ArrayList;

import com.budz.models.User;

public class RelationshipService {

	public void addFriend(int userId, int friendId) {
		
	}
	
	public ArrayList<User> getFriends(User user){
		return new ArrayList<User>();
	}
	
	public ArrayList<User> getFriendRequests(User user){
		return new ArrayList<User>();
	}
	
	public void approveFriendRequest(User user, int friendId) {
		
	}
	
	public void denyFriendRequest(User user, int friendId) {
		
	}
	
	public void deleteRelationship(User user, int friendId) {
		
	}
	
	public void deleteAllRelationshipsForUser(User user) {
		
	}
}

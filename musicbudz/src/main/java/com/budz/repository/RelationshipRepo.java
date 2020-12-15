package com.budz.repository;

import java.util.ArrayList;

import com.budz.models.User;

public interface RelationshipRepo {
	
	void addFriend(int userId, int friendUserId);
	ArrayList<User> getFriends(int userId);
	ArrayList<User> getFriendRequest(int userId);
	void acceptFriendRequest(int userId, int friendUserId);
	void denyFriendRequest(int userId, int friendUserId);
	void deleteFriend(int userId, int friendUserId);
}

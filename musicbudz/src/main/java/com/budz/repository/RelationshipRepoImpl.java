package com.budz.repository;

import java.util.ArrayList;

import com.budz.models.User;

public class RelationshipRepoImpl implements RelationshipRepo {

	@Override
	public void addFriend(int userId, int friendUserId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<User> getFriendRequest(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void acceptFriendRequest(int userId, int friendUserId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void denyFriendRequest(int userId, int friendUserId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteFriend(int userId, int friendUserId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllFriends(int userId) {
		// TODO Auto-generated method stub
		
	}

}

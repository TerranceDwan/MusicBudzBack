package com.budz.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.budz.models.Relationship;
import com.budz.models.User;

@Transactional
@Repository
public interface RelationshipRepo extends JpaRepository<Relationship, Integer> {
	@Transactional
	@Modifying
	@Query(value = "INSERT INTO Relationship (userOneId, userTwoId, status, actionUserId) VALUES (:userId, :friendUserId, 0, :friendUserId)", nativeQuery = true)
	void addFriend(int userId, int friendUserId);
	
	@Query("SELECT u FROM User u INNER JOIN Relationship r ON r.userOneId = :userId OR r.userTwoId = :userId WHERE u.userId <> :userId")
	ArrayList<User> getFriendRequest(int userId);
	
	@Transactional
	@Modifying
	@Query("UPDATE Relationship r SET r.status = 1 WHERE r.userOneId = :userId AND r.userTwoId = :friendUserId")
	void acceptFriendRequest(int userId, int friendUserId);
	
	@Transactional
	@Modifying
	@Query("UPDATE Relationship r SET r.status = 2 WHERE r.userOneId = :userId AND r.userTwoId = :friendUserId")
	void denyFriendRequest(int userId, int friendUserId);
	
	@Transactional
	@Modifying
	@Query("UPDATE Relationship r SET r.status = 3 WHERE r.userOneId = :userId AND r.userTwoId = :friendUserId")
	void deleteFriend(int userId, int friendUserId);
	
	@Transactional
	@Modifying
	@Query("UPDATE Relationship r SET r.status = 1 WHERE r.userOneId = :userId")
	void deleteAllFriends(int userId);
	
	//make sure this should be checking both userIds or just one
	@Query("Select u from user u where u.userOneId = :userId OR u.userTwoId = :userId")
	ArrayList<Relationship> getAllFriends(int userId);
}

package com.budz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.budz.models.User;
import com.budz.service.RelationshipService;

@RestController
@RequestMapping(path="/relationship")
@CrossOrigin
public class RelationshipController {
	
	@Autowired
	private RelationshipService relationshipService;
	
	@PostMapping("/add")
	public void addFriend(@RequestParam int userId, @RequestParam int friendId) {
		
	}
	
	@GetMapping("/get")
	public List<User> getFriendRequests(@RequestParam int user) {
		return relationshipService.getFriendRequests(
			/* TODO Placeholder */
			new User()
		);
	}
	
	@PostMapping("/approve")
	public void approveFriendRequest(@RequestParam int userId, @RequestParam int friendId) {
		relationshipService.approveFriendRequest(userId, friendId);
	}
	
	@PostMapping("/deny")
	public void denyFriendRequest(@RequestParam int userId, @RequestParam int friendId) {
		relationshipService.denyFriendRequest(userId, friendId);
	}
	
	@PostMapping("/delete")
	public void deleteRelationship(@RequestParam int userId, @RequestParam int friendId) {
		relationshipService.deleteRelationship(userId, friendId);
	}
	
	@PostMapping("/deleteAll")
	public void deleteAllRelationshipsForUse(@RequestParam int userId) {
		relationshipService.deleteAllRelationshipsForUser(userId);
	}
}

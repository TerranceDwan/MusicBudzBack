package com.budz.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.budz.models.Comment;
import com.budz.models.Review;
import com.budz.models.User;
import com.budz.service.CommentService;
import com.budz.service.ReviewService;
import com.budz.service.UserService;

@RestController
@RequestMapping(value = "/comment")
@CrossOrigin
public class CommentController {
	
	private CommentService commentService;
	private UserService userService;
	private ReviewService reviewService;
	
	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public void setReviewService(ReviewService reviewService) {
		this.reviewService = reviewService;
	}
	
	@PostMapping("/new")
	public void newComment(@RequestBody Comment comment) {
		commentService.save(comment);
	}
	
	@PostMapping("/edit")
	public void editComment(@RequestBody Comment comment) {
		commentService.update(comment);
	}
	
	@PostMapping("/delete")
	public void deleteComment(@RequestBody Comment comment) {
		commentService.delete(comment);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Comment>> allComments() {
		List<Comment> comments = commentService.findAll();
		return new ResponseEntity<List<Comment>>(comments, HttpStatus.OK);
	}
	
	@GetMapping("/by-user")
	public ResponseEntity<List<Comment>> findByUser(@RequestParam int userId) {
		User user = userService.getUserById(userId);
		List<Comment> comments = commentService.findByUser(user);
		return new ResponseEntity<List<Comment>>(comments, HttpStatus.OK);
	}
	
	@GetMapping("/by-review")
	public ResponseEntity<List<Comment>> findByReview(@RequestParam int reviewId) {
		Review review = reviewService.getReview(reviewId);
		List<Comment> comments = commentService.findByReview(review);
		return new ResponseEntity<List<Comment>>(comments, HttpStatus.OK);
	}
	
}

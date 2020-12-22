package com.budz.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.budz.service.ReviewService;
import com.budz.exceptions.InvalidRatingException;
import com.budz.models.Review;
import com.budz.models.User;

@RestController
@RequestMapping(path="/review")
@CrossOrigin
public class ReviewController {
	@Autowired
	private ReviewService reviewService;
	
	@PostMapping("/postRewiew")
	public void postReview(@RequestParam String name, @RequestParam String type, @RequestParam int userId, 
			@RequestParam String artistName, @RequestParam float rating, @RequestParam String title, @RequestParam String Review) {
		try {
			Review rev = new Review(name, type, userId, artistName, rating, title, Review);
			reviewService.postReview(rev);
		} catch (InvalidRatingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//might switch this one to receiving a Review object
	@PostMapping("/updateReview")
	public void updateReview(@RequestParam int reviewId, @RequestParam String name, @RequestParam String type, @RequestParam int userId, 
			@RequestParam String artistName, @RequestParam float rating, @RequestParam String title, @RequestParam String Review) {
		try {
			Review rev = new Review(name, type, userId, artistName, rating, title, Review);
			reviewService.updateReview(rev);
		} catch (InvalidRatingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@GetMapping("/getReview")
	public Review getReview(@RequestParam int reviewId) {
		return reviewService.getReview(reviewId);
	}
	
	//might switch this one to receiving a Review object
	@PostMapping("/deleteReview")
	public void deleteReview(@RequestParam int reviewId, @RequestParam String name, @RequestParam String type, @RequestParam int userId, 
			@RequestParam String artistName, @RequestParam float rating, @RequestParam String title, @RequestParam String Review) {
		try {
			Review rev = new Review(name, type, userId, artistName, rating, title, Review);
			reviewService.deleteReview(rev);
		} catch (InvalidRatingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@GetMapping("/getFeed")
	public ArrayList<Review> getFeed(@RequestParam User user) {
		return reviewService.getFeed(user);
	}
	
	@GetMapping("/getReviewsByUser")
	public ArrayList<Review> getReviewsByUser(@RequestParam User user) {
		return reviewService.getReviewsByUser(user);
	}
}
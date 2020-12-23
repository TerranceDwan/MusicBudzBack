package com.budz.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.budz.models.Review;
import com.budz.models.User;
import com.budz.repository.RelationshipRepo;
import com.budz.repository.ReviewRepo;

@Service
public class ReviewService {
	
	@Autowired
	ReviewRepo repo1;
	@Autowired
	RelationshipRepo repo2;
	
	public void postReview(Review review) {
		repo1.save(review);
	}
	
	public void updateReview(Review review) {
		repo1.save(review);
	}
	
	public Review getReview(int reviewId) {
		Optional<Review> toReturn = repo1.findById(reviewId);
		if(!toReturn.isEmpty()) {
			return toReturn.get();
		} else {
			return null;
		}
	}
	
	public void deleteReview(Review review) {
		repo1.delete(review);
	}
	
	//need RelationshipRepo complete before i can implement this
	public ArrayList<Review> getFeed(User user) {
		return new ArrayList();
	}
	
	public ArrayList<Review> getReviewsByUserId(int userId) {
		return repo1.getReviewsByUserId(userId);
	}
}

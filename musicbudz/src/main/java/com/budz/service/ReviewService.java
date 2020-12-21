package com.budz.service;

import java.util.ArrayList;

import com.budz.models.Review;
import com.budz.models.User;

public class ReviewService {
	//ReviewRepoImpl rimpl = new ReviewRepoImpl()
	
	public void postReview(Review review) {
		
	}
	
	public void updateReview(Review review) {
		
	}
	
	//might need to make multiple of these? cant think of use cases yet 
	public Review getReview(int reviewId) {
		return null;
	}
	
	public void deleteReview(Review review) {
		
	}
	
	public ArrayList<Review> getFeed(User user) {
		return new ArrayList();
	}
	
	public ArrayList<Review> getReviewsByUser(User user) {
		return new ArrayList();
	}
}

package com.budz.repository;

import java.util.ArrayList;

import com.budz.models.*;

public interface ReviewRepo {
	void insertReview(Review review);
	void updateReview(Review review);
	Review getReview();
	ArrayList<Review> getAllReviews();
	ArrayList<Review> getReviewsByUser(User user);
	void deleteReview();
}

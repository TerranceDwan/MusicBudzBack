package com.budz.repository;

import com.budz.models.*;

public interface ReviewRepo {
	void insertReview();
	void updateReview(Review review);
	Review getReview();
	Review[] getAllReviews();
	Review[] getReviewsByUser(User user);
	void deleteReview();
}

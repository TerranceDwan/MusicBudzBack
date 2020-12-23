package com.budz.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.budz.models.*;

public interface ReviewRepo extends CrudRepository<Review, Integer>{
	
	@Query("Select * from Review * where *.userId like %:userId%")
	ArrayList<Review> getReviewsByUserId(int userId); 
//	void insertReview(Review review);
//	void updateReview(Review review);
//	Review getReview();
//	ArrayList<Review> getAllReviews();
//	ArrayList<Review> getReviewsByUser(User user);
//	void deleteReview();
}

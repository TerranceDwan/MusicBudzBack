package com.budz.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.budz.models.*;

public interface ReviewRepo extends CrudRepository<Review, Integer>{
	
	@Query("Select u from Review u where u.userId = :userId")
	ArrayList<Review> getReviewsByUserId(int userId); 
	
	@Query("Select u from Review u where u.title like %:name%")
	ArrayList<Review> getReviewsByName(String name);
//	void insertReview(Review review);
//	void updateReview(Review review);
//	Review getReview();
//	ArrayList<Review> getAllReviews();
//	ArrayList<Review> getReviewsByUser(User user);
//	void deleteReview();
}

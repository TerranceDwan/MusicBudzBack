package com.budz.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.budz.exceptions.InvalidRatingException;

@Entity
@Table(name = "reviews")
public class Review {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int reviewId;
	private String name;
	private String type;
	private int userId;
	private String artistName;
	private float rating;
	private String title;
	private String review;
	
	
	public Review(String name, String type, int userId, String artistName, float rating, String title, String review) throws InvalidRatingException {
		super();
		this.setName(name);
		this.setType(type);
		this.setUserId(userId);
		this.setArtistName(artistName);
		this.setRating(rating);
		this.setTitle(title);
		this.setReview(review);
	}
	
	public Review(int reviewId, String name, String type, int userId, String artistName, float rating, String title, String review) throws InvalidRatingException {
		super();
		this.setReviewId(reviewId);
		this.setName(name);
		this.setType(type);
		this.setUserId(userId);
		this.setArtistName(artistName);
		this.setRating(rating);
		this.setTitle(title);
		this.setReview(review);
	}
	
	public int getReviewId() {
		return reviewId;
	}
	
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) throws InvalidRatingException {
		if(rating > 5 || rating < 0) {
			throw new InvalidRatingException();
		}
		this.rating = rating;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}

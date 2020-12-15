package com.budz.models;

import com.budz.exceptions.InvalidRatingException;

public abstract class Review {
	
	private int userId;
	private String artistName;
	private float rating;
	private String title;
	private String review;
	
	
	public Review(int userId, String artistName, float rating, String title, String review) throws InvalidRatingException {
		super();
		this.setUserId(userId);
		this.setArtistName(artistName);
		this.setRating(rating);
		this.setTitle(title);
		this.setReview(review);
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
}

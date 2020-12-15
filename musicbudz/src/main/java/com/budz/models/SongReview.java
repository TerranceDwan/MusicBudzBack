package com.budz.models;

import com.budz.exceptions.InvalidRatingException;

public class SongReview {
	private int reviewId;
	private int userId;
	private String songName;
	private String artistName;
	private float rating;
	private String title;
	private String review;
	
	
	
	public SongReview(int reviewId, int userId, String songName, String artistName, float rating, String title, String review) throws InvalidRatingException {
		super();
		this.setReviewId(reviewId);
		this.setUserId(userId);
		this.setSongName(songName);
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

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
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

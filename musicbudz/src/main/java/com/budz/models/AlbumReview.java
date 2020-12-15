package com.budz.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.budz.exceptions.InvalidRatingException;

@Entity
public class AlbumReview {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int reviewId;
	private int userId;
	private String albumName;
	private String artistName;
	private float rating;
	private String title;
	private String review;
	
	
	
	public AlbumReview(int reviewId, int userId, String albumName, String artistName, float rating, String title, String review) throws InvalidRatingException {
		super();
		this.setReviewId(reviewId);
		this.setUserId(userId);
		this.setAlbumName(albumName);
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

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
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

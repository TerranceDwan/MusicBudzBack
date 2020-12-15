package com.budz.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.budz.exceptions.InvalidRatingException;

@Entity
public class AlbumReview extends Review{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int reviewId;
	private String albumName;
	
	public AlbumReview(int reviewId, int userId, String albumName, String artistName, float rating, String title, String review) throws InvalidRatingException {
		super(userId, artistName, rating, title, review);
		this.reviewId = reviewId;
		this.setAlbumName(albumName);
	}
	
	public AlbumReview(int userId, String albumName, String artistName, float rating, String title, String review) throws InvalidRatingException {
		super(userId, artistName, rating, title, review);
		this.setAlbumName(albumName);
	}

	public int getReviewId() {
		return reviewId;
	}
	
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}
}

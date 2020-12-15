package com.budz.models;

import javax.persistence.Entity;

import com.budz.exceptions.InvalidRatingException;

@Entity
public class AlbumReview extends Review{
	
	private String albumName;
	
	public AlbumReview(int reviewId, int userId, String albumName, String artistName, float rating, String title, String review) throws InvalidRatingException {
		super(reviewId, userId, artistName, rating, title, review);
		this.setAlbumName(albumName);
	}
	
	public AlbumReview(int userId, String albumName, String artistName, float rating, String title, String review) throws InvalidRatingException {
		super(userId, artistName, rating, title, review);
		this.setAlbumName(albumName);
	}


	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}
}

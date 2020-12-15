package com.budz.models;

import javax.persistence.Entity;

import com.budz.exceptions.InvalidRatingException;

@Entity
public class SongReview extends Review{

	private String songName;
	
	public SongReview(int reviewId, int userId, String songName, String artistName, float rating, String title, String review) throws InvalidRatingException {
		super(reviewId, userId, artistName, rating, title, review);
		this.setSongName(songName);
	}
	
	public SongReview(int userId, String songName, String artistName, float rating, String title, String review) throws InvalidRatingException {
		super(userId, artistName, rating, title, review);
		this.setSongName(songName);
	}

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}
}

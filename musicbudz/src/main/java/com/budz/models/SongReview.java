package com.budz.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.budz.exceptions.InvalidRatingException;

@Entity
public class SongReview extends Review{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int reviewId;
	private String songName;
	
	public SongReview(int reviewId, int userId, String songName, String artistName, float rating, String title, String review) throws InvalidRatingException {
		super(userId, artistName, rating, title, review);
		this.reviewId = reviewId;
		this.setSongName(songName);
	}
	
	public SongReview(int userId, String songName, String artistName, float rating, String title, String review) throws InvalidRatingException {
		super(userId, artistName, rating, title, review);
		this.setSongName(songName);
	}
	
	public int getReviewId() {
		return reviewId;
	}
	
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}
}

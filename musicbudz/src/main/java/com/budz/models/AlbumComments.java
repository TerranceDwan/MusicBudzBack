package com.budz.models;

import java.util.Date;

public class AlbumComments {
	private int id;
	private int userId;
	private int reviewId;
	private Date timestamp;
	private String comment;
	
	public AlbumComments(int id, int userId, int reviewId, Date timestamp, String comment) {
		setId(id);
		setUserId(userId);
		setReviewId(reviewId);
		setTimestamp(timestamp);
		setComment(comment);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getReviewId() {
		return reviewId;
	}
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
}

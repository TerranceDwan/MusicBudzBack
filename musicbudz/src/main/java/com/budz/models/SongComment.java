package com.budz.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SongComment {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int commentId;
	private int userId;
	private int reviewId;
	private Date timestamp;
	private String comment;
	
	public SongComment(int commentId, int userId, int reviewId, Date timestamp, String comment) {
		setCommentId(commentId);
		setUserId(userId);
		setReviewId(reviewId);
		setTimestamp(timestamp);
		setComment(comment);
	}
	
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
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

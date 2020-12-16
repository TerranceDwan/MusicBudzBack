package com.budz.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "comments")
public abstract class Comment {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int commentId;
	private int userId;
	private int reviewId;
	private Date time;
	private String comment;
	
	public Comment(int commentId, int userId, int reviewId, Date time, String comment) {
		setCommentId(commentId);
		setUserId(userId);
		setReviewId(reviewId);
		setTime(time);
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
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
}

package com.budz.models;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class SongComment extends Comment {
	
	public SongComment(int commentId, int userId, int reviewId, Date timestamp, String comment) {
		super(commentId, userId, reviewId, timestamp, comment);
	}
	
}

package com.budz.repository;

import java.util.ArrayList;

import com.budz.models.Comment;
import com.budz.models.Review;

public interface CommentRepo {
	void addComment(Comment comment);
	void updateComment(Comment comment);
	void deleteComment(Comment comment);
	ArrayList<Comment> getAllComments();
	ArrayList<Comment> getCommentsOnReview(Review review);

}

package com.budz.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.budz.models.Comment;
import com.budz.models.Review;
import com.budz.models.User;
import com.budz.repository.CommentRepository;

@Service("commentService")
public class CommentService {
	
	private CommentRepository commentRepository;
	
	@Autowired
	public void setCommentRepo(CommentRepository commentRepository) {
		this.commentRepository = commentRepository;
	}
	
	public void save(Comment comment) {
		commentRepository.save(comment);
	}
	public void update(Comment comment) {
		commentRepository.save(comment);
	}
	public void delete(Comment comment) {
		commentRepository.delete(comment);
	}
	public List<Comment> findAll() {
		return commentRepository.findAll();
	}
	public ArrayList<Comment> findByReview(Review review) {
		return commentRepository.findByReview(review);
	}
	public ArrayList<Comment> findByUser(User user) {
		return commentRepository.findByUser(user);
	}
}

package com.budz.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.budz.models.Comment;
import com.budz.models.Review;
import com.budz.models.User;

public interface CommentRepository extends CrudRepository<Comment, Integer> {
	<S extends Comment> S save(Comment comment);
	List<Comment> findAll();
	void update(Comment comment);
	void delete(Comment comment);
	ArrayList<Comment> findByReview(Review review);
	ArrayList<Comment> findByUser(User user);

}

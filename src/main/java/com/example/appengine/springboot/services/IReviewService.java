package com.example.appengine.springboot.services;

import java.util.List;
import java.util.Optional;

import com.example.appengine.springboot.entities.Review;

public interface IReviewService {

	public Optional<Review> findReviewById(int reviewId);

	public List<Review> findAllReviews();

	public void insertReview(Review review);

	public void updateReview(Review review);

	public void deleteReviewById(int reviewId);
	
}

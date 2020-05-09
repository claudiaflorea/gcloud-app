package com.example.appengine.springboot.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.appengine.springboot.entities.Review;
import com.example.appengine.springboot.services.IReviewService;

@RestController
@RequestMapping("/review")
public class ReviewController {

	@Autowired
	private IReviewService reviewService;
	
	@GetMapping(value = "/{reviewId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Optional<Review> findReviewById(@PathVariable("reviewId") int reviewId) {
		return reviewService.findReviewById(reviewId);
	}

	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Review> getReview() {
		return reviewService.findAllReviews();
	}

	@PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void insertReview(@RequestBody Review review) {
		reviewService.insertReview(review);
	}

	@PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateReview(@RequestBody Review review) {
		reviewService.updateReview(review);
	}

	@DeleteMapping(value = "/delete/{reviewId}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteReview(@PathVariable("reviewId") int reviewId) {
		reviewService.deleteReviewById(reviewId);
	}
	
}

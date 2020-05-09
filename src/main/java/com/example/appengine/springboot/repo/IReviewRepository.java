package com.example.appengine.springboot.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.appengine.springboot.entities.Review;

public interface IReviewRepository extends CrudRepository<Review, Integer> {

}

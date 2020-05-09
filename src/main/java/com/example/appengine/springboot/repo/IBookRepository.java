package com.example.appengine.springboot.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.appengine.springboot.entities.Book;

public interface IBookRepository extends CrudRepository<Book, Integer> {

}
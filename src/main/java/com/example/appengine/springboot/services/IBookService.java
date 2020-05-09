package com.example.appengine.springboot.services;

import java.util.List;
import java.util.Optional;

import com.example.appengine.springboot.entities.Book;

public interface IBookService {

	
	public Optional<Book> findBookById(int bookId);

	public Optional findBooksByCategoryId(int categoryId);
	
	public Optional findBooksBySubcategoryId(int subcategoryId);
	
	public List<Book> findAllBooks();

	public void insertBook(Book book);

	public void updateBook(Book book);

	public void deleteBookById(int bookId);
	
}
package com.example.appengine.springboot.controllers;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

import com.example.appengine.springboot.entities.Book;
import com.example.appengine.springboot.services.IBookService;


@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	private IBookService bookService;
	Optional<Book> listBook;
	
	@GetMapping(value = "/{bookId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Optional<Book> findBookById(@PathVariable("bookId") int bookId) {
		this.listBook = bookService.findBookById(bookId);
		return listBook;
	}

	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Book> getBooks() {
		return bookService.findAllBooks();
	}
	
	@GetMapping(value = "/all/{categoryId}",  produces = MediaType.APPLICATION_JSON_VALUE)
	public Optional<Book> getBooksByCategoryId(@PathVariable("categoryId") int categoryId) {
		return bookService.findBooksByCategoryId(categoryId);
	}
	
	@GetMapping(value = "/all/{subcategoryId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Optional<Book> getBooksBySubategoryId(@PathVariable("subcategoryId") int subcategoryId) {
		return bookService.findBooksBySubcategoryId(subcategoryId);
	}

	@PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void insertBook(@RequestBody Book book) {
		bookService.insertBook(book);
	}

	@PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateBook(@RequestBody Book book) {
		bookService.updateBook(book);
	}

	@DeleteMapping(value = "/delete/{bookId}",  consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteBook(@PathVariable("bookId") int bookId) {
		bookService.deleteBookById(bookId);
	}
		
}
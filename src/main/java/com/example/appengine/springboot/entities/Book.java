package com.example.appengine.springboot.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="book")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_generator")
	@SequenceGenerator(name = "book_generator", sequenceName = "book_generator", initialValue = 10000, allocationSize = 1)
	private Integer bookId;
	private String ISBN;
	private String title;
	private String publisher;
	private String author;
	private String category;
	private Date publishDate;
	private String image;
	@JsonIgnore
	@JsonIgnoreProperties("book")
	@OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
	private List<Review> reviews;

	// ------------getters and setters--------//
	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	
	// --------------------constructors------------//
	
	public Book() {
		super();
	}

	public Book(Integer bookId, String iSBN, String title, String publisher, String author, String category,
			Date publishDate, String image, List<Review> reviews) {
		super();
		this.bookId = bookId;
		ISBN = iSBN;
		this.title = title;
		this.publisher = publisher;
		this.author = author;
		this.category = category;
		this.publishDate = publishDate;
		this.image = image;
		this.reviews = reviews;
	}
	
	public Book(Integer bookId, String iSBN, String title, String publisher, String author, String category,
			Date publishDate, String image) {
		super();
		this.bookId = bookId;
		ISBN = iSBN;
		this.title = title;
		this.publisher = publisher;
		this.author = author;
		this.category = category;
		this.publishDate = publishDate;
		this.image = image;
	}
	
}
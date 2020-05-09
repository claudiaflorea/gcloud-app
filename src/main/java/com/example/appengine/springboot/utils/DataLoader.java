package com.example.appengine.springboot.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.example.appengine.springboot.entities.Book;
import com.example.appengine.springboot.entities.Review;
import com.example.appengine.springboot.entities.UserAccount;
import com.example.appengine.springboot.services.IBookService;
import com.example.appengine.springboot.services.IReviewService;
import com.example.appengine.springboot.services.IUserService;


@Component
public class DataLoader  implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private IUserService userService;
	@Autowired
	private IBookService bookService;
	@Autowired
	private IReviewService reviewService;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// TODO Auto-generated method stub
		loadData();
	}
	
	public Date dateFormat(String date) throws java.text.ParseException { 
		Date formattedDate = null;
		String pattern = "dd/MM/yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		
		try {
			formattedDate = simpleDateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return formattedDate;
	}
	
	private void loadData() {
		updateUsers();
		updateBooks();
		updateReviews();
	}

	private void updateUsers() {
		UserAccount user1= new UserAccount(100, "robert_james@yahoo.com", "wordpass09", "James", "Robert");
		UserAccount user2= new UserAccount(101, "s.sandy@yahoo.com", "wordpass09", "Sandy", "Sand");
		UserAccount user3= new UserAccount(102, "r.carl@yahoo.com", "wordpass09", "Carl", "Rodriguez");
		UserAccount user4= new UserAccount(103, "jeffree5@yahoo.com", "wordpass09", "Jefree", "Charles");
		UserAccount user5= new UserAccount(104, "ariana_santos@yahoo.com", "wordpass09", "Ariana", "Santos");
		userService.insertUserAccount(user1);
		userService.insertUserAccount(user2);
		userService.insertUserAccount(user3);
		userService.insertUserAccount(user4);
		userService.insertUserAccount(user5);
	}
	
	private void updateBooks() {
		try {
			Book book1 = new Book(200, "435665656546335", 
					"Rich Dad Poor Dad: What the Rich Teach Their Kids About Money", "America Publishing", 
					"Robert T. Kiyosaki", "Finance" , dateFormat("10/11/1960"), 
					"https://images-na.ssl-images-amazon.com/images/I/81nPwPrfwpL._AC._SR360,460.jpg");
			Book book2 = new Book(201, "876587687754335", 
					"The Intelligent Investor", "America Publishing", 
					"Benjamin Graham", "Finance" , dateFormat("23/09/2001"), 
					"https://m.media-amazon.com/images/I/41Iu3INMYNL.jpg");
			Book book3 = new Book(202, "32343510211875", 
					"The Boy from the Woods", "Grand Central Publishing", 
					"Harlan Coben", "Fantasy" , dateFormat("14/12/2018"), 
					"https://m.media-amazon.com/images/I/81raMRPP2XL._SX140_.jpg");
			Book book4 = new Book(203, "999877765544332", 
					"Dune", "ACE", 
					"Robert Gottlieb", "Fantasy" , dateFormat("06/06/2018"), 
					"https://m.media-amazon.com/images/I/91EWCXXofLL._SX140_.jpg");
			Book book5 = new Book(204, "444666767755432", 
					"Devoted", "Thomas & Mercer", 
					"Dean Koontz", "Fanstasy" , dateFormat("04/10/2017"), 
					"https://m.media-amazon.com/images/I/81YK2vnrqFL._SX140_.jpg");
			
			bookService.insertBook(book1);
			bookService.insertBook(book2);
			bookService.insertBook(book3);
			bookService.insertBook(book4);
			bookService.insertBook(book5);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	private void updateReviews() {
		try {
			List<UserAccount> users = new ArrayList<UserAccount>();
			users = userService.findAllUserAccounts();
			List<Book> books = new ArrayList<Book>();
			books = bookService.findAllBooks();
			
			Review rev1  = new Review(300, "Great book!", dateFormat("03/05/2020"), 5);
			rev1.setUser(users.get(0));
			rev1.setBook(books.get(0));
			
			Review rev2  = new Review(301, "I recommend this book to all economists!", dateFormat("03/05/2020"), 5);
			rev2.setUser(users.get(1));
			rev2.setBook(books.get(1));
			
			Review rev3  = new Review(302, "This is my favorite book from this author!", dateFormat("03/05/2020"), 5);
			rev2.setUser(users.get(2));
			rev2.setBook(books.get(1));
			
			reviewService.insertReview(rev1);
			reviewService.insertReview(rev2);
			reviewService.insertReview(rev3);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

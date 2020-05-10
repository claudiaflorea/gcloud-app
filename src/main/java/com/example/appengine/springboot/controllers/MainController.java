package com.example.appengine.springboot.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.appengine.springboot.entities.Book;
import com.example.appengine.springboot.entities.UserAccount;
import com.example.appengine.springboot.services.IBookService;
import com.example.appengine.springboot.services.IUserService;
import com.example.appengine.springboot.services.UserService;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

@Controller
public class MainController {

	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IBookService bookService;
	
	@GetMapping("/")
	public String hello(ModelMap modelMap, HttpSession session, HttpServletRequest request) {
		return "homepage";
	}
	
	@GetMapping("/books")
	private String listBook(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Book> listBook = bookService.findAllBooks();
        request.setAttribute("listBook", listBook);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/books.jsp");
        dispatcher.include(request, response);
        return "books";
    }
	
	@GetMapping("/login")
	public String login(ModelMap modelMap, HttpSession session, HttpServletRequest request) {
		UserAccount account = checkCookie(request);
		if (account == null) {
			modelMap.put("account", new UserAccount());
			return "login";
		} else {
			UserService userService = new UserService();
			if (userService.findUserAccountByUsernameAndPassword(account.getUsername(), account.getPassword()) != null) {
				session.setAttribute("username", account.getUsername());
				return "greet";
			} else {
				modelMap.put("error", "Account's Invalid");
				return "login";
			}
		}
	}
	
	@GetMapping("/signup")
	public String signupForm(ModelMap modelMap, HttpSession session, HttpServletRequest request) {
		UserAccount user = new UserAccount();
		modelMap.addAttribute("user", user);
		return "signup";
	}
	
	@GetMapping("/welcome")
	public String greet(ModelMap modelMap, HttpSession session, HttpServletRequest request) {
		UserAccount user = new UserAccount();
		modelMap.addAttribute("user", user);
		return "greet";
	}

  @RequestMapping (value="/register", method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String newUser(@ModelAttribute("registerForm") UserAccount registerForm, HttpServletRequest request,HttpServletResponse response) {
	   if(request.getParameter("firstName") != null && request.getParameter("lastName") != null && request.getParameter("username") != null && request.getParameter("password") != null) {
		   UserAccount user = new UserAccount();
		   user.setFirstName(request.getParameter("firstName"));
		   user.setLastName(request.getParameter("lastName"));
		   user.setUsername(request.getParameter("username"));
		   user.setPassword(request.getParameter("password"));
	       userService.insertUserAccount(user);
	       return "greet";
	   } else {
		   return "signup";
	   }
    }
	
  
    @RequestMapping (value="/login-user", method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String loginUser(@ModelAttribute("loginForm") UserAccount loginForm, HttpServletRequest request,HttpServletResponse response) {
        if(userService.findUserAccountByUsernameAndPassword(request.getParameter("username"), request.getParameter("password")) !=null) {
            Cookie ckUsername=new Cookie("username", request.getParameter("username"));
            ckUsername.setMaxAge(30*5);
            response.addCookie(ckUsername);
            Cookie ckPassword = new Cookie("password",  request.getParameter("password"));
			ckPassword.setMaxAge(3600);
			response.addCookie(ckPassword);
			return "greet";
        }
        else {
            return "login";
        }
    }
    
    @GetMapping(value = "/logout")
	public String logout(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		// Remove session
		session.removeAttribute("username");
		// Remove cookie
		for (Cookie cookie : request.getCookies()) {
			if (cookie.getName().equalsIgnoreCase("username")) {
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
			if (cookie.getName().equalsIgnoreCase("password")) {
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
		}
		return "homepage";
	}
    
    public UserAccount checkCookie(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		UserAccount account = null;
		String username = "", password = "";
		for (Cookie cookie : cookies) {
			if (cookie.getName().equalsIgnoreCase("username")) {
				username = cookie.getValue();
			}
			if (cookie.getName().equalsIgnoreCase("password")) {
				password = cookie.getValue();
			}
		}
		if (!username.isEmpty() && !password.isEmpty()) {
			account = new UserAccount(username, password);
		}
		return account;
	}
    
}

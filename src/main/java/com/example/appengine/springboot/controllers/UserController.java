package com.example.appengine.springboot.controllers;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.appengine.springboot.entities.UserAccount;
import com.example.appengine.springboot.services.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService userService;

	@GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public Optional<UserAccount> findAccountById(@PathVariable("id") int id) {
		return userService.findUserAccountById(id);
	}

	@GetMapping(value = "/all",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<UserAccount> getUserAccounts() {
		return userService.findAllUserAccounts();
	}

	@PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void insertUserAccount(@RequestBody UserAccount userAccount) {
		userService.insertUserAccount(userAccount);
	}

	@PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateUserAccount(@RequestBody UserAccount userAccount) {
		userService.updateUserAccount(userAccount);
	}

	@DeleteMapping(value = "/delete/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteUserAccount(@PathVariable("id") int id) {
		userService.deleteUserAccountById(id);
	}
	
//	@PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
//	public UserAccount findUserAccountByUsernameAndPassword(@RequestBody UserAccount userAccount) {
//		return userService.findUserAccountByUsernameAndPassword(userAccount.getUsername(), userAccount.getPassword());
//	}
}

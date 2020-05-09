package com.example.appengine.springboot.services;

import java.util.List;
import java.util.Optional;

import com.example.appengine.springboot.entities.UserAccount;

public interface IUserService {

	public Optional<UserAccount> findUserAccountById(int userAccountId);

	public List<UserAccount> findAllUserAccounts();

	public void insertUserAccount(UserAccount userAccount);

	public void updateUserAccount(UserAccount userAccount);

	public void deleteUserAccountById(int userAccountId);
	
	public UserAccount findUserAccountByUsernameAndPassword(String username, String password);
	
}

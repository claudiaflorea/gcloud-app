package com.example.appengine.springboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.appengine.springboot.entities.UserAccount;
import com.example.appengine.springboot.repo.IUserRepository;

@Service
public class UserService implements IUserService{
	
	@Autowired
	private IUserRepository userAccountRepository;

	public Optional<UserAccount> findUserAccountById(int userAccountId) {
		return userAccountRepository.findById(userAccountId);
	}

	public List<UserAccount> findAllUserAccounts() {
		return (List<UserAccount>) userAccountRepository.findAll();
	}

	public void insertUserAccount(UserAccount userAccount) {
		userAccountRepository.save(userAccount);
	}

	public void updateUserAccount(UserAccount userAccount) {
		userAccountRepository.save(userAccount);
	}

	public void deleteUserAccountById(int userAccountId) {
		userAccountRepository.deleteById(userAccountId);
	}
	
	public UserAccount findUserAccountByUsernameAndPassword(String username, String password) {
		return userAccountRepository.findUserAccountByUsernameAndPassword(username, password);
	}
}

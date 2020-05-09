package com.example.appengine.springboot.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.appengine.springboot.entities.UserAccount;

public interface IUserRepository extends CrudRepository<UserAccount, Integer> {
	
	public UserAccount findUserAccountByUsernameAndPassword(String username, String password);

}

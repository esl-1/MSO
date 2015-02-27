package com.eslauer.persistence;

import java.util.List;

import com.eslauer.models.User;


public interface IUserDAO {
	
	List<User> getAllUsers();
	User getUserByUsername(String username);
	
	void add(User user);
	void update(User user);
	void delete(User user);
}

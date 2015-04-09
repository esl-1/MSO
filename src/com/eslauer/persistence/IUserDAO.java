package com.eslauer.persistence;

import java.util.List;

import com.eslauer.models.User;

/**
 * DAO interface for USER table.
 * 
 * @author Edwin
 *
 */
public interface IUserDAO {
	
	/**
	 * 
	 * @return List of all USERS
	 */
	List<User> getAllUsers();
	
	/**
	 * 
	 * @param username
	 * @return USER
	 */
	User getUserByUsername(String username);
	
	/**
	 * Adds the new USER.
	 * @param user
	 */
	void add(User user);
	
	/**
	 * Updates the specified USER.
	 * @param user
	 */
	void update(User user);
	
	/**
	 * Deletes the specified USER.
	 * @param user
	 */
	void delete(User user);
}

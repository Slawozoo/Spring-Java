package com.mavenmvc.MavenWebProject.service;

import com.mavenmvc.MavenWebProject.model.User;

public interface UserService {
	
	/**
	 * Method to save User to DB from registration form
	 */
	void saveUser(User user);
	
	/**
	 * Method to find user using username during login
	 */
	User findByUserName(String username);
}

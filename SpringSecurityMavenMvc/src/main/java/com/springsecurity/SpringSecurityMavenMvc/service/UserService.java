package com.springsecurity.SpringSecurityMavenMvc.service;

import com.springsecurity.SpringSecurityMavenMvc.model.User;

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

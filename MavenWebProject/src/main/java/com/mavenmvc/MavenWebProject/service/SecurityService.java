package com.mavenmvc.MavenWebProject.service;

public interface SecurityService {

	/**
	 * This method returns the username after User Logged in
	 */
	String findLoggedInUsername();

    /**
     * Method for autologin using username and password
     */
    void autoLogin(String username, String password);
}

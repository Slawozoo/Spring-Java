package com.packages.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class AuthorProfile {

	@Autowired
	@Qualifier("author2")
	private Author  author;
	
	public AuthorProfile() {
	}
	
	public void displayName() {
		System.out.println("Name of author: "+author.getName());
	}
	public void displayEmail() {
		System.out.println("Email: "+author.getEmail());
	}
	public void displayAddress() {
		System.out.println("Address: "+author.getAddress());
	}
	public void displayInstitution() {
		System.out.println("Institution: "+author.getInstitution());
	}
}

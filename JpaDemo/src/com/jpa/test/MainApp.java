package com.jpa.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.jpa.dao.IAuthorDao;

@Component
@ComponentScan("com.jpa.test")
public class MainApp {
	IAuthorDao authorDao;
	
	@Autowired
	public MainApp(IAuthorDao authorDao) {
		this.authorDao = authorDao;
	}	
}

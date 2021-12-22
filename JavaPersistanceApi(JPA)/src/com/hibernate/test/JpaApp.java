package com.hibernate.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.hibernate.dao.IArticleDao;

@Component
@ComponentScan("com.hibernate.test")
public class JpaApp {
	IArticleDao articleDao;

	@Autowired
	public JpaApp(IArticleDao articleDao) {
		this.articleDao = articleDao;
	}
	
}

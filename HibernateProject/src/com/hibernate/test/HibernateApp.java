package com.hibernate.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.hibernate.dao.IArticleDao;

@Component
@ComponentScan("com.hibernate.test")
public class HibernateApp {
	IArticleDao articleDao;

	@Autowired
	public HibernateApp(IArticleDao articleDao) {
		this.articleDao = articleDao;
	}
	
	
}

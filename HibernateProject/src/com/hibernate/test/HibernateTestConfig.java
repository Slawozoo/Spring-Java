package com.hibernate.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.hibernate.dao.IArticleDao;
import com.hibernate.dao.impl.ArticleDaoImpl;

@Configuration
@ComponentScan("com.hibernate.test")
public class HibernateTestConfig {
	@Bean
	public IArticleDao articleDao() {
		return new ArticleDaoImpl();
	}
	
	
	
}

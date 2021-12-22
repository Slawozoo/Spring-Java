package com.hibernate.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.hibernate.dao.IArticleDao;
import com.hibernate.dao.impl.ArticleDaoImpl;

@Configuration
@ComponentScan("com.hibernate.test")
public class JpaTestConfig {
	EntityManagerFactory emFactory;
	EntityManager entityManager;
	
	@Bean
	public IArticleDao articleDao() {
		return new ArticleDaoImpl(emFactory, entityManager);
	}
}

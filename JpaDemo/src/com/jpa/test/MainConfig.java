package com.jpa.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.jpa.dao.IAuthorDao;
import com.jpa.dao.impl.AuthorDaoImpl;

@Component
@ComponentScan("com.jpa.test")
public class MainConfig {

	@Bean
	public IAuthorDao authorDao() {
		return new AuthorDaoImpl();
	}
}

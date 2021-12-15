package com.finaltask.corejavafinaltask;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.finaltask.corejavafinaltask.dao.IArticleDao;
import com.finaltask.corejavafinaltask.dao.IArticleOperations;
import com.finaltask.corejavafinaltask.dao.IAuthorDAO;
import com.finaltask.corejavafinaltask.dao.impl.ArticleDaoImpl;
import com.finaltask.corejavafinaltask.dao.impl.ArticleOperationsImpl;
import com.finaltask.corejavafinaltask.dao.impl.AuthorDAOImpl;

@Configuration
@ComponentScan("com.finaltask.corejavafinaltask")
@PropertySource("classpath:database.properties")
public class PublicationAppConfig {
	
	@Autowired
	Environment environment;

	private final String URL = "url";
	private final String USER = "dbuser";
	private final String DRIVER = "driver";
	private final String PASSWORD = "dbpassword";
	
	@Bean
	DataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setUrl(environment.getProperty(URL));
		driverManagerDataSource.setUsername(environment.getProperty(USER));
		driverManagerDataSource.setPassword(environment.getProperty(PASSWORD));
		driverManagerDataSource.setDriverClassName(environment.getProperty(DRIVER));
		
		return driverManagerDataSource;
	}

	@Bean
	public DownloadFile downloadFile() {
		return new DownloadFile();
	}
	
	@Bean
	public IArticleDao articleDao() {
		return new ArticleDaoImpl(dataSource());
	}
	
	@Bean
	public IAuthorDAO authorDao() {
		return new AuthorDAOImpl(dataSource());
	}
	
	@Bean
	public IArticleOperations articleOperations(){
		return new ArticleOperationsImpl();
	}
	
//	@Bean
//	public PublicationApp publicationApp() {
//		return new PublicationApp(downloadFile(), articleDao(), authorDao(),articleOperations(), dataSource());
//	}
	
	public PublicationAppConfig() {
		
	}
}

package com.finaltask.corejavafinaltask;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.finaltask.corejavafinaltask.dao.IArticleDao;
import com.finaltask.corejavafinaltask.dao.IArticleOperations;
import com.finaltask.corejavafinaltask.dao.IAuthorDAO;
import com.finaltask.corejavafinaltask.dao.impl.ArticleDaoImpl;
import com.finaltask.corejavafinaltask.dao.impl.ArticleOperationsImpl;
import com.finaltask.corejavafinaltask.dao.impl.AuthorDAOImpl;

@Configuration
public class PublicationAppConfig {

	@Bean
	public DownloadFile downloadFile() {
		return new DownloadFile();
	}
	
	@Bean
	public IArticleDao articleDao() {
		return new ArticleDaoImpl();
	}
	
	@Bean
	public IAuthorDAO authorDao() {
		return new AuthorDAOImpl();
	}
	
	@Bean
	public IArticleOperations articleOperations(){
		return new ArticleOperationsImpl();
	}
	
	@Bean
	public PublicationApp publicationApp() {
		return new PublicationApp(downloadFile(), articleDao(), authorDao(),articleOperations());
	}
}

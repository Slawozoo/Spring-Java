package com.finaltask.corejavafinaltask;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.finaltask.corejavafinaltask.dao.IArticleDao;
import com.finaltask.corejavafinaltask.dao.IArticleOperations;
import com.finaltask.corejavafinaltask.dao.IAuthorDAO;
import com.finaltask.corejavafinaltask.dao.impl.ArticleDaoImpl;
import com.finaltask.corejavafinaltask.dao.impl.ArticleOperationsImpl;
import com.finaltask.corejavafinaltask.dao.impl.AuthorDAOImpl;
import com.finaltask.corejavafinaltask.domain.Article;

public class Main {
	private final static String url = "jdbc:postgresql://localhost/db_App";
	private final static String user = "postgres";
	private final static String password = "admin123";

	public static void main(String[] args) {
		ApplicationContext context = 
		         new AnnotationConfigApplicationContext(PublicationAppConfig.class);

		//Getting beans from Config class
//		IArticleDao articleDao = context.getBean(ArticleDaoImpl.class);
//		IAuthorDAO authorDao = context.getBean(AuthorDAOImpl.class);
//		DownloadFile downloadFile = context.getBean(DownloadFile.class);
//		IArticleOperations articleOperations = context.getBean(ArticleOperationsImpl.class);
		PublicationApp pubApp = context.getBean(PublicationApp.class);
		
		int switchCase = pubApp.getMenuChoice();
		try {
			//Connect to database
			Connection con = DriverManager.getConnection(url, user, password);
			//System.out.println("data base connected successfully");
			switch(switchCase) {
			case 1:
				/*Download file from URL*/ 
				pubApp.downloadFile.downloadFile();
				break;
			case 2:
				/*File from the downloaded URL*/
				File file = new File("Article.json");
				
				/*Reading JSON file*/
				List<Article> articleList = pubApp.articleOperations.readFile(file);
				
				/*Create article table*/
				//pubApp.articleDAO.createArticleTableSql(con);
				
				/*Create author tables*/
				//pubApp.authorDAO.createAuthorTableSql(con);
				
				/*Insert into table from file*/
				pubApp.articleDao.insertIntoTable(con,articleList);
				
				break;
				
			case 3:
				/*Retrieve all article from database*/
				pubApp.articleDao.retrieveArticleTable(con);
				break;
				
			case 4:
				/*Insert into table from user input*/
				pubApp.articleDao.insertIntoTable(con);
				break;
				
			case 5:
				/*Retrieve article using title*/
				pubApp.articleDao.retrieveArticleByTitle(con);
				break;
				
			case 6:
				/*Retrieve article using author Detail*/
				pubApp.articleDao.retrieveArticleByAuthorEmail(con);
				break;
				
			case 7:
				/*Delete article by title*/
				pubApp.articleDao.deleteArticleByTitle(con);
				break;
				
			case 8:
				/*Delete article by author detail*/
				pubApp.articleDao.deleteArticleByAuthorEmail(con);
				break;
				
			case 9:	
				/*Export the database in JSON file*/
				List<Article> articleLists = pubApp.articleDao.generateArticle(con);
				pubApp.articleDao.writeJsonFile(articleLists);
				break;
				
			default:
				System.out.println("Enter valid case....");	
			}	
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (org.json.simple.parser.ParseException e) {
			e.printStackTrace();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}

package com.finaltask.corejavafinaltask;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.finaltask.corejavafinaltask.dao.IArticleDao;
import com.finaltask.corejavafinaltask.dao.IArticleOperations;
import com.finaltask.corejavafinaltask.dao.IAuthorDAO;
import com.finaltask.corejavafinaltask.dao.impl.ArticleDaoImpl;
import com.finaltask.corejavafinaltask.dao.impl.ArticleOperationsImpl;
import com.finaltask.corejavafinaltask.domain.Article;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = 
		         new AnnotationConfigApplicationContext(PublicationAppConfig.class);

		//Getting beans from Config class
		PublicationApp pubApp = context.getBean(PublicationApp.class);
		
		int switchCase = pubApp.getMenuChoice();
		try {
			switch(switchCase) {
			case 1:
				/*Download file from URL*/ 
				pubApp.downloadFile.downloadFile();
				break;
			case 2:
				/*File from the downloaded URL*/
				File file = new File("Articles.json");
				
				/*Reading JSON file*/
				List<Article> articleList = pubApp.articleOperations.readFile(file);
				
				/*Create article table*/
				//articleDAO.createArticleTableSql();
				
				/*Create author tables*/
				//authorDAO.createAuthorTableSql();
				
				/*Insert into table from file*/
				pubApp.articleDao.insertIntoTable(articleList);
				
				break;
				
			case 3:
				/*Retrieve all article from database*/
				pubApp.articleDao.retrieveArticleTable();
				break;
				
			case 4:
				/*Insert into table from user input*/
				pubApp.articleDao.insertIntoTable();
				break;
				
			case 5:
				/*Retrieve article using title*/
				pubApp.articleDao.retrieveArticleByTitle();
				break;
				
			case 6:
				/*Retrieve article using author Detail*/
				pubApp.articleDao.retrieveArticleByAuthorEmail();
				break;
				
			case 7:
				/*Delete article by title*/
				pubApp.articleDao.deleteArticleByTitle();
				break;
				
			case 8:
				/*Delete article by author detail*/
				pubApp.articleDao.deleteArticleByAuthorEmail();
				break;
				
			case 9:	
				/*Export the database in JSON file*/
				List<Article> articleLists = pubApp.articleDao.generateArticle();
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
//		catch (SQLException e) {
//			e.printStackTrace();
//		}
		
	}
}

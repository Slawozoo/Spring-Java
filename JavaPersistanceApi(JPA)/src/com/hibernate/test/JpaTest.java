package com.hibernate.test;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hibernate.model.Article;
import com.hibernate.model.Author;

public class JpaTest {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(JpaTestConfig.class);

		JpaApp mainJpaApp = context.getBean(JpaApp.class);

		System.out.println("JPA ");
		System.out.println("Choose the case you want to perform: ");
		System.out.println("1. Create and Insert Article Author: ");
		System.out.println("2. Retrieve Article and Author: ");
		System.out.println("3. Update Article and Author: ");
		System.out.println("4. Delete Article and Author: ");
		System.out.println("5. Retrieve Article and Author Using Criteria Api: ");
		System.out.println("6. Update Article and Author Using Criteria Api: ");
		System.out.println("7. Delete Article and Author Using Criteria Api: ");
		Scanner scn = new Scanner(System.in);
		int cases = scn.nextInt();
		switch(cases) {
		case 1:
			//For creating table and insert into DB
			UserInput userInput = new UserInput();
			Article article = userInput.getArticleFromUser();
			mainJpaApp.articleDao.insertArticleAuthor(article);
	
		break;
		case 2:
			//For retreiving data
			Article articleRetrieve = mainJpaApp.articleDao.retrieveArticleAuthor();
			displayArticle(articleRetrieve);
			
		break;
		case 3:
			//For updating data
			mainJpaApp.articleDao.updateArticleAuthor();
		break;
		case 4:
			//For deleting record from DB
			mainJpaApp.articleDao.deleteArticleAuthor();
		break;
		case 5:
			//For retreiving data using Criteria API
			List<Article> articleList = mainJpaApp.articleDao.retrieveArticleAuthorUsingCriteriaApi();
			displayAllArticle(articleList);
		break;
		case 6:
			//For updating record from DB using Criteria API
			mainJpaApp.articleDao.updateArticleAuthorUsingCriteriaApi();
		break;
		case 7:
			//For deleting record from DB using Criteria API
			mainJpaApp.articleDao.deleteArticleAuthor();
		break;
		default:
			System.out.println("Enter valid case only.!!");
		}
	}

	/**
	 * Display article and author
	 */
	private static void displayArticle(Article article) {
		System.out.println("Article: ");
		System.out.println("ID: "+article.getId()+" Title: "+article.getTitle()+" Published Date: "+article.getPublishedDate());
		for(Author author: article.getAuthorList()) {
		System.out.println("Authors : "+author.getFirstName()+" "+author.getLastName()+
				" "+author.getAddress()+" "+author.getInstitution()+" "+author.getEmail());
		}
		
	}
	private static void displayAllArticle(List<Article> articleList) {
		for(Article article: articleList) {
			System.out.println("-------------------------------");
			System.out.println("Article ID: "+article.getId());
			System.out.println("Title: "+article.getTitle());
			System.out.println("Published Date: "+article.getPublishedDate());
			for(Author author:article.getAuthorList()) {
				System.out.println("-------------------------------");
				System.out.println("\tFirst Name: "+author.getFirstName());
				System.out.println("\tLast Name: "+ author.getLastName());
				System.out.println("\tAddress: "+author.getAddress());
				System.out.println("\tInstitution: "+author.getInstitution());
				System.out.println("\tEmail: "+author.getEmail());
				System.out.println("-------------------------------");
			}
		}
	}

}

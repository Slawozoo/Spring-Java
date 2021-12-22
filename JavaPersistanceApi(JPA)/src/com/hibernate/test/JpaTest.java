package com.hibernate.test;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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
		mainJpaApp.articleDao.insertArticleAuthor();
	
		break;
		case 2:
			//For retreiving data
			mainJpaApp.articleDao.retrieveArticleAuthor();
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
			mainJpaApp.articleDao.retrieveArticleAuthorUsingCriteriaApi();;
		break;
		case 6:
			//For updating record from DB using Criteria API
			mainJpaApp.articleDao.updateArticleAuthorUsingCriteriaApi();
		break;
		case 7:
			//For deleting record from DB using Criteria API
//			mainJpaApp.articleDao.deleteArticleAuthor();
		break;
		default:
			System.out.println("Enter valid case only.!!");

		}
	}

}

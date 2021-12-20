package com.hibernate.test;

import java.util.Scanner;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HibernateTest {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		ApplicationContext context = 
		         new AnnotationConfigApplicationContext(HibernateTestConfig.class);
		
		HibernateApp hibernateApp = context.getBean(HibernateApp.class);
		System.out.println("Hibernate ");
		System.out.println("Choose the case you want to perform: ");
		System.out.println("1. Create and Insert Article Author: ");
		System.out.println("2. Retrieve Article and Author: ");
		System.out.println("3. Update Article and Author: ");
		System.out.println("4. Delete Article and Author: ");
		Scanner scn = new Scanner(System.in);
		int cases = scn.nextInt();
		switch(cases) {
		case 1:
			//For creating table and insert into DB
			hibernateApp.articleDao.insertArticleAuthor(sessionFactory);
	
		break;
		case 2:
			//For retreiving data
			hibernateApp.articleDao.retrieveArticleAuthor(sessionFactory);
		break;
		case 3:
			//For updating data
			hibernateApp.articleDao.updateArticleAuthor(sessionFactory);
		break;
		case 4:
			//For deleting record from DB
			hibernateApp.articleDao.deleteArticleAuthor(sessionFactory);
		break;
		default:
			System.out.println("Enter valid case only.!!");

		}
	}

}

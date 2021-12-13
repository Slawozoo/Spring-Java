package com.finaltask.corejavafinaltask;

import java.util.Scanner;

import org.springframework.context.annotation.Bean;

import com.finaltask.corejavafinaltask.dao.IArticleDao;
import com.finaltask.corejavafinaltask.dao.IArticleOperations;
import com.finaltask.corejavafinaltask.dao.IAuthorDAO;
import com.finaltask.corejavafinaltask.dao.impl.ArticleDaoImpl;
import com.finaltask.corejavafinaltask.dao.impl.ArticleOperationsImpl;
import com.finaltask.corejavafinaltask.dao.impl.AuthorDAOImpl;

public class PublicationApp {
	
	DownloadFile downloadFile;
	IArticleDao articleDao;
	IAuthorDAO authorDao;
	IArticleOperations articleOperations;
	
	public PublicationApp() {}
	
	public PublicationApp(DownloadFile downloadFile, IArticleDao articleDao, IAuthorDAO authorDao,
			IArticleOperations articleOperations) {
		this.downloadFile = downloadFile;
		this.articleDao = articleDao;
		this.authorDao = authorDao;
		this.articleOperations = articleOperations;
	}
	
	public int getMenuChoice() {
		Scanner scn = new Scanner(System.in);	
		System.out.println("Enter the case you want to perform: ");
		
		System.out.println("1. Download File from URL");
		System.out.println("2. Read Download File and store in Database");
		System.out.println("3. Display data stored in the database table");
		System.out.println("4. Article details from user and Insert in database");
		System.out.println("5. Search and export Article from database using article title");
		System.out.println("6. Search and export Article from database using author email");
		System.out.println("7. Delete Article form the database using article title");
		System.out.println("8. Delete Article from the database written by an author");
		System.out.println("9. Export All data from database into a file");
		
		int switchCase = scn.nextInt();
		
		return switchCase;
	}
}

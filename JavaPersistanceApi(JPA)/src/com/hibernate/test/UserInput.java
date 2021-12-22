package com.hibernate.test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.hibernate.model.Article;
import com.hibernate.model.Author;

public class UserInput {
	public Article getArticleFromUser() {
		Article article = new Article();
		Scanner scn = new Scanner(System.in);

		System.out.print("Enter title of article: ");
		article.setTitle(scn.next());
		System.out.print("Enter published date: ");
		article.setPublishedDate(scn.nextLine());
		//Date formatter
		LocalDateTime myDateObj = LocalDateTime.now();   
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MMM-yyyy");  
	    String formattedDate = myDateObj.format(myFormatObj);
		article.setPublishedDate(formattedDate);
	    
		System.out.print("No. of author in the article: ");
		int n = scn.nextInt();
		List<Author> authorLists = new ArrayList<Author>();
		for (int i = 0; i < n; i++) {
			Author author = new Author();
			System.out.print("Enter first name of author: ");
			author.setFirstName(scn.next());
			System.out.print("Enter last name of author: ");
			author.setLastName(scn.next());
			System.out.print("Enter email of author: ");
			author.setEmail(scn.next());
			System.out.print("Enter address of author: ");
			author.setAddress(scn.next());
			System.out.print("Enter institution of author: ");
			author.setInstitution(scn.next());
			
			authorLists.add(author);	
		}
		article.setAuthorList(authorLists);
		
		return article;
	}

	public void getArticleFromUserForUpdate(Article article) {
		Scanner scn = new Scanner(System.in);
		System.out.print("Title: ");
		article.setTitle(scn.next());
		System.out.println("Published Date:");
		article.setPublishedDate(scn.next());
		List<Author> authorList = article.getAuthorList();
		for(Author author: authorList) {
			System.out.print("First Name: ");
			author.setFirstName(scn.next());
			System.out.print("Last Name: ");
			author.setLastName(scn.next());
			System.out.print("Address: ");
			author.setAddress(scn.next());
			System.out.print("Institution: ");
			author.setInstitution(scn.next());
			System.out.print("Email: ");
			author.setEmail(scn.next());
		}
		article.setAuthorList(authorList);
		
	}
}

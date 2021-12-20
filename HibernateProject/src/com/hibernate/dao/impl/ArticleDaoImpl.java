package com.hibernate.dao.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.dao.IArticleDao;
import com.hibernate.model.Article;
import com.hibernate.model.Author;

public class ArticleDaoImpl implements IArticleDao{

	@Override
	public Article setArticleAuthor() {
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

	@Override
	public void insertArticleAuthor(SessionFactory sessionFactory) {
		Article article = setArticleAuthor();
		//For create table and insert into table
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		//Insert into DB using cascade
//		session.persist(article);
		for(Author author: article.getAuthorList()) {
			author.setArticle(article);
		}
		
		session.persist(article);
		
//		//Insert into DB using lists
//		session.save(article);
//		System.out.println("Size of authorList: "+article.getAuthorList().size());
//		for(int i =0 ;i < article.getAuthorList().size();i++) {
//			Author author = article.getAuthorList().get(i);
//			author.setArticle(article);
//			session.save(author);
//		}
		
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void retrieveArticleAuthor(SessionFactory sessionFactory) {
		Session session = sessionFactory.openSession();
		Scanner scn = new Scanner(System.in);
		session.beginTransaction();
		Transaction tx = null;
		
		tx = session.beginTransaction();
		List<Article> articleList = session.createQuery("from Article").list();
		for(int i = 0; i< articleList.size(); i++) {
			System.out.println("Article ID: "+articleList.get(i).getId()+" Title: "+articleList.get(i).getTitle()+
					" Published Date: "+articleList.get(i).getPublishedDate());
		}
		
		System.out.println("Enter the id of article to search from the above list: ");
		int id = scn.nextInt();
		
		Article article = (Article) session.get(Article.class, id);
		System.out.println("Article: ");
		System.out.println("ID: "+article.getId()+" Title: "+article.getTitle()+" Published Date: "+article.getPublishedDate());
		for(Author author: article.getAuthorList()) {
		System.out.println("Authors : "+author.getFirstName()+" "+author.getLastName()+
				" "+author.getAddress()+" "+author.getInstitution()+" "+author.getEmail());
		}
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void updateArticleAuthor(SessionFactory sessionFactory) {
		Transaction transaction = null;
		Session session = sessionFactory.openSession();
		Scanner scn = new Scanner(System.in);
		// Start a transaction
        transaction = session.beginTransaction();
        
		List<Article> articleList = session.createQuery("from Article").list();
		for(int i = 0; i< articleList.size(); i++) {
			System.out.println("Article ID: "+articleList.get(i).getId()+" Title: "+articleList.get(i).getTitle()+
					" Published Date: "+articleList.get(i).getPublishedDate());
		}
		System.out.println("Enter the id of article to update from the above list: ");
		int id = scn.nextInt();
		
		//Update a persistent object
		Query queryArticle = session.createQuery("from Article where id = ?");
		queryArticle.setInteger(0,id);
		Article article = (Article)queryArticle.uniqueResult();
		article.setTitle(scn.next());
		List<Author> authorList = article.getAuthorList();
		for(Author author: authorList) {
			System.out.print("First Name: ");
			author.setFirstName(scn.next());
			System.out.print("Last Name: ");
			author.setLastName(scn.next());
			System.out.println("Address: ");
			author.setAddress(scn.next());
			System.out.println("Institution: ");
			author.setInstitution(scn.next());
			System.out.println("Email: ");
			author.setEmail(scn.next());
		}
		
		article.setAuthorList(authorList);
		
		//We can either use update class or save to update the article
//		session.update(article);
		session.save(article);
		
		session.getTransaction().commit();
		session.close();
		System.out.println("Update sucessfully.!!!");
		
		
	}

	@Override
	public void deleteArticleAuthor(SessionFactory sessionFactory) {
		Transaction transaction = null;
		Session session = sessionFactory.openSession();
		Scanner scn = new Scanner(System.in);
		// Start a transaction
        transaction = session.beginTransaction();
        
		List<Article> articleList = session.createQuery("from Article").list();
		for(int i = 0; i< articleList.size(); i++) {
			System.out.println("Article ID: "+articleList.get(i).getId()+" Title: "+articleList.get(i).getTitle()+
					" Published Date: "+articleList.get(i).getPublishedDate());
		}
		System.out.println("Enter the id of article to delete from the above list: ");
		int id = scn.nextInt();
		
		// Delete a persistent object
		Query queryArticle = session.createQuery("from Article where id = ?");
		queryArticle.setInteger(0,id);
		Article article = (Article)queryArticle.uniqueResult();
		
		//Delete parent and orphan class using cascade
		session.delete(article);
		
		//Delete using setting parameters
//		Query queryAuthor = session.createQuery("from Author where article = :articleName");
//		System.out.println(article.getId()+" "+article.getTitle());
//		queryAuthor.setParameter("articleName", article);
//		List<Author> authorList = (List<Author>) queryAuthor.list();
//		for(Author author: authorList) {
//			session.delete(author);
//		}
//		session.delete(article);
//		System.out.println("Article deleted sucessfully.!!!!!!");
		
		session.getTransaction().commit();
		session.close();
	
		//Another method for delete article its author
//		Query query = session.createQuery("from Article where id = ?");
//		query.setInteger(0, id);
//		List<Article> articleLists = query.list();
//		for(Article art: articleLists) {
//			List<Author> authorList = art.getAuthorList();
//			for(Author author:authorList) {
//				session.delete(author);
//			}
//			session.delete(art);
//		}
            
	}

}

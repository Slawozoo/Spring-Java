package com.hibernate.dao.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.hibernate.Transaction;

import com.hibernate.dao.IArticleDao;
import com.hibernate.model.Article;
import com.hibernate.model.Author;

public class ArticleDaoImpl implements IArticleDao{
	private EntityManagerFactory emFactory ;
	private EntityManager entityManager ;

	public ArticleDaoImpl(EntityManagerFactory emFactory, EntityManager entityManager) {
		this.emFactory = Persistence.createEntityManagerFactory("ArticleAuthor_JPA");
		this.entityManager = this.emFactory.createEntityManager();
	}
	
	public ArticleDaoImpl() {}

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
	public void insertArticleAuthor() {
		Article article = setArticleAuthor();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		for(Author author: article.getAuthorList()) {
			author.setArticle(article);
			entityManager.persist(author);
		}
		entityManager.persist(article);
		entityTransaction.commit();
		entityManager.close();
		emFactory.close();
	}

	@Override
	public void retrieveArticleAuthor() {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Scanner scn = new Scanner(System.in);
		entityTransaction.begin();

		List<Article> articleList = entityManager.createQuery("from Article").getResultList();
		for(int i = 0; i< articleList.size(); i++) {
			System.out.println("Article ID: "+articleList.get(i).getId()+" Title: "+articleList.get(i).getTitle()+
					" Published Date: "+articleList.get(i).getPublishedDate());
		}
		System.out.println("Enter the id of article to search from the above list: ");
		int id = scn.nextInt();
		
		Article article = entityManager.find(Article.class, id);
		System.out.println("Article: ");
		System.out.println("ID: "+article.getId()+" Title: "+article.getTitle()+" Published Date: "+article.getPublishedDate());
		for(Author author: article.getAuthorList()) {
		System.out.println("Authors : "+author.getFirstName()+" "+author.getLastName()+
				" "+author.getAddress()+" "+author.getInstitution()+" "+author.getEmail());
		}
		entityTransaction.commit();
		entityManager.close();
		emFactory.close();
	}

	@Override
	public void updateArticleAuthor() {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Scanner scn = new Scanner(System.in);
		
		List<Article> articleList = entityManager.createQuery("from Article").getResultList();
		for(int i = 0; i< articleList.size(); i++) {
			System.out.println("Article ID: "+articleList.get(i).getId()+" Title: "+articleList.get(i).getTitle()+
					" Published Date: "+articleList.get(i).getPublishedDate());
		}
		entityTransaction.begin();
		System.out.println("Enter the id of article to update from the above list: ");
		int id = scn.nextInt();
		Article article = entityManager.find(Article.class, id);
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

		System.out.println("Article updated sucessfully.!!!");
		entityTransaction.commit();
		entityManager.close();
	}

	@Override
	public void deleteArticleAuthor() {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Scanner scn = new Scanner(System.in);
		
		List<Article> articleList = entityManager.createQuery("from Article").getResultList();
		for(int i = 0; i< articleList.size(); i++) {
			System.out.println("Article ID: "+articleList.get(i).getId()+" Title: "+articleList.get(i).getTitle()+
					" Published Date: "+articleList.get(i).getPublishedDate());
		}
		entityTransaction.begin();
		System.out.println("Enter the id of article to delete from the above list: ");
		int id = scn.nextInt();
		Article article = entityManager.find(Article.class, id);
		for(Author author: article.getAuthorList()) {
			entityManager.remove(author);
		}
		entityManager.remove(article);
		System.out.println("Article Deleted sucessfully.!!!");
		entityTransaction.commit();
		entityManager.close();  
	}

	@Override
	public void retrieveArticleAuthorUsingCriteriaApi() {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Article> criteriaQuery = criteriaBuilder.createQuery(Article.class);
		Root<Article> rootArticle = criteriaQuery.from(Article.class);
		CriteriaQuery<Article> select = criteriaQuery.select(rootArticle);
		
		Query query = entityManager.createQuery(select);
		List<Article> articleList = query.getResultList();
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

	@Override
	public void updateArticleAuthorUsingCriteriaApi() {
//		EntityTransaction entityTransaction = entityManager.getTransaction();
//		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//		Scanner scn = new Scanner(System.in);
//		
//		List<Article> articleList = entityManager.createQuery("from Article").getResultList();
//		for(int i = 0; i< articleList.size(); i++) {
//			System.out.println("Article ID: "+articleList.get(i).getId()+" Title: "+articleList.get(i).getTitle()+
//					" Published Date: "+articleList.get(i).getPublishedDate());
//		}
//		
//        // create update
//		entityTransaction.begin();
//		System.out.println("Enter article id to update author: ");
//		int id = scn.nextInt();
//		CriteriaUpdate<Article> update = cb.createCriteriaUpdate(Article.class);
//		CriteriaUpdate<Author> updateAuthor = cb.createCriteriaUpdate(Author.class);
// 
//		//just added
//		CriteriaQuery<Article> criteriaQuery = cb.createQuery(Article.class);
//		Root<Article> rootArticles = criteriaQuery.from(Article.class);
//		CriteriaQuery<Article> select = criteriaQuery.select(rootArticles);
//		
//		Query query = entityManager.createQuery(select.where(cb.equal(rootArticles.get("id"), id)));
//		Article article = (Article) query.getSingleResult();
//		System.out.println(article.getAuthorList().size());
//		
//        // set the root class
//        Root rootArticle = update.from(Article.class);
////        Root rootAuthor = updateAuthor.from(Author.class);
//// 
////        // set update and where clause
//        System.out.print("Title: ");
//        String title = scn.next();
//        System.out.println("Published Date: ");
//        String publishedDate = scn.next();
//        System.out.println("enter size of author list: ");
//        int listSize = scn.nextInt();
//        List<Author> authorList = new ArrayList<Author>();
//        for(int i =0; i< listSize; i++) {
//        	Author author = new Author();
//        	System.out.print("First Name: ");
//    		String firstName = scn.next();
//    		System.out.print("Last Name: ");
//    		String lastName = scn.next();
//    		System.out.print("Address: ");
//    		String address = scn.next();
//    		System.out.print("Email: ");
//    		String email = scn.next();
//    		System.out.print("Institution: ");
//    		String institution = scn.next();
//    		
//    		author.setFirstName(firstName);
//    		author.setLastName(lastName);
//    		author.setAddress(address);
//    		author.setInstitution(institution);
//    		author.setEmail(email);
//    		
//    		authorList.add(author);
//        }
//        article.setAuthorList(authorList);
//        article.setTitle(title);
//        article.setPublishedDate(publishedDate);
//        
//		update.set("title", title);
//		update.set("publishedDate", publishedDate);
//		update.set("authorList", authorList);
////		update.
//		
//
////		updateAuthor.set("firstName", firstName);
////      updateAuthor.set("lastName", lastName);
////      updateAuthor.set("address", address);
////      updateAuthor.set("institution", institution);
////      updateAuthor.set("email", email);
//		
//		
//        update.where(cb.equal(rootArticle.get("authorList"), authorList));
////        updateAuthor.where(cb.equal(rootAuthor.get("article"), id));
//        update.where(cb.equal(rootArticle.get("id"), id));
// 
//        // perform update
////        entityManager.createQuery(updateAuthor).executeUpdate();
//        entityManager.createQuery(update).executeUpdate();
//        entityTransaction.commit();
//        System.out.println("Update sucessful.!!!");
//		
	}

	@Override
	public void deleteArticleAuthorUsingCriteriaApi() {
		
		
	}

}

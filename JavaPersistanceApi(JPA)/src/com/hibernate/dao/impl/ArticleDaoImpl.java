package com.hibernate.dao.impl;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.hibernate.dao.IArticleDao;
import com.hibernate.model.Article;
import com.hibernate.model.Author;
import com.hibernate.test.UserInput;

public class ArticleDaoImpl implements IArticleDao{
	private EntityManagerFactory emFactory ;
	private EntityManager entityManager ;

	public ArticleDaoImpl(EntityManagerFactory emFactory, EntityManager entityManager) {
		this.emFactory = Persistence.createEntityManagerFactory("ArticleAuthor_JPA");
		this.entityManager = this.emFactory.createEntityManager();
	}
	
	public ArticleDaoImpl() {}

	@Override
	public void insertArticleAuthor(Article article) {
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
	public Article retrieveArticleAuthor() {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Scanner scn = new Scanner(System.in);
		entityTransaction.begin();

		List<Article> articleList = retrieveAllArticle();
		System.out.println("Enter the id of article to search from the above list: ");
		int id = scn.nextInt();
		Article article = entityManager.find(Article.class, id);
		entityTransaction.commit();
		entityManager.close();
		emFactory.close();
		
		return article;
	}

	@Override
	public void updateArticleAuthor() {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Scanner scn = new Scanner(System.in);
		
		List<Article> articleList = retrieveAllArticle();
		entityTransaction.begin();
		
		System.out.println("Enter the id of article to update from the above list: ");
		int id = scn.nextInt();
		Article article = entityManager.find(Article.class, id);
		UserInput userInput = new UserInput();
		userInput.getArticleFromUserForUpdate(article);

		entityTransaction.commit();
		System.out.println("Article updated sucessfully.!!!");
		entityManager.close();
	}

	@Override
	public void deleteArticleAuthor() {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Scanner scn = new Scanner(System.in);
		
		List<Article> articleList = retrieveAllArticle();
		entityTransaction.begin();
		System.out.println("Enter the id of article to delete from the above list: ");
		int id = scn.nextInt();
		Article article = entityManager.find(Article.class, id);
		for(Author author: article.getAuthorList()) {
			entityManager.remove(author);
		}
		entityManager.remove(article);
		
		entityTransaction.commit();
		System.out.println("Article Deleted sucessfully.!!!");
		entityManager.close();  
	}

	@Override
	public List<Article> retrieveArticleAuthorUsingCriteriaApi() {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Article> criteriaQuery = criteriaBuilder.createQuery(Article.class);
		Root<Article> rootArticle = criteriaQuery.from(Article.class);
		CriteriaQuery<Article> select = criteriaQuery.select(rootArticle);
		
		Query query = entityManager.createQuery(select);
		List<Article> articleList = query.getResultList();
		return articleList;
	}

	@Override
	public void updateArticleAuthorUsingCriteriaApi() {
		//Todo generate code
	}

	@Override
	public void deleteArticleAuthorUsingCriteriaApi() {
		//Todo generate code
		
	}

	@Override
	public List<Article> retrieveAllArticle() {
		List<Article> articleList = entityManager.createQuery("from Article").getResultList();
		for(int i = 0; i< articleList.size(); i++) {
			System.out.println("Article ID: "+articleList.get(i).getId()+" Title: "+articleList.get(i).getTitle()+
					" Published Date: "+articleList.get(i).getPublishedDate());
		}
		return articleList;
	}

}

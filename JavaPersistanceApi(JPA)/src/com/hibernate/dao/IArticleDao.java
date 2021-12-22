package com.hibernate.dao;

import java.util.List;

import com.hibernate.model.Article;

public interface IArticleDao {

	/**
	 * Create DB and insert into Article and Author table
	 */
	public void insertArticleAuthor(Article article);

	/**
	 * Retrieve Article and Author from DB
	 */
	public Article retrieveArticleAuthor();

	/**
	 * Update Article and author from DB
	 */
	public void updateArticleAuthor();

	/**
	 * Delete Article and Author from db
	 */
	public void deleteArticleAuthor();
	
	/**
	 * Retrieve Article and Author from DB
	 */
	public List<Article> retrieveArticleAuthorUsingCriteriaApi();

	/**
	 * Update Article and author from DB
	 */
	public void updateArticleAuthorUsingCriteriaApi();

	/**
	 * Delete Article and Author from db
	 */
	public void deleteArticleAuthorUsingCriteriaApi();
	
	/**
	 * Retrieve all Article
	 */
	public List<Article> retrieveAllArticle();
	
}

package com.hibernate.dao;

import com.hibernate.model.Article;

public interface IArticleDao {

	/**
	 * Takes user input from user
	 */
	public Article setArticleAuthor();

	/**
	 * Create DB and insert into Article and Author table
	 */
	public void insertArticleAuthor();

	/**
	 * Retrieve Article and Author from DB
	 */
	public void retrieveArticleAuthor();

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
	public void retrieveArticleAuthorUsingCriteriaApi();

	/**
	 * Update Article and author from DB
	 */
	public void updateArticleAuthorUsingCriteriaApi();

	/**
	 * Delete Article and Author from db
	 */
	public void deleteArticleAuthorUsingCriteriaApi();
	
}

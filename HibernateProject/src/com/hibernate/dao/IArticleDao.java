package com.hibernate.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.hibernate.model.Article;

public interface IArticleDao {

	/**
	 * Takes user input from user
	 */
	public Article setArticleAuthor();

	/**
	 * Create DB and insert into Article and Author table
	 */
	public void insertArticleAuthor(SessionFactory sessionFactory);

	/**
	 * Retrieve Article and Author from DB
	 */
	public void retrieveArticleAuthor(SessionFactory sessionFactory);

	/**
	 * Update Article and author from DB
	 */
	public void updateArticleAuthor(SessionFactory sessionFactory);

	/**
	 * Delete Article and Author from db
	 */
	public void deleteArticleAuthor(SessionFactory sessionFactory);
	
}

package com.jpa.dao;

import javax.persistence.EntityManager;

import com.jpa.model.Authors;

public interface IAuthorDao {

	/**
	 * Takes user input from user
	 */
	public Authors setAuthor();

	/**
	 * Create DB and insert into Author table
	 */
	public void insertAuthor(EntityManager entityManager);

	/**
	 * Retrieve Author from DB
	 */
	public void retrieveAuthor(EntityManager entityManager);

	/**
	 * Update author from DB
	 */
	public void updateAuthor(EntityManager entityManager);

	/**
	 * Delete Author from db
	 */
	public void deleteAuthor(EntityManager entityManager);

	/**
	 * Retrieve Author from DB using JPQL
	 */
	public void retrieveAuthorName(EntityManager entityManager);

	/**
	 * Update author from DB
	 */
	public void updateAuthorName(EntityManager entityManager);

	/**
	 * Delete Author from db
	 */
	public void deleteAuthorUsingId(EntityManager entityManager);

	/**
	 * Retrieve Author from DB using Criteria API
	 */
	public void retrieveAuthorUsingCriteriaApi(EntityManager entityManager);

	/**
	 * Update author from DB using Criteria API
	 */
	public void updateAuthorNameUsingCriteriaApi(EntityManager entityManager);

	/**
	 * Delete Author from db using Criteria API
	 */
	public void deleteAuthorUsingCriteriaApi(EntityManager entityManager);

}

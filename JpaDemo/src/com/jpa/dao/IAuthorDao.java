package com.jpa.dao;

import java.util.List;

import com.jpa.model.Authors;

public interface IAuthorDao {

	/**
	 * Create DB and insert into Author table
	 */
	public void insertAuthor(Authors author);

	/**
	 * Retrieve Author from DB
	 */
	public Authors retrieveAuthor();

	/**
	 * Update author from DB
	 */
	public void updateAuthor();

	/**
	 * Delete Author from db
	 */
	public void deleteAuthor();

	/**
	 * Retrieve Author from DB using JPQL
	 */
	public List<Object[]> retrieveAuthorName();

	/**
	 * Update author from DB
	 */
	public void updateAuthorName();

	/**
	 * Delete Author from db
	 */
	public void deleteAuthorUsingId();

	/**
	 * Retrieve Author from DB using Criteria API
	 */
	public List<Authors> retrieveAuthorUsingCriteriaApi();

	/**
	 * Update author from DB using Criteria API
	 */
	public void updateAuthorNameUsingCriteriaApi();

	/**
	 * Delete Author from db using Criteria API
	 */
	public void deleteAuthorUsingCriteriaApi();

}

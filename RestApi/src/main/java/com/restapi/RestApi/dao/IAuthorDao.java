package com.restapi.RestApi.dao;

import java.util.List;

import com.restapi.RestApi.model.Authors;


public interface IAuthorDao {

	/**
	 * Method to retrieve List of Authors from Authors table
	 */
	public List<Authors> getAuthor();
	 /**
	 * Method to retrieve Author from Authors table using authorId
	 */
	public Authors getAuthor(int authorId);
	 /**
	 * Method to delete author from DB using authorId
	 */
	public int deleteAuthor(int authorId); 
	 /**
	 * Method to update author from DB using authorId
	 */
	public int updateAuthor(Authors author);
	 /**
	 * Method to create and insert into Authors table
	 */
	public int createAuthor(Authors author);
}

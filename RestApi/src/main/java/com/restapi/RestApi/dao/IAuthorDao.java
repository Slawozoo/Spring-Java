package com.restapi.RestApi.dao;

import java.util.List;

import com.restapi.RestApi.model.Users;


public interface IAuthorDao {

	/**
	 * Method to retrieve List of Authors from Authors table
	 */
	public List<Users> getAuthor();
	 /**
	 * Method to retrieve Author from Authors table using authorId
	 */
	public Users getAuthorById(int authorId);
	 /**
	 * Method to delete author from DB using authorId
	 */
	public int deleteAuthorById(int authorId); 
	 /**
	 * Method to update author from DB using authorId
	 */
	public int updateAuthor(Users author);
	 /**
	 * Method to create and insert into Authors table
	 */
	public int createAuthor(Users author);
}

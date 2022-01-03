package com.mavenmvc.MavenWebProject.dao;

import java.util.List;

import com.mavenmvc.MavenWebProject.model.Authors;


public interface IAuthorDao {

	/**
	 * Method to retrieve List of Authors from Authors table
	 */
	public List<Authors> getAuthor();
	 /**
	 * Method to retrieve Author from Authors table using authorId
	 */
	public Authors getAuthorById(int authorId);
	 /**
	 * Method to delete author from DB using authorId
	 */
	public int deleteAuthorById(int authorId); 
	 /**
	 * Method to update author from DB using authorId
	 */
	public int updateAuthor(Authors author);
	 /**
	 * Method to create and insert into Authors table
	 */
	public int createAuthor(Authors author);
}

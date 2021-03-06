package com.mavenmvc.MavenWebProject.service;

import java.util.List;

import com.mavenmvc.MavenWebProject.model.Authors;


public interface IAuthorService {

	/**
	 * Service method for getting list of authors using this method from AuthorDaoImpl class
	 */
	public List<Authors> getAuthor();
	 /**
	 * Service methods that returns author using authorId from AuthorDaoImpl class
	 */
	public Authors getAuthorById(int authorId);
	 /**
	 * Service methods that Delete author using authorId AuthorDaoImpl class
	 */
	public int deleteAuthorById(int authorId); 
	 /**
	 * Service method for updating author
	 */
	public int updateAuthor(Authors author);
	 /**
	 * Service method for creating and inserting into authors table
	 */
	public int createAuthor(Authors author); 	
	
}

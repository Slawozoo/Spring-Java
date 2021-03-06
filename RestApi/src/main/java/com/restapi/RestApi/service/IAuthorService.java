package com.restapi.RestApi.service;

import java.util.List;

import com.restapi.RestApi.model.Users;


public interface IAuthorService {

	/**
	 * Service method for getting list of authors using this method from AuthorDaoImpl class
	 */
	public List<Users> getAuthor();
	 /**
	 * Service methods that returns author using authorId from AuthorDaoImpl class
	 */
	public Users getAuthorById(int authorId);
	 /**
	 * Service methods that Delete author using authorId AuthorDaoImpl class
	 */
	public int deleteAuthorById(int authorId); 
	 /**
	 * Service method for updating author
	 */
	public int updateAuthor(Users author);
	 /**
	 * Service method for creating and inserting into authors table
	 */
	public int createAuthor(Users author); }

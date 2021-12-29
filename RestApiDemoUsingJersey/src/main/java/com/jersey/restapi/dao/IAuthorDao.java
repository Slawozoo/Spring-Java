package com.jersey.restapi.dao;

import java.util.List;

import com.jersey.restapi.model.Author;


public interface IAuthorDao {

	public List<Author> getAuthor();
	 public Author getAuthor(Long authorId);
	 public int deleteAuthor(Long authorId); 
	 public int updateAuthor(Author author);
	 public Author createAuthor(Author author);
}

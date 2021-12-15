package com.finaltask.corejavafinaltask.dao;

import java.sql.Connection;
import java.util.List;

import org.json.simple.JSONArray;

import com.finaltask.corejavafinaltask.domain.*;
public interface IAuthorDAO {

	/**
	 * Create Author table
	 */
	public void createAuthorTable();
	
	/**
	 * Read from file and insert into DB  author table
	 */
	public void insertAuthorTable(List<Author> authorList, String titleSearch);
	
	/**
	 * Retrieve from author table
	 */
	public List<Author> retrieveAuthorTable();
	
	/**
	 * User input and insert into Author table
	 */
	public void insertAuthorTableSql(List<Author> authorList,Article article);
	
	/**
	 * Retrieve author by Article title
	 */
	public Author retrieveAuthorTableByTitle(int id);
	
	/**
	 *Delete Author using article title
	 */
	public void deleteAuthorByTitle(int id);
	
	/**
	 * Generate Author List from Author table
	 */
	public List<Author> generateAuthorList(int id);
	
	/**
	 * Write Author list into Json Array
	 */
	public JSONArray writeJsonAuthor(List<Author> authorList);
	
	/**
	 * Returns article id from author email
	 */
	public int getArticleIdUsingEmail(String email);
}
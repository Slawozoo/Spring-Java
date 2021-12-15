package com.finaltask.corejavafinaltask.dao;

import java.sql.Connection;
import java.util.List;

import com.finaltask.corejavafinaltask.domain.*;

public interface IArticleDao {

	/**
	 * Create Article table in DB
	 */
	public void createArticleTableSql();
	
	/**
	 * Insert into article table from file
	 */
	public void insertIntoTable(List<Article> articleList);
	
	/**
	 * Returns article ID using article title
	 */
	public int selectIDConditionTitle(String titleSearch);
	
	/**
	 * Retrieve Article Table
	 */
	public List<Article> retrieveArticleTable();
	
	/**
	 * Insert into Article table from user input
	 */
	public void insertIntoTable();

	/**
	 * Search and extract using Article title
	 */
	public Article retrieveArticleByTitle();
	
	/**
	 * Search and extract using Author detail
	 */
	public void retrieveArticleByAuthorEmail();

	/**
	 * Delete article using article title
	 */
	public void deleteArticleByTitle();
	
	/**
	 * Delete article by author detail
	 */
	public void deleteArticleByAuthorEmail();
	
	/**
	 * Converting DB table into List<Article>
	 */
	public List<Article> generateArticle();
	
	/**
	 *Write articleList into JsonFile
	 */
	public void writeJsonFile(List<Article> articleList);
}

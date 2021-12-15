package com.finaltask.corejavafinaltask.dao.impl;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.sql.DataSource;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.jdbc.core.JdbcTemplate;

import com.finaltask.corejavafinaltask.dao.IArticleDao;
import com.finaltask.corejavafinaltask.domain.Article;
import com.finaltask.corejavafinaltask.domain.Author;
import com.finaltask.corejavafinaltask.jdbc.ArticleMapper;
import com.finaltask.corejavafinaltask.jdbc.SqlCommands;

public class ArticleDaoImpl implements IArticleDao {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	private AuthorDAOImpl authorDao;

	public ArticleDaoImpl() {}
	//This is the method to be used to initialize database resources ie. connection.
	public ArticleDaoImpl(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(this.dataSource);
		this.authorDao = new AuthorDAOImpl(dataSource);
		
	}

	/**
	 *Create article table
	 */
	public void createArticleTableSql() {
		jdbcTemplateObject.update(SqlCommands.getCreateArticleTableSql());
	}

	/**
	 *Insert into article table by reading a file
	 */
	public void insertIntoTable(List<Article> articleList) {
		System.out.println(articleList);
		for(int i = 0; i < articleList.size(); i++) {
			jdbcTemplateObject.update(SqlCommands.getInsertIntoArticleTableSql(), articleList.get(i).getTitle(), articleList.get(i).getPublishedDate());
			
			authorDao.insertAuthorTable(articleList.get(i).getAuthorList(), articleList.get(i).getTitle());
		}
	}

	/**
	 * returns Id of article using article title
	 */
	public int selectIDConditionTitle(String titleSearch) {

		 List<Integer> idList = jdbcTemplateObject.queryForList(SqlCommands.getSelectIdSql(), 
				 new Object[] {titleSearch}, Integer.class);
		Collections.sort(idList);
		 
		 return idList.get(idList.size()-1);

	}

	/**
	 *Retrieve Article table
	 */
	public List<Article> retrieveArticleTable() {
		List<Article> articleList = jdbcTemplateObject.query(SqlCommands.getRetrieveAllArticle(), 
				new ArticleMapper());
		
		Iterator itr = articleList.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
			System.out.println("\n");
		}
//		AuthorDAOImpl authorDao = new AuthorDAOImpl(dataSource);
		authorDao.retrieveAuthorTable();
		return articleList;
	}

	/**
	 *Insert into table by userinput
	 */
	public void insertIntoTable() {
		Article article = new Article();
		List<Author> authorList = new ArrayList<Author>();
		Scanner scn = new Scanner(System.in);

		System.out.print("Enter title of article: ");
		article.setTitle(scn.next());
		System.out.print("Enter published date: ");
		article.setPublishedDate(scn.nextLine());
		//article.setPublishedDate("15/10/2019");
		System.out.print("No. of author in the article: ");
		int n = scn.nextInt();
		List<Author> authorLists = new ArrayList<Author>();
		for (int i = 0; i < n; i++) {
			Author author = new Author();
			System.out.print("Enter first name of author: ");
			author.setfName(scn.next());
			System.out.print("Enter last name of author: ");
			author.setlName(scn.next());
			System.out.print("Enter email of author: ");
			author.setEmail(scn.next());
			System.out.print("Enter address of author: ");
			author.setAddress(scn.next());
			System.out.print("Enter institution of author: ");
			author.setInstitution(scn.next());
			authorList.add(author);
		}
		article.setAuthorList(authorList);
		
		jdbcTemplateObject.update(SqlCommands.getInsertIntoArticleTableSql(), article.getTitle(), article.getPublishedDate());

			// Insert into author table
			
			authorDao.insertAuthorTableSql(authorList, article);
			System.out.println("Data inserted sucessfully.!!!");
	}

	/**
	 *Retrieve Article table by article title
	 */
	public Article retrieveArticleByTitle() {

			Scanner scn = new Scanner(System.in);
			System.out.print("Enter the title of article to be searched: ");
			String titleSearch = scn.next();
			
			Article article = jdbcTemplateObject.queryForObject(SqlCommands.getRetrieveArticleByTitle(), new Object[]{titleSearch}, 
					new ArticleMapper());

			System.out.println("Title: "+article.getTitle());
			System.out.println("Published Date: "+article.getPublishedDate());
			authorDao.generateAuthorList(article.getId());

		return article;
	}
	
	/**
	 *Retrieve article using author email
	 */
	public void retrieveArticleByAuthorEmail() {
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter the email of author to be searched: ");
		String emailSearch = scn.next();
		int article_id = authorDao.getArticleIdUsingEmail(emailSearch);		
		
		Article article = jdbcTemplateObject.queryForObject(SqlCommands.getRetrieveArticleById(), new Object[]{article_id}, 
				new ArticleMapper());

		System.out.println("Title: "+article.getTitle());
		System.out.println("Published Date: "+article.getPublishedDate());
		authorDao.generateAuthorList(article.getId());
		
	}

	/**
	 *Delete Article by using article title
	 */
	public void deleteArticleByTitle() {
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter the title of article to be searched: ");
		String titleSearch = scn.next();
		Article article = jdbcTemplateObject.queryForObject(SqlCommands.getRetrieveArticleByTitle(),new Object[]{titleSearch}, 
				new ArticleMapper());
		int articleId = selectIDConditionTitle(titleSearch);
		authorDao.deleteAuthorByTitle(articleId);
		jdbcTemplateObject.update(SqlCommands.getDeleteArticleById(), articleId);
		System.out.println("Article deleted sucessfully.!!!!");
	}

	/**
	 *Delete article using author email
	 */
	public void deleteArticleByAuthorEmail() {
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter the email of author to be searched: ");
		String emailSearch = scn.next();
		int articleId = authorDao.getArticleIdUsingEmail(emailSearch);
		authorDao.deleteAuthorByTitle(articleId);
		jdbcTemplateObject.update(SqlCommands.getDeleteArticleById(), articleId);
		System.out.println("Article deleted sucessfully.!!!!");
	}

	/**
	 *Write JSON file from article list
	 */
	public void writeJsonFile(List<Article> articleList) {
//		//Writing no of articles in json file
		JSONArray jsonArticle = new JSONArray();
		for (int i = 0; i < articleList.size(); i++) {
			JSONObject jsonArticleObject = new JSONObject();
			// Inserting key-value pairs into the json object
			jsonArticleObject.put("Title", articleList.get(i).getTitle());
			jsonArticleObject.put("Published Date", articleList.get(i).getPublishedDate().toString());
					
			List<Author> authorLists= articleList.get(i).getAuthorList();
			AuthorDAOImpl authorDao = new AuthorDAOImpl();
			JSONArray jsonAuthor = authorDao.writeJsonAuthor(authorLists);
			jsonArticleObject.put("Authors", jsonAuthor);
			
			jsonArticle.add(jsonArticleObject);	//adding articleObject to jsonArticle array list
			}
				
		JSONObject articleObject = new JSONObject();
		articleObject.put("Article", jsonArticle);

		try {
			FileWriter file1 = new FileWriter("AutherFile.json");
			file1.write(articleObject.toJSONString());
			file1.close();
					
			//Print file in console
			// System.out.println(jsonObject);
			} 
		catch (IOException e) {
			e.printStackTrace();
			}
		System.out.println("JSON file created: \n" + jsonArticle);
	}

	/**
	 *Generate Article list from Article Table
	 */
	public List<Article> generateArticle() {
		List<Article> articleList = jdbcTemplateObject.query(SqlCommands.getRetrieveAllArticle(), new ArticleMapper());
		for(int i = 0; i< articleList.size(); i++) {
			Article article = new Article();
			String title = articleList.get(i).getTitle();
			article.setTitle(title);
			String publishedDate = articleList.get(i).getPublishedDate();
			article.setPublishedDate(publishedDate);
			int articleId = selectIDConditionTitle(title);
			List<Author> authorList = authorDao.generateAuthorList(articleId);
			article.setAuthorList(authorList);
			
			articleList.add(article);
		}
		return articleList;
	}
}

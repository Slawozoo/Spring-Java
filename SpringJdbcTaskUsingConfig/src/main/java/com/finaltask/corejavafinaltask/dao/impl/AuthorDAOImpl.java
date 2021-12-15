package com.finaltask.corejavafinaltask.dao.impl;

import java.util.Iterator;
import java.util.List;

import javax.sql.DataSource;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.jdbc.core.JdbcTemplate;

import com.finaltask.corejavafinaltask.dao.IAuthorDAO;
import com.finaltask.corejavafinaltask.domain.Article;
import com.finaltask.corejavafinaltask.domain.Author;
import com.finaltask.corejavafinaltask.jdbc.AuthorMapper;
import com.finaltask.corejavafinaltask.jdbc.SqlCommands;

public class AuthorDAOImpl implements IAuthorDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	public AuthorDAOImpl(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(this.dataSource);
	}
	
	public AuthorDAOImpl(){}
	/**
	 *Create Author table
	 */
	public void createAuthorTable() {
		jdbcTemplateObject.update(SqlCommands.getCreateAuthorTableSql());
		System.out.println("Created authors table sucessfully!!!");
	}
	/**
	 * Read from file and insert into DB  author table
	 */
	public void insertAuthorTable(List<Author> authorList, String titleSearch) {
		ArticleDaoImpl articleDao = new ArticleDaoImpl(dataSource);
		int articleId = articleDao.selectIDConditionTitle(titleSearch);
		for (int i = 0; i < authorList.size(); i++) {
			jdbcTemplateObject.update(SqlCommands.getInsertIntoAuthorTableSql(), authorList.get(i).getfName(), authorList.get(i).getlName() ,authorList.get(i).getAddress() , 
					authorList.get(i).getInstitution(), authorList.get(i).getEmail() , articleId);
		}
		System.out.println("Author Inserted sucessfully");
	}

	/**
	 *Retrieve from author table
	 */
	public List<Author> retrieveAuthorTable() {
		 List <Author> authors = jdbcTemplateObject.query(SqlCommands.getRetrieveAllAuthor(), new AuthorMapper());
		 Iterator iter = authors.iterator();
		 while(iter.hasNext()) {
			 System.out.println(iter.next());
		 }
		
			 return authors;
	}

	/**
	 *User input and insert into Author table
	 */
	public void insertAuthorTableSql( List<Author> authorList, Article article) {
		ArticleDaoImpl articleDao = new ArticleDaoImpl(dataSource);
		int articleId = articleDao.selectIDConditionTitle(article.getTitle());
		for(int i =0; i< authorList.size();i++) {
			
			jdbcTemplateObject.update(SqlCommands.getInsertIntoAuthorTableSql(), authorList.get(i).getfName(),
					authorList.get(i).getlName(), authorList.get(i).getAddress(), authorList.get(i).getInstitution(),
					authorList.get(i).getEmail(), articleId);
		}
		
	}

	/**
	 *Retrieve author by Article title
	 */
	public Author retrieveAuthorTableByTitle(int id) {
		Author author = jdbcTemplateObject.queryForObject(SqlCommands.getRetrieveAuthorById(), 
				new Object[]{id}, new AuthorMapper());
		return author;
	}

	/**
	 *Delete Author using article title
	 */
	public void deleteAuthorByTitle(int articleId) {
		 jdbcTemplateObject.update(SqlCommands.getDeleteAuthorById(), articleId);
		 
	}

	/**
	 *Generate Author List from Author table
	 */
	public List<Author> generateAuthorList(int article_id) {
		List <Author> authorList = jdbcTemplateObject.query(SqlCommands.getRetrieveAuthorById(),new Object[]{article_id} ,
				new AuthorMapper());
		for(Author authors: authorList) {
			System.out.println("\tFirst Name: "+authors.getfName());
			System.out.println("\tLast Name: "+authors.getlName());
			System.out.println("\tAddress: "+authors.getAddress());
			System.out.println("\tInstitution: "+authors.getInstitution());
			System.out.println("\tEmail: "+authors.getEmail());
			System.out.println("\n");
		}
		return authorList;
	}
	
	/**
	 *Write Author list into Json Array
	 */
	public JSONArray writeJsonAuthor(List<Author> authorList) {
		JSONArray jsonList = new JSONArray();
		// Creating a JSONObject object
		for (int i = 0; i < authorList.size(); i++) {
			JSONObject jsonObject = new JSONObject();
			// Inserting key-value pairs into the json object
			jsonObject.put("FirstName", authorList.get(i).getfName());
			jsonObject.put("LastName", authorList.get(i).getlName());
			jsonObject.put("Address", authorList.get(i).getAddress());
			jsonObject.put("Email", authorList.get(i).getEmail());
			jsonObject.put("Institution", authorList.get(i).getInstitution());
			jsonList.add(jsonObject);
		}
		return jsonList;
	}

	public int getArticleIdUsingEmail(String email) {
		int article_id = jdbcTemplateObject.queryForObject(SqlCommands.getRetrieveAuthorByEmail(), 
				new Object[]{email}, Integer.class);
		return article_id;
	}

	
}

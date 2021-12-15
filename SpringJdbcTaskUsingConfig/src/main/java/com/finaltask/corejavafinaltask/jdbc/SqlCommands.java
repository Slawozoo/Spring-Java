package com.finaltask.corejavafinaltask.jdbc;

public class SqlCommands {

	/**
	 * Create article table
	 */
	private static final String CREATE_ARTICLE_TABLE_SQL = "Create Table Article" + "(id INT  NOT NULL PRIMARY KEY ,"
			+ " title TEXT NOT NULL, " + " published_date TEXT NOT NULL )";

	/**
	 * Create Author table
	 */
	private static final String CREATE_AUTHOR_TABLE_SQL = "CREATE TABLE Author " + "(id INT  NOT NULL PRIMARY KEY ,"
			+ " first_name TEXT NOT NULL, " + " last_name TEXT NOT NULL, " + " address TEXT NOT NULL, "
			+ " institution TEXT NOT NULL, " + " email TEXT NOT NULL," + " article_id INT REFERENCES Article(id) )";

	/**
	 * Insert into article table command
	 */
	private static final String INSERT_INTO_ARTICLE_TABLE_SQL = "INSERT INTO article(title, published_date )"
			+ "VALUES(?,?)";

	/**
	 * Insert into author table command
	 */
	private static final String INSERT_INTO_AUTHOR_TABLE_SQL = "INSERT INTO Author(first_name, last_name, address,  institution, email,article_id)"
			+ "VALUES(?,?,?,?,?,?)";

	/**
	 * Select article Id title from article
	 */
	private static final String SELECT_ID_SQL = "SELECT id FROM article where title = ?";

	/**
	 * Select all from article table
	 */
	private static final String RETRIEVE_ALL_ARTICLE = "SELECT * FROM ARTICLE";

	/**
	 *Select all from author table 
	 */
	private static final String RETRIEVE_ALL_AUTHOR = "SELECT * FROM Author";

	/**
	 * Select article and author using article title
	 */
	private static final String RETRIEVE_ARTICLE_BY_TITLE = "Select * from article where title = ?";

	/**
	 * Select author using articleid
	 */
	private static final String RETRIEVE_AUTHOR_BY_ID = "Select * from author where article_id =?";

	/**
	 * Select author using authoremail
	 */
	private static final String RETRIEVE_AUTHOR_BY_EMAIL = "Select article_id from author where institution = ?";

	/**
	 * Select article using article ID
	 */
	private static final String RETRIEVE_ARTICLE_BY_ID = "Select * from article where id = ?";

	/**
	 * Delete author by article id
	 */
	private static final String DELETE_AUTHOR_BY_ID = "DELETE From author where article_id =?";

	/**
	 * Delete article using article title
	 */
	private static final String DELETE_ARTICLE_BY_TITLE = "Delete from article where title = ?";

	/**
	 * Delete article using article ID
	 */
	private static final String DELETE_ARTICLE_BY_ID = "Delete from article where id = ?";

	public static String getCreateArticleTableSql() {
		return CREATE_ARTICLE_TABLE_SQL;
	}

	public static String getCreateAuthorTableSql() {
		return CREATE_AUTHOR_TABLE_SQL;
	}

	public static String getInsertIntoArticleTableSql() {
		return INSERT_INTO_ARTICLE_TABLE_SQL;
	}

	public static String getInsertIntoAuthorTableSql() {
		return INSERT_INTO_AUTHOR_TABLE_SQL;
	}

	public static String getSelectIdSql() {
		return SELECT_ID_SQL;
	}

	public static String getRetrieveAllArticle() {
		return RETRIEVE_ALL_ARTICLE;
	}

	public static String getRetrieveAllAuthor() {
		return RETRIEVE_ALL_AUTHOR;
	}

	public static String getRetrieveArticleByTitle() {
		return RETRIEVE_ARTICLE_BY_TITLE;
	}

	public static String getRetrieveAuthorById() {
		return RETRIEVE_AUTHOR_BY_ID;
	}

	public static String getRetrieveAuthorByEmail() {
		return RETRIEVE_AUTHOR_BY_EMAIL;
	}

	public static String getRetrieveArticleById() {
		return RETRIEVE_ARTICLE_BY_ID;
	}

	public static String getDeleteAuthorById() {
		return DELETE_AUTHOR_BY_ID;
	}

	public static String getDeleteArticleByTitle() {
		return DELETE_ARTICLE_BY_TITLE;
	}

	public static String getDeleteArticleById() {
		return DELETE_ARTICLE_BY_ID;
	}

	
}

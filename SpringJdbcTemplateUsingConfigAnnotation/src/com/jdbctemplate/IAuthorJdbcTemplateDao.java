package com.jdbctemplate;

import java.util.List;

import javax.sql.DataSource;

public interface IAuthorJdbcTemplateDao {
	/**
	 * This is the method to be used to initialize database resources ie.
	 * connection.
	 */
//  public void setDataSource(DataSource ds);

	/**
	 * This is the method to be used to create authors table
	 */
	public void createAuthorsTable();

	/**
	 * This is the method to be used to insert record in Authors table.
	 */
	public void insertAuthorTable(String fName, String lName, String address, String institution, String email);

	/**
	 * This is the method to be used to list down a record from the Authors table
	 * corresponding to a passed Authors id.
	 */
	public Author getAuthor(int id);

	/**
	 * This is the method to be used to list down all the records from the Authors
	 * table.
	 */
	public List<Author> listAuthors();

	/**
	 * This is the method used to delete record from authors table
	 */
	public void deleteFromAuthor(int id);

	/**
	 * This is the method used to update record of authors
	 */
	public void updateFromAuthor(String fName, String lName, String address, String institution, String email, int id);
}

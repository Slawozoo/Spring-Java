package com.jdbctemplate;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class AuthorJdbcTemplateDaoImpl implements IAuthorJdbcTemplateDao{
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
//	@Override
//	public void setDataSource(DataSource ds) {
//		this.dataSource = ds;
//		this.jdbcTemplateObject = new JdbcTemplate(this.dataSource);
//	}

	//This is the method to be used to initialize database resources ie. connection.
	public AuthorJdbcTemplateDaoImpl(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(this.dataSource);
	}

	@Override
	public List<Author> listAuthors() {
	     List <Author> authors = jdbcTemplateObject.query(SqlCommands.getRetrieveallsql(), new AuthorMapper());
		return authors;
	}

	@Override
	public void insertAuthorTable(String firstName, String lastName, String address, String institution, String email) {
		jdbcTemplateObject.update( SqlCommands.getInsertsql(), firstName, lastName, address, institution, email);
		System.out.println("Record inserted into DB sucessfully!!!!");
		
	}

	@Override
	public void createAuthorsTable() {
		jdbcTemplateObject.update(SqlCommands.getCreatetablesql());
		System.out.println("Created authors table sucessfully!!!");
	}

	@Override
	public Author getAuthor(int id) {
		Author author = jdbcTemplateObject.queryForObject(SqlCommands.getRetrievesql(), 
				new Object[]{id}, new AuthorMapper());
		
		return author;
	}

	@Override
	public void deleteFromAuthor(int id) {
		jdbcTemplateObject.update( SqlCommands.getDeleterecordsql(), id);
		System.out.println("Deleted Record with ID = " + id );
		
	}

	@Override
	public void updateFromAuthor( String fName, String lName, String address, String institution, String email, int id) {
		jdbcTemplateObject.update( SqlCommands.getUpdaterecordsql(),  fName, lName, address, institution, email, id);
		System.out.println("Update have been done sucessfully!!!!");
	}
}

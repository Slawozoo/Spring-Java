package com.jdbctemplate;

public class SqlCommands {
	
	//Create author Table
		private final static String createTableSQL = "Create table Authors "
				+ "(id int not null Primary Key,"
				+ "first_name varchar(255) not null,"
				+ "last_name varchar(255) not null,"
				+ "address varchar(255) not null,"
				+ "institution varchar(255) not null,"
				+ "email varchar(255) not null)";
	
	//Retrieve all from authors
	private final static String retrieveAllSQL = "SELECT * FROM AUTHORS";
	
	//Retrieve authors by ID
	private final static String retrieveSQL = "Select * from Authors where id = ?";
	
	//Insert into author table
	private final static String INSERTSQL = "Insert into Authors (first_name, last_name,"
			+ "address,institution,email) VALUES (?,?,?,?,?)"; 
	
	
	//Update author table
	private final static String updateRecordSQL = "UPDATE authors SET first_name = ?, last_name = ?, address =?, institution = ?, email = ? WHERE id = ?";
	
	//Delete records from author table 
	private static final String deleteRecordSQL = "DELETE from authors WHERE id = ?";

	public static String getCreatetablesql() {
		return createTableSQL;
	}

	public static String getRetrieveallsql() {
		return retrieveAllSQL;
	}

	public static String getRetrievesql() {
		return retrieveSQL;
	}

	public static String getInsertsql() {
		return INSERTSQL;
	}

	public static String getUpdaterecordsql() {
		return updateRecordSQL;
	}

	public static String getDeleterecordsql() {
		return deleteRecordSQL;
	}
	
}

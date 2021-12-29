package com.jersey.restapi.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.jersey.restapi.model.Author;

public class AuthorMapper implements RowMapper<Author>{

	public Author mapRow(ResultSet result, int rowsNum) throws SQLException {
		Author author = new Author();
		author.setFirstName(result.getString("first_name"));
		author.setLastName(result.getString("last_name"));
		author.setEmail(result.getString("email"));
		author.setAddress(result.getString("address"));
		author.setInstitution(result.getString("institution"));
		return author;
	}

}

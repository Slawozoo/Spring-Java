package com.jdbctemplate;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class AuthorMapper implements RowMapper<Author>{

	@Override
	public Author mapRow(ResultSet result, int rowsNum) throws SQLException {
		Author author = new Author();
		author.setfName(result.getString("first_name"));
		author.setlName(result.getString("last_name"));
		author.setEmail(result.getString("email"));
		author.setAddress(result.getString("address"));
		author.setInstitution(result.getString("institution"));
		
		return author;
	}

}

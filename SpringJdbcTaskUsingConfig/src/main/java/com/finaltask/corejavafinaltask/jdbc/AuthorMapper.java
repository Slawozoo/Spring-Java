package com.finaltask.corejavafinaltask.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.finaltask.corejavafinaltask.domain.Author;

public class AuthorMapper implements RowMapper<Author>{

	public Author mapRow(ResultSet result, int rowsNum) throws SQLException {
		Author author = new Author();
		author.setfName(result.getString("first_name"));
		author.setlName(result.getString("last_name"));
		author.setEmail(result.getString("email"));
		author.setAddress(result.getString("address"));
		author.setInstitution(result.getString("institution"));
		author.setArticleId(result.getInt("article_id"));
	
		
		return author;
	}

}

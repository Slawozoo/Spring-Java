package com.finaltask.corejavafinaltask.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.finaltask.corejavafinaltask.domain.Article;
import com.finaltask.corejavafinaltask.domain.Author;

public class ArticleMapper implements RowMapper<Article>{

	public Article mapRow(ResultSet result, int rowsNum) throws SQLException {
		Article article = new Article();
		article.setId(result.getInt("id"));
		article.setTitle(result.getString("title"));
		article.setPublishedDate(result.getString("published_date"));
		
		return article;
	}

}

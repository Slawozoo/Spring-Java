package com.restapi.RestApi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.RestApi.dao.IAuthorDao;
import com.restapi.RestApi.model.Authors;
import com.restapi.RestApi.service.IAuthorService;


@Service("authorService")
public class AuthorServiceImpl implements IAuthorService{
	
	@Autowired
	private IAuthorDao authorDao;
	
	public AuthorServiceImpl() {
	}
	@Override
	public List<Authors> getAuthor() {
		List<Authors> authorLists =	authorDao.getAuthor();
		return authorLists;
	}

	@Override
	public Authors getAuthorById(int authorId) {
		Authors author = authorDao.getAuthorById(authorId);
		return author;
	}

	@Override
	public int deleteAuthorById(int authorId) {
		return authorDao.deleteAuthorById(authorId);
	}

	@Override
	public int updateAuthor(Authors author) {
		return authorDao.updateAuthor(author);
	}

	@Override
	public int createAuthor(Authors author) {
		return authorDao.createAuthor(author);
	}

}

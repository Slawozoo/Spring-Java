package com.restapi.RestApi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.RestApi.dao.IAuthorDao;
import com.restapi.RestApi.model.Users;
import com.restapi.RestApi.service.IAuthorService;


@Service("authorService")
public class AuthorServiceImpl implements IAuthorService{
	
	@Autowired
	private IAuthorDao authorDao;
	
	public AuthorServiceImpl() {
	}
	@Override
	public List<Users> getAuthor() {
		List<Users> authorLists =	authorDao.getAuthor();
		return authorLists;
	}

	@Override
	public Users getAuthorById(int authorId) {
		Users author = authorDao.getAuthorById(authorId);
		return author;
	}

	@Override
	public int deleteAuthorById(int authorId) {
		return authorDao.deleteAuthorById(authorId);
	}

	@Override
	public int updateAuthor(Users author) {
		return authorDao.updateAuthor(author);
	}

	@Override
	public int createAuthor(Users author) {
		return authorDao.createAuthor(author);
	}

}

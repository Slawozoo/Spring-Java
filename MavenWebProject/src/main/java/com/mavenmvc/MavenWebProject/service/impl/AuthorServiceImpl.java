package com.mavenmvc.MavenWebProject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mavenmvc.MavenWebProject.dao.IAuthorDao;
import com.mavenmvc.MavenWebProject.model.Authors;
import com.mavenmvc.MavenWebProject.service.IAuthorService;

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
		Authors authors = authorDao.getAuthorById(authorId);
		return authors;
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

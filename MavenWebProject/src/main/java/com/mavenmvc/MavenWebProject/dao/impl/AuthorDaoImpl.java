package com.mavenmvc.MavenWebProject.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mavenmvc.MavenWebProject.dao.IAuthorDao;
import com.mavenmvc.MavenWebProject.model.Authors;
import com.mavenmvc.MavenWebProject.repository.AuthorsRepository;

@Service("authorDao")
public class AuthorDaoImpl implements IAuthorDao{
	@Autowired
	private AuthorsRepository authorsRepository;
	
	
	public AuthorDaoImpl() {
	}

	@Override
	public List<Authors> getAuthor() {
		//Using Repository
		return authorsRepository.findAll();
	}

	@Override
	public Authors getAuthorById(int authorId) {
		Authors authors = authorsRepository.getById(authorId);
		return authors;
	}

	@Override
	@Transactional
	public int deleteAuthorById(int authorId) {
		authorsRepository.deleteById(authorId);
		return authorId;
	}

	@Override
	@Transactional
	public int updateAuthor(Authors authors) {
		authorsRepository.save(authors);
		return authors.getAuthorId();
	}

	@Override
	@Transactional
	public int createAuthor(Authors authors) {
		authorsRepository.save(authors);
		return authors.getAuthorId();
	}
}

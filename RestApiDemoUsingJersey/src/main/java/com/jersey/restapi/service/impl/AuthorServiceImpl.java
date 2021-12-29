package com.jersey.restapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jersey.restapi.dao.IAuthorDao;
import com.jersey.restapi.model.Author;
import com.jersey.restapi.service.IAuthorService;

@Service("authorService")
public class AuthorServiceImpl implements IAuthorService{
	
	@Autowired
	private IAuthorDao authorDao;
//	 IAuthorDao authorDao = new AuthorDaoImpl(emFactory, entityManager);
	
	public AuthorServiceImpl() {
		System.out.println("Inside author service impl");
	}
	@Override
	public List<Author> getAuthor() {
//		List<Author> authorList =  new ArrayList<Author>();
			List<Author> authorLists =	authorDao.getAuthor();
//		 Author author = new Author();
//		 
//		  author.setFirstName("Sandesh");
//			author.setLastName("Lawaju");
//			author.setEmail("sandeshlawaju@gmail.com");
//			author.setAddress("Bhaktapur");
//			author.setInstitution("Orgware construct");
			
//			authorList.add(author);
		return authorLists;
	}

	@Override
	public Author getAuthor(Long authorId) {
		Author author = authorDao.getAuthor(authorId);
		return author;
	}

	@Override
	public int deleteAuthor(Long authorId) {
		return authorDao.deleteAuthor(authorId);
	}

	@Override
	public int updateAuthor(Author author) {
		return authorDao.updateAuthor(author);
	}

	@Override
	public Author createAuthor(Author author) {
		return authorDao.createAuthor(author);
	}

}

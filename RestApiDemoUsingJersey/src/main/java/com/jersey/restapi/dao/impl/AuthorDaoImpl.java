package com.jersey.restapi.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.jersey.restapi.dao.IAuthorDao;
import com.jersey.restapi.model.Author;

@Service("authorDao")
public class AuthorDaoImpl implements IAuthorDao{
//	EntityManagerFactory emFactory;
//	EntityManager entityManager;

	private JdbcTemplate jdbcTemplateObject;
	
//	public AuthorDaoImpl(EntityManagerFactory emFactory, EntityManager entityManager) {
//		this.emFactory = Persistence.createEntityManagerFactory("Author_JPA");
//		this.entityManager = this.emFactory.createEntityManager();
//	}
	
	public AuthorDaoImpl() {
		
	}
	 @Autowired
	 public void setDataSource(DataSource dataSource) {
	  this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	 }
	
	@Override
	public List<Author> getAuthor() {
//		EntityTransaction entityTransaction = entityManager.getTransaction();
//		List<Author> authorList = null;
//		entityTransaction.begin();
//		authorList = (List<Author>) entityManager.createQuery("from Author");
//		entityTransaction.commit();
//		entityManager.close();
	
		  
		List<Author> authorList = jdbcTemplateObject.query("Select * from authors", 
				new AuthorMapper());
		
//		Iterator itr = articleList.iterator();
//		while(itr.hasNext()) {
//			System.out.println(itr.next());
//			System.out.println("\n");
//		}
		
		return authorList;
		
		
	}

	@Override
	public Author getAuthor(Long authorId) {
//		EntityTransaction entityTransaction = entityManager.getTransaction();
//		entityTransaction.begin();
//		Author author = entityManager.find(Author.class, authorId);
//		entityTransaction.commit();
//		entityManager.close();
		return null;
	}

	@Override
	public int deleteAuthor(Long authorId) {
//		EntityTransaction entityTransaction = entityManager.getTransaction();
//		entityTransaction.begin();
//		Author author = entityManager.find(Author.class, authorId);
//		entityManager.remove(author);
//		int count = author.getAuthorId(); 
//			
//		entityTransaction.commit();
//		entityManager.close();
		return 0;
	}

	@Override
	public int updateAuthor(Author author) {
//		EntityTransaction entityTransaction = entityManager.getTransaction();
//		Query query = entityManager
//				.createQuery("Update Author set firstName = :firstName, lastName = :lastName,"
//						+ "address =:address, institution =:institution, email =:email where id = :id");
//		query.setParameter("firstName", author.getFirstName());
//		query.setParameter("lastName", author.getLastName());
//		query.setParameter("address", author.getAddress());
//		query.setParameter("institution", author.getInstitution());
//		query.setParameter("email", author.getEmail());
//		query.setParameter("id", author.getAuthorId());
//
//		query.executeUpdate();
//		entityTransaction.commit();
//		entityManager.close();
//		return author.getAuthorId();
		return 0;
	}

	@Override
	public Author createAuthor(Author author) {
//		EntityTransaction entityTransaction = entityManager.getTransaction();
//		entityTransaction.begin();
//		entityManager.persist(author);
//		entityTransaction.commit();
//		entityManager.close();

		return author;
	}
	
}

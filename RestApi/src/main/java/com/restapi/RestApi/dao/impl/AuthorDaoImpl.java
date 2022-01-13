package com.restapi.RestApi.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.RestApi.dao.IAuthorDao;
import com.restapi.RestApi.model.Users;

@Service("authorDao")
public class AuthorDaoImpl implements IAuthorDao{
	EntityManagerFactory emFactory;
	
//	@PersistenceContext
	@Autowired
	EntityManager entityManager;
	
	public AuthorDaoImpl() {
	}
	
	@Override
	public List<Users> getAuthor() {
		//Retriving list of authors using JPA
//		TypedQuery<Authors> query =
//			      entityManager.createQuery("SELECT a FROM Authors a", Authors.class);
//		List<Authors> authorList = query.getResultList();
		
		//Retrieving List of authors using Criteria Api
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Users> criteriaQuery = criteriaBuilder.createQuery(Users.class);
		Root<Users> rootAuthor = criteriaQuery.from(Users.class);
		CriteriaQuery<Users> select = criteriaQuery.select(rootAuthor);
		Query query = entityManager.createQuery(select);
		List<Users> authorList = query.getResultList();
		
		return authorList;
	}

	@Override
	public Users getAuthorById(int authorId) {
		Users author = entityManager.find(Users.class, authorId);
		return author;
	}

	@Override
	@Transactional
	public int deleteAuthorById(int authorId) {
		//Delete author using authorId in JPA
//		Authors author = entityManager.find(Authors.class, authorId);
//		entityManager.remove(author);
		
		//Delete author using authorId in criteria Api
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaDelete<Users> delete = cb.createCriteriaDelete(Users.class);
		Root rootAuthor = delete.from(Users.class);
		delete.where(cb.equal(rootAuthor.get("authorId"), authorId));
		entityManager.createQuery(delete).executeUpdate();
		
		return authorId;
	}

	@Override
	@Transactional
	public int updateAuthor(Users author) {
		//First method to update Authors using authorId in JPA
//		Query query = entityManager
//				.createQuery("Update Authors set firstName = :firstName, lastName = :lastName,"
//						+ "address =:address, institution =:institution, email =:email where id = :id");
//		query.setParameter("firstName", author.getFirstName());
//		query.setParameter("lastName", author.getLastName());
//		query.setParameter("address", author.getAddress());
//		query.setParameter("institution", author.getInstitution());
//		query.setParameter("email", author.getEmail());
//		query.setParameter("id", author.getAuthorId());
//		query.executeUpdate();
		
		//Update author using critera API
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaUpdate<Users> update = cb.createCriteriaUpdate(Users.class);
		Root rootAuthor = update.from(Users.class);
		update.set("firstName", author.getFirstName());
		update.set("lastName", author.getLastName());
		update.set("address", author.getAddress());
		update.set("institution", author.getInstitution());
		update.set("email", author.getEmail());
		update.where(cb.equal(rootAuthor.get("authorId"), author.getAuthorId()));
		entityManager.createQuery(update).executeUpdate();

		return author.getAuthorId();
	}

	@Override
	@Transactional
	public int createAuthor(Users author) {

		//First way to insert into Authors table
		//Also insert authorId in this method
//		Query query = entityManager
//				.createNativeQuery("INSERT INTO authors (first_name,last_name,"
//						+ "address, institution, email)  VALUES (?,?,?,?,?)");
//		query.setParameter(1, author.getAuthorId());
//		query.setParameter(1, author.getFirstName());
//		query.setParameter(2, author.getLastName());
//		query.setParameter(3, author.getAddress());
//		query.setParameter(4, author.getInstitution());
//		query.setParameter(5, author.getEmail());
//		query.executeUpdate();
		
		//Second way to insert into Authors table with auto increment authorId
		entityManager.persist(author);
		return author.getAuthorId();
	}
}

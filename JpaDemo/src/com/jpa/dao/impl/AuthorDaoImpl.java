package com.jpa.dao.impl;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import com.jpa.dao.IAuthorDao;
import com.jpa.model.Authors;
import com.jpa.test.UserInput;

public class AuthorDaoImpl implements IAuthorDao {
	EntityManagerFactory emFactory;
	EntityManager entityManager;
	
	
	public AuthorDaoImpl(EntityManagerFactory emFactory, EntityManager entityManager) {
		this.emFactory = Persistence.createEntityManagerFactory("Author_JPA");
		this.entityManager = this.emFactory.createEntityManager();
	}

	@Override
	public void insertAuthor(Authors author) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		entityManager.persist(author);
		entityTransaction.commit();
		entityManager.close();

	}

	@Override
	public Authors retrieveAuthor() {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		System.out.println("Enter the id to retrieve author: ");
		Scanner scn = new Scanner(System.in);
		int id = scn.nextInt();
		Authors author = entityManager.find(Authors.class, id);
		
		entityTransaction.commit();
		entityManager.close();

		return author;
	}

	@Override
	public void updateAuthor() {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the id to update author: ");
		int id = scn.nextInt();
		UserInput userInput = new UserInput();
		entityTransaction.begin();
		Authors author = entityManager.find(Authors.class, id);
		Authors auth = userInput.getInputFromUserToUpdate(author);
		
		entityTransaction.commit();
		System.out.println("Author updated sucessfully.!!!");
		entityManager.close();
	}

	@Override
	public void deleteAuthor() {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the id to delete author: ");
		int id = scn.nextInt();

		entityTransaction.begin();
		Authors author = entityManager.find(Authors.class, id);
		entityManager.remove(author);
		entityTransaction.commit();
		System.out.println("Author deleted sucessfully!!!!!");
		entityManager.close();

	}

	@Override
	public List<Object[]> retrieveAuthorName() {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		// Scalar function
		List<Object[]> rows = entityManager.createQuery("Select author.firstName, author.lastName from Authors author")
				.getResultList();
		
		entityTransaction.commit();
		entityManager.close();
		return rows;
	}

	@Override
	public void updateAuthorName() {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the id to update author: ");
		int id = scn.nextInt();

		entityTransaction.begin();
		System.out.print("First Name: ");
		String firstName = scn.next();
		System.out.print("Last Name: ");
		String lastName = scn.next();
		Query query = entityManager
				.createQuery("Update Authors set firstName = :firstName, lastName = :lastName where id = :id");
		query.setParameter("firstName", firstName);
		query.setParameter("lastName", lastName);
		query.setParameter("id", id);

		query.executeUpdate();
		System.out.println("Author updated sucessfully.!!!");
		entityTransaction.commit();
		entityManager.close();

	}

	@Override
	public void deleteAuthorUsingId() {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the id to delete author: ");
		int id = scn.nextInt();

		entityTransaction.begin();
		Query query = entityManager.createQuery("Delete from Authors where id =:id");
		query.setParameter("id", id);
		query.executeUpdate();

		entityTransaction.commit();
		entityManager.close();

	}

	@Override
	public List<Authors> retrieveAuthorUsingCriteriaApi() {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Authors> criteriaQuery = criteriaBuilder.createQuery(Authors.class);
		Root<Authors> rootAuthor = criteriaQuery.from(Authors.class);
		CriteriaQuery<Authors> select = criteriaQuery.select(rootAuthor);

		Query query = entityManager.createQuery(select);
		List<Authors> authorList = query.getResultList();
		
		return authorList;
	}

	@Override
	public void updateAuthorNameUsingCriteriaApi() {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the id to update author: ");
		int id = scn.nextInt();
		// create update
		entityTransaction.begin();
		CriteriaUpdate<Authors> update = cb.createCriteriaUpdate(Authors.class);

		// set the root class
		Root rootAuthor = update.from(Authors.class);

		// set update and where clause
		System.out.print("First Name: ");
		String firstName = scn.next();
		System.out.print("Last Name: ");
		String lastName = scn.next();
		System.out.println("Address: ");
		String address = scn.next();
		System.out.println("Email: ");
		String email = scn.next();
		System.out.println("Institution: ");
		String institution = scn.next();

		update.set("firstName", firstName);
		update.set("lastName", lastName);
		update.set("address", address);
		update.set("institution", institution);
		update.set("email", email);

		update.where(cb.equal(rootAuthor.get("authorId"), id));

		// perform update
		entityManager.createQuery(update).executeUpdate();
		entityTransaction.commit();
		System.out.println("Update sucessful.!!!");

	}

	@Override
	public void deleteAuthorUsingCriteriaApi() {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the id to delete author: ");
		int id = scn.nextInt();
		entityTransaction.begin();
		// create delete
		CriteriaDelete<Authors> delete = cb.createCriteriaDelete(Authors.class);

		// set the root class
		Root rootAuthor = delete.from(Authors.class);

		// set where clause
		delete.where(cb.equal(rootAuthor.get("authorId"), id));

		// perform update
		entityManager.createQuery(delete).executeUpdate();
		entityTransaction.commit();
		System.out.println("Author deleted sucessfully.!!!");

	}

}

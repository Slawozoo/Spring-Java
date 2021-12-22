package com.jpa.dao.impl;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;

import com.jpa.dao.IAuthorDao;
import com.jpa.model.Authors;

public class AuthorDaoImpl implements IAuthorDao {

	@Override
	public Authors setAuthor() {
		Authors author = new Authors();
		Scanner scn = new Scanner(System.in);

		System.out.print("Enter first name of author: ");
		author.setFirstName(scn.next());
		System.out.print("Enter last name of author: ");
		author.setLastName(scn.next());
		System.out.print("Enter email of author: ");
		author.setEmail(scn.next());
		System.out.print("Enter address of author: ");
		author.setAddress(scn.next());
		System.out.print("Enter institution of author: ");
		author.setInstitution(scn.next());
		return author;
	}

	@Override
	public void insertAuthor(EntityManager entityManager) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Authors author = setAuthor();
		entityManager.persist(author);
		entityTransaction.commit();
		entityManager.close();

	}

	@Override
	public void retrieveAuthor(EntityManager entityManager) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		System.out.println("Enter the id to retrieve author: ");
		Scanner scn = new Scanner(System.in);
		int id = scn.nextInt();
		Authors author = entityManager.find(Authors.class, id);
		if (author != null) {
//			System.out.println(author.toString());
			System.out.println("FirstName: " + author.getFirstName() + " LastName: " + author.getLastName()
					+ " Address: " + author.getAddress() + " Institution: " + author.getInstitution() + " Email: "
					+ author.getEmail());
		}
		entityTransaction.commit();
		entityManager.close();

	}

	@Override
	public void updateAuthor(EntityManager entityManager) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the id to update author: ");
		int id = scn.nextInt();

		entityTransaction.begin();
		Authors author = entityManager.find(Authors.class, id);

		System.out.print("First Name: ");
		author.setFirstName(scn.next());
		System.out.print("Last Name: ");
		author.setLastName(scn.next());
		System.out.print("Institution : ");
		author.setInstitution(scn.next());
		System.out.print("Address : ");
		author.setAddress(scn.next());
		System.out.print("Email : ");
		author.setEmail(scn.next());

		System.out.println("Author updated sucessfully.!!!");
		entityTransaction.commit();
		entityManager.close();
	}

	@Override
	public void deleteAuthor(EntityManager entityManager) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the id to delete author: ");
		int id = scn.nextInt();

		entityTransaction.begin();
		Authors author = entityManager.find(Authors.class, id);
		entityManager.remove(author);
		entityTransaction.commit();
		entityManager.close();

	}

	@Override
	public void retrieveAuthorName(EntityManager entityManager) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		// Scalar function
		List<Object[]> rows = entityManager.createQuery("Select author.firstName, author.lastName from Authors author")
				.getResultList();
		System.out.println(" Authors: ");
		for (Object[] row : rows) {
			System.out.println("First Name: " + row[0]);
			System.out.println("Last Name: " + row[1]);
		}
		entityTransaction.commit();
		entityManager.close();
	}

	@Override
	public void updateAuthorName(EntityManager entityManager) {
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
	public void deleteAuthorUsingId(EntityManager entityManager) {
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
	public void retrieveAuthorUsingCriteriaApi(EntityManager entityManager) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Authors> criteriaQuery = criteriaBuilder.createQuery(Authors.class);
		Root<Authors> rootAuthor = criteriaQuery.from(Authors.class);
		CriteriaQuery<Authors> select = criteriaQuery.select(rootAuthor);

		Query query = entityManager.createQuery(select);
		List<Authors> authorList = query.getResultList();
		authorList.forEach(System.out::println);

	}

	@Override
	public void updateAuthorNameUsingCriteriaApi(EntityManager entityManager) {
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
	public void deleteAuthorUsingCriteriaApi(EntityManager entityManager) {
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

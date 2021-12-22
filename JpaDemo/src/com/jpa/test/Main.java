package com.jpa.test;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jpa.model.Authors;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);

		MainApp mainApp = context.getBean(MainApp.class);
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the case you want to perform: ");
		System.out.println("1. Create and insert into Authors table: ");
		System.out.println("2. Retrieve from Authors table: ");
		System.out.println("3. Update Authors using Author id: ");
		System.out.println("4. Delete Authors using Author id: ");
		System.out.println("5. Retrieve firstName and lastName from Authors using JPQL Query: ");
		System.out.println("6. Update firstName and lastName of Authors using Author id in JPQL Query: ");
		System.out.println("7. Delete Authors using Author id in JPQL Query: ");
		System.out.println("8. Retrieve Authors using JPA Criteria API: ");
		System.out.println("9. Update Authors using Author id in JPA Criteria API: ");
		System.out.print("10. Delete Authors using Author id in JPA Criteria API: ");
		int cases = scn.nextInt();
		
		switch (cases) {
		case 1:
			// Create and insert into authors table
			UserInput userInput = new UserInput();
			Authors author = userInput.getInputFromUser();
			mainApp.authorDao.insertAuthor(author);
			break;
		case 2:
			// Retrieveing from authors table
			Authors authorRetrieve = mainApp.authorDao.retrieveAuthor();
			displayAuthor(authorRetrieve);
			break;
		case 3:
			// Update author using author ID
			mainApp.authorDao.updateAuthor();
			break;
		case 4:
			// Delete author using author ID
			mainApp.authorDao.deleteAuthor();
			break;
		case 5:
			// retrieve author first and last name
			mainApp.authorDao.retrieveAuthorName();
			break;
		case 6:
			// update authors using JPQL
			mainApp.authorDao.updateAuthorName();
			break;
		case 7:
			// Delete authors using JPQL
			mainApp.authorDao.deleteAuthorUsingId();
			break;
		case 8:
			// Retrieve authors using Criteria API
			mainApp.authorDao.retrieveAuthorUsingCriteriaApi();
			break;
		case 9:
			// update authors using Criteria API
			mainApp.authorDao.updateAuthorNameUsingCriteriaApi();
			break;
		case 10:
			// Delete authors using Criteria API
			mainApp.authorDao.deleteAuthorUsingCriteriaApi();
			break;
		default:
			System.out.println("Choose the valid cases only.!!!");
		}
	}

	private static void displayAuthor(Authors author) {
		if (author != null) {
			System.out.println("FirstName: " + author.getFirstName() + " LastName: " + author.getLastName()
					+ " Address: " + author.getAddress() + " Institution: " + author.getInstitution() + " Email: "
					+ author.getEmail());
		}
		
	}
}

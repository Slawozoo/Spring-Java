package com.jdbctemplate;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String [] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AuthorConfig.class);
		IAuthorJdbcTemplateDao authorJdbcTemplate = (AuthorJdbcTemplateDaoImpl) context.getBean(AuthorJdbcTemplateDaoImpl.class);
		
		System.out.println("Enter the case you want to use: ");
		System.out.println("1. Create database table Authors");
		System.out.println("2. Insert records in Authors table");
		System.out.println("3. Retrive records from database");
		System.out.println("4. Retrieve all  records from database");
		System.out.println("5. Update records of Authors table");
		System.out.println("6. Delete records from Authors table");
		Scanner scn = new Scanner(System.in);
		int cases = scn.nextInt();
		switch(cases) {
			case 1:
				//For creating database table Authors
				authorJdbcTemplate.createAuthorsTable();
			break;
			
			case 2:
				//For inserting records in Authors table
				System.out.print("Enter first name of author:  ");
				String fName = scn.next();
				System.out.print("Enter last name of author:  ");
				String lName = scn.next();
				System.out.print("Enter address name of author:  ");
				String address = scn.next();
				System.out.print("Enter institution of author:  ");
				String institution = scn.next();
				System.out.print("Enter email of author:  ");
				String email = scn.next();
				authorJdbcTemplate.insertAuthorTable(fName, lName, address, institution, email);
			break;
			case 3:
				//For retriving records from database
				System.out.print("Enter the id of author you want to search: ");
				int id = scn.nextInt();
				Author author = authorJdbcTemplate.getAuthor(id);
				System.out.println("First Name: "+author.getfName());
				System.out.println("Last Name: "+author.getlName());
				System.out.println("Address: "+author.getAddress());
				System.out.println("Institution: "+author.getInstitution());
				System.out.println("Email: "+author.getEmail());
			break;
			case 4:
				//For retriving all records from database 
				List<Author> authorList = authorJdbcTemplate.listAuthors();
				System.out.println("Authors: ");
				for(Author autho: authorList) {
					System.out.println("\tFirst Name: "+ autho.getfName());
					System.out.println("\tLast Name: "+autho.getlName());
					System.out.println("\tEmail: "+autho.getEmail());
					System.out.println("\tAddress: "+autho.getAddress());
					System.out.println("\tInstitution: "+autho.getInstitution());
					System.out.println("\n");
				}
			break;
			case 5:
				//For updating record of Authors table
				System.out.println("Enter the id of author which you want to update: ");
				int updateId = scn.nextInt();
				System.out.print("First Name: ");
				String firstName = scn.next();
				System.out.print("Last Name: ");
				String lastName = scn.next();
				System.out.print("Address: ");
				String addresses = scn.next();
				System.out.print("Institution: ");
				String institutions = scn.next();
				System.out.print("Email: ");
				String emails = scn.next();
				authorJdbcTemplate.updateFromAuthor(firstName, lastName, addresses, institutions, emails, updateId);

			break;
			case 6:
				//For deleting record from authors table
				System.out.println("Enter the id of author which you want to delete: ");
				int deleteId = scn.nextInt();
				authorJdbcTemplate.deleteFromAuthor(deleteId);
			break;
			default:
				System.out.println("Choose valid cases only.!!!");

		}
	}
}

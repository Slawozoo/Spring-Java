package com.jpa.test;

import java.util.Scanner;

import com.jpa.model.Authors;

public class UserInput {

	/**
	 *Takes user input from user
	 */
	public Authors getInputFromUser() {
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
	public Authors getInputFromUserToUpdate(Authors author) {
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
}


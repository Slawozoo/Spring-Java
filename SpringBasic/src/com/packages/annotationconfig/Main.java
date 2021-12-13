package com.packages.annotationconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		Author author = (Author) context.getBean("author");
		System.out.println("Name of author: "+author.getName());
		System.out.println("Email: "+author.getEmail());
		System.out.println("Address: "+author.getAddress());
		System.out.println("Institution: "+author.getInstitution());
	}
}

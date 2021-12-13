package com.packages.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		AuthorProfile authorProfile = (AuthorProfile) context.getBean("authorProfile");
		authorProfile.displayName();
		authorProfile.displayEmail();
		authorProfile.displayAddress();
		authorProfile.displayInstitution();

	}

}

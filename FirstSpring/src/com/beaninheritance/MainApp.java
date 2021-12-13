package com.beaninheritance;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		ParentExample parentBean = (ParentExample) context.getBean("parentExamples");
		parentBean.getName();
		parentBean.getAddress();
		
		ChildExample childBean = (ChildExample) context.getBean("childExamples");
		childBean.getName();
		childBean.getAddress();
		childBean.getContact();
	}
	
	
}

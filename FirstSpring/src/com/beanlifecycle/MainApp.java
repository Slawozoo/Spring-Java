package com.beanlifecycle;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String []args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		Example example = (Example) context.getBean("springExample");
		example.getMessage();
		context.registerShutdownHook();
	}

}

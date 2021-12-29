package com.jersey.restapi;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.jersey.restapi")
@PropertySource("classpath:application.properties")
public class ProjectConfiguartion {
	public ProjectConfiguartion() {
		System.out.println("Inside project configuration class");
	}
}

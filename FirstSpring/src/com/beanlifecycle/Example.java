package com.beanlifecycle;

public class Example {
	private String message;

	public void getMessage() {
		System.out.println("Message: "+message);
	}

	public void setMessage(String message) {
		
		this.message = message;
	}
	public void init() {
		System.out.println("Bean in going through init ");
	}
	public void destroy() {
		System.out.println("Bean is destroyed..");
	}
	
}

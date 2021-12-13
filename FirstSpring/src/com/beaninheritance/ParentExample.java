package com.beaninheritance;

public class ParentExample {
	private String name;
	
	private String address;
	public void getName() {
		System.out.println("Name of parent bean: "+name);
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void getAddress() {
		System.out.println("Address of parent bean: "+address); 
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}

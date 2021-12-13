package com.beaninheritance;

public class ChildExample {
	private String name;
	private String address;
	private int contact;
	
	public void getContact() {
		System.out.println("Contact no. of child bean: "+contact);
	}
	public void setContact(int contact) {
		this.contact = contact;
	}
	public void getName() {
		System.out.println("Name of child bean: "+name);
	}
	public void setName(String name) {
		this.name = name;
	}
	public void getAddress() {
		System.out.println("Address of child bean: "+address);
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}	

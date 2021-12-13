package com.packages.annotationconfig;

import org.springframework.beans.factory.annotation.Required;

public class Author {
	private String name;
	private String address;
	private String email;
	private String institution;
	
	public String getName() {
		return name;
	}
	
	@Required
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	@Required
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	@Required
	public void setEmail(String email) {
		this.email = email;
	}
	public String getInstitution() {
		return institution;
	}
	@Required
	public void setInstitution(String institution) {
		this.institution = institution;
	}
	
	
}

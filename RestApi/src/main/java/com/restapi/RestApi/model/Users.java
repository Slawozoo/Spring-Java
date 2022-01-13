package com.restapi.RestApi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "authors")
public class Authors {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "authorid")
	private int authorId;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "institution")
	private String institution;
	
	public Authors() {
	}
	
	@JsonCreator
	public Authors(@JsonProperty("authorId") int authorId, @JsonProperty("firstName")String firstName, @JsonProperty("lastName")String lastName,
			@JsonProperty("email")String email, @JsonProperty("address")String address, @JsonProperty("institution")String institution) {
		this.authorId = authorId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.institution = institution;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		  str.append("Author Id:- " + getAuthorId());
		  str.append(" First Name:- " + getFirstName());
		  str.append(" Last Name:- " + getLastName());
		  str.append("Address:- " + getAddress());
		  str.append("Institution:- " + getInstitution());
		  str.append("Email:- " + getEmail());
		 return str.toString();
	
	}
}

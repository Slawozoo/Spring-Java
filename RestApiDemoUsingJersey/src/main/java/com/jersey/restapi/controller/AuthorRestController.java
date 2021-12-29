package com.jersey.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jersey.restapi.model.Author;
import com.jersey.restapi.service.IAuthorService;

@RestController
public class AuthorRestController {

	@Autowired
	private IAuthorService authorService;
	
	 @RequestMapping(value = "/author", method = RequestMethod.GET, produces = "application/json")
	 public ResponseEntity<List<Author>> displayAuthor() {
	 
	  HttpHeaders headers = new HttpHeaders();
	  List<Author> authors = authorService.getAuthor();
//	  
//	  Author author = new Author();
//	 
//	  author.setFirstName("Sandesh");
//		author.setLastName("Lawaju");
//		author.setEmail("sandeshlawaju@gmail.com");
//		author.setAddress("Bhaktapur");
//		author.setInstitution("Orgware construct");
	 
	  if (authors == null) {
	   return new ResponseEntity<List<Author>>(HttpStatus.NOT_FOUND);
	  }
	  headers.add("Number Of Records Found", String.valueOf(authors.size()));
	  return new ResponseEntity<List<Author>>(authors, headers, HttpStatus.OK);
	 }
	 
//	public String getAuthor(){
//		Author author = new Author();
//		author.setFirstName("Sandesh");
//		author.setLastName("Lawaju");
//		author.setEmail("sandeshlawaju@gmail.com");
//		author.setAddress("Bhaktapur");
//		author.setInstitution("Orgware construct");
//		
////		HttpHeaders headers = new HttpHeaders();
//		
//		 
////		  if (author == null) {
////		   return new ResponseEntity<Author>(HttpStatus.NOT_FOUND);
////		  }
////		  headers.add("Number Of Records Found", String.valueOf(employees.size()));
////		  return new ResponseEntity<List<Employee>>(employees, headers, HttpStatus.OK);
//		
//		return author.toString();
		
//	}
}

package com.restapi.RestApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.RestApi.model.Authors;
import com.restapi.RestApi.service.IAuthorService;

@RestController
public class AuthorRestController {

	@Autowired
	private IAuthorService authorService;
	 /**
	 * Method used to get List of Authors using GET method in Postman
	 */
	@RequestMapping(value = "/authors", method = RequestMethod.GET, produces = "application/json")
	 public ResponseEntity<List<Authors>> displayAuthor() {
	  HttpHeaders headers = new HttpHeaders();
	  List<Authors> authors = authorService.getAuthor();
	  if (authors == null) {
	   return new ResponseEntity<List<Authors>>(HttpStatus.NOT_FOUND);
	  }
	  headers.add("Number Of Records Found", String.valueOf(authors.size()));
	  return new ResponseEntity<List<Authors>>(authors, headers, HttpStatus.OK);
	 }
 
	 /**
	 * Method to get an Author from DB using authorId in GET method
	 */
	@RequestMapping(value = "/authors/{id}", method = RequestMethod.GET)
	 public ResponseEntity<Authors> getAuthor(@PathVariable("id") int authorId) {
	  Authors author = authorService.getAuthorById(authorId);
	  if (author == null) {
	   return new ResponseEntity<Authors>(HttpStatus.NOT_FOUND);
	  }
	  return new ResponseEntity<Authors>(author, HttpStatus.OK);
	 }
	 
	 /**
	 * Update Authors using authorId and PUT method in Postman
	 */
	@RequestMapping(value = "/authors/{id}", method = RequestMethod.PUT)
	 public ResponseEntity<Authors> updateAuthorById(@PathVariable("id") int authorId, 
			 @RequestBody Authors author) {
	   authorService.updateAuthor(author);
	  if (author == null) {
	   return new ResponseEntity<Authors>(HttpStatus.NOT_FOUND);
	  }
	  return new ResponseEntity<Authors>(author, HttpStatus.OK);
	 }
	 
	 /**
	 * Create and Insert record in Authors table and POST method in Postman
	 */
	@RequestMapping(value = "/authors", method = RequestMethod.POST,produces = "application/json")
	 public ResponseEntity<Authors> createAuthor(@RequestBody Authors author) {
	  HttpHeaders headers = new HttpHeaders();
	  if (author == null) {
	   return new ResponseEntity<Authors>(HttpStatus.BAD_REQUEST);
	  }
	  authorService.createAuthor(author);
	  headers.add("Author Created  - ", String.valueOf(author.getAuthorId()));
	  return new ResponseEntity<Authors>(author, headers, HttpStatus.CREATED);
	 }
	 
	 /**
	 * Delete authors using authorId and use DELETE in postman
	 */
	@RequestMapping(value = "/authors/delete/{id}", method = RequestMethod.DELETE)
	 public ResponseEntity<Authors> deleteAuthorById(@PathVariable("id") int authorId) {
	  HttpHeaders headers = new HttpHeaders();
	  Authors author = authorService.getAuthorById(authorId);
	  if (author == null) {   
	   return new ResponseEntity<Authors>(HttpStatus.NOT_FOUND);
	  }
	  authorService.deleteAuthorById(authorId);
	  headers.add("Author Deleted - ", String.valueOf(authorId));
	  System.out.println("Authors with "+ authorId+ " deleted!!!!");
	  return new ResponseEntity<Authors>(author, headers, HttpStatus.CONTINUE);
	 }
}

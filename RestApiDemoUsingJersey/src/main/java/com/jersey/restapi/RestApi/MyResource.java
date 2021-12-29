package com.jersey.restapi.RestApi;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.jersey.restapi.model.Author;
import com.jersey.restapi.service.IAuthorService;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("authors")
@Service
public class MyResource {
	@Autowired
	IAuthorService authorService;
	
	@Value("${key}")
	private String value;
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Author> getAuthor(){
    	System.out.println("Value: "+value);
		List<Author> authorList = authorService.getAuthor();
		

		for(Author author: authorList) {
			author.toString();
		}
		
//		author.toString();
		return authorList;
		
	}
    
//    @RequestMapping(value = "/authors", method = RequestMethod.GET, produces = "application/json")
//    @GET
//	@Produces(MediaType.APPLICATION_JSON)
//	 public ResponseEntity<Author> displayAuthor() {
//	 
//	  HttpHeaders headers = new HttpHeaders();
//	  Author author = new Author();
//	 
//	  author.setFirstName("Sandesh");
//		author.setLastName("Lawaju");
//		author.setEmail("sandeshlawaju@gmail.com");
//		author.setAddress("Bhaktapur");
//		author.setInstitution("Orgware construct");
//	 
//	  if (author == null) {
//	   return new ResponseEntity<Author>(HttpStatus.NOT_FOUND);
//	  }
//	  headers.add("Number Of Records Found", author.toString());
//	  return new ResponseEntity<Author>(author, headers, HttpStatus.OK);
//	 }
    

}

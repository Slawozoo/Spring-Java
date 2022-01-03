package com.mavenmvc.MavenWebProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mavenmvc.MavenWebProject.model.Authors;
import com.mavenmvc.MavenWebProject.service.IAuthorService;

@Controller
public class AuthorRestController {

	 public AuthorRestController() {
	}
	 
	@Autowired
	private IAuthorService authorService;
	
	/**
	 * Method to list all the authors in the authors.jsp page
	 */
	@RequestMapping(value = "/authors")
	public String viewAuthors(Model model){  
        List<Authors> authorList=authorService.getAuthor();    
        model.addAttribute("list",authorList); 
        return "authors"; //WEB-INF/jsp/authors.jsp
	}
	 /**
	 * This method will direct user to add_authors.jsp page to insert new authors 
	 */
	@RequestMapping("/authorsform")
	  public String showForm(Model model) {
	    model.addAttribute("authors", new Authors());
	    return "add_authors";  //WEB-INF/jsp/add_authors.jsp
	  }
	  /*
	   * This method will save an authors object into table.
	   */
	  @RequestMapping(value = "/add_authors" )
	  public String addAuthors(@ModelAttribute("authors") Authors authors) {
		  authorService.createAuthor(authors);
	    return "redirect:/authors";  //WEB-INF/jsp/authors.jsp
	  }
	  /*
	   * This method will show the Edit Authors Page to user
	   */
	  @RequestMapping(value = "editauthorsform/{authorId}")
	  public String showEditForm(@PathVariable("authorId") int authorId, Model model) {
	    Authors authors = authorService.getAuthorById(authorId);
	    model.addAttribute("authors", authors);
	    return "update_authors";  //WEB-INF/views/update_authors.jsp
	  }
	  /*
	   * This method will update authors's information
	   */
	  @RequestMapping(value = "/update_authors")
	  public String updateAuthors( @ModelAttribute("authors") Authors authors) {
		  int id =  authorService.updateAuthor(authors);
		  System.out.println("Author with authorId: "+id+" updated sucessfully!!!!");
		  return "redirect:/authors";  //WEB-INF/jsp/authors.jsp
	  }
	  
	  /**
	 * This method will delete authors using authorid
	 */
	@RequestMapping(value = "deleteauthors/{authorId}")
	  public String deleteAuthors(@PathVariable("authorId") int authorId, Model model) {
	    int id = authorService.deleteAuthorById(authorId);
	    System.out.println("Author with authorId "+id+" deleted!!!");
	    return "redirect:/authors";  //WEB-INF/jsp/authors.jsp
	  }
}

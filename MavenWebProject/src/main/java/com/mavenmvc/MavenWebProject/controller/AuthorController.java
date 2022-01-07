package com.mavenmvc.MavenWebProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mavenmvc.MavenWebProject.model.Authors;
import com.mavenmvc.MavenWebProject.model.User;
import com.mavenmvc.MavenWebProject.service.IAuthorService;
import com.mavenmvc.MavenWebProject.service.SecurityService;
import com.mavenmvc.MavenWebProject.service.UserService;
import com.mavenmvc.MavenWebProject.validator.UserValidator;

@Controller
public class AuthorController {

	public AuthorController() {
	}

	@Autowired
	private IAuthorService authorService;
	@Autowired
	private UserService userService;
	@Autowired
	private SecurityService securityService;
	@Autowired
	private UserValidator userValidator;

	/**
	 * Method to list all the authors in the authors.jsp page
	 */
	@RequestMapping(value = "/authors")
	public String viewAuthors(Model model) {
		List<Authors> authorList = authorService.getAuthor();
		model.addAttribute("list", authorList);
		return "authors"; // WEB-INF/jsp/authors.jsp
	}

	/**
	 * This method will direct user to add_authors.jsp page to insert new authors
	 */
	@RequestMapping("/authorsform")
	@PreAuthorize("hasRole('ADMIN')")
	public String showForm(Model model) {
		// Using annotation to access
		model.addAttribute("authors", new Authors());
		return "add_authors"; // WEB-INF/jsp/add_authors.jsp
	}

	/*
	 * This method will save an authors object into table.
	 */
	@RequestMapping(value = "/add_authors")
	@PreAuthorize("hasRole('ADMIN')")
	public String addAuthors(@ModelAttribute("authors") Authors authors) {
		// Using annotation to access
		authorService.createAuthor(authors);
		return "redirect:/authors"; // WEB-INF/jsp/authors.jsp
	}

	/*
	 * This method will show the Edit Authors Page to user
	 */
	@RequestMapping(value = "editauthorsform/{authorId}")
	@PreAuthorize("hasRole('ADMIN')")
	public String showEditForm(@PathVariable("authorId") int authorId, Model model) {
		// Using annotation to access
		Authors authors = authorService.getAuthorById(authorId);
		model.addAttribute("authors", authors);
		return "update_authors"; // WEB-INF/views/update_authors.jsp
	}

	/*
	 * This method will update authors's information
	 */
	@RequestMapping(value = "/update_authors")
	@PreAuthorize("hasRole('ADMIN')")
	public String updateAuthors(@ModelAttribute("authors") Authors authors) {
		// Using annotation to access
		int id = authorService.updateAuthor(authors);
		System.out.println("Author with authorId: " + id + " updated sucessfully!!!!");
		return "redirect:/authors"; // WEB-INF/jsp/authors.jsp
	}

	/**
	 * This method will delete authors using authorid
	 */
	@RequestMapping(value = "deleteauthors/{authorId}")
	@PreAuthorize("hasRole('ADMIN')")
	public String deleteAuthors(@PathVariable("authorId") int authorId, Model model) {
		// Using annotation to access
		int id = authorService.deleteAuthorById(authorId);
		System.out.println("Author with authorId " + id + " deleted!!!");
		return "redirect:/authors"; // WEB-INF/jsp/authors.jsp
	}

	/* From this section Login and Registration Starts with Spring Security */

	/**
	 * Method of GetMapping for Registration
	 */
	@GetMapping("/registration")
	public String registration(Model model) {
		model.addAttribute("userForm", new User());
		return "registration";
	}

	/**
	 * Method of PostMapping for Registration
	 */
	@PostMapping("/registration")
	public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
		userValidator.validate(userForm, bindingResult);
		if (bindingResult.hasErrors()) {
			return "registration";
		}
		userService.saveUser(userForm);
		securityService.autoLogin(userForm.getUsername(), userForm.getConfirmPassword());
		return "index";
	}

	/**
	 * Method of Get Mapping for Login Post mapping is done by Spring Security so I
	 * didnot define any PostMapping method for login
	 */
	@GetMapping("/login")
	public String login(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("error", "Your username and password is invalid.");

		if (logout != null)
			model.addAttribute("message", "You have been logged out successfully.");
		return "login";
	}

	/**
	 * Method for GetMapping for index page
	 */
	@GetMapping({ "/", "/index" })
	public String welcome(Model model) {
		return "index";
	}

	/**
	 * Method for displaying the welcome.jsp after login
	 */
	@GetMapping("/welcome")
	public String welcomePage(Model model) {
		return "welcome";
	}
}

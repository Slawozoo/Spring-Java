package com.mockito.MockitoExample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.mockito.MockitoExample.model.Employee;
import com.mockito.MockitoExample.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	/**
	 * Method for Getting all employees in GetMapping
	 */
	@GetMapping("/employee")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Employee>> listAllEmployees() {
		return ResponseEntity.ok().body(employeeService.getAllEmployee());
	}

	/**
	 * Method to Get employees using Id in  GetMapping
	 */
	@GetMapping("/employee/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Employee> listEmployee(@PathVariable Long id) {
		return ResponseEntity.ok().body(employeeService.getEmployeeById(id));
	}

	/**
	 *Method to delete  employee using Id in DeleteMapping
	 */
	@DeleteMapping("/employee/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteUser_whenDeleteEmployee(@PathVariable Long id) {
		employeeService.deleteEmployeeById(id);
	}

	/**
	 *Method to update employee using Id in PutMapping
	 */
	@PutMapping("/employee/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee ,@PathVariable long id) {
		return ResponseEntity.ok().body(employeeService.updateEmployeeById(id, employee));
	}
	
	/**
	 * Method to create new Employee using PostMapping
	 */
	@PostMapping("/employee")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Employee> createNewEmployee(@RequestBody Employee employee, 
    		UriComponentsBuilder builder) {
		Employee createdEmployee = employeeService.createEmployee(employee);
			return ResponseEntity.created(builder.path("/employee/xpost/")
					.build(employee))
					.build();
    }

	/**
	 *  Method to create new Employee using PostMapping which returns Employee object
	 */
	@PostMapping("/employee/post")
	@ResponseStatus(HttpStatus.CREATED)
	public Employee postNewEmployee(@RequestBody Employee employee) {
		employee.setId(5L);
		employee.setName("Test Name");
		employee.setEmail("Test email");
		return employee;
	}
	

}

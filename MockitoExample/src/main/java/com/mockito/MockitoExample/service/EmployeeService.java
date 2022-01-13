package com.mockito.MockitoExample.service;

import java.util.List;
import java.util.Optional;

import com.mockito.MockitoExample.model.Employee;

public interface EmployeeService {

	/**
	 * Method to find Employee using Id and returns Optional<Employee> object
	 */
	public Optional<Employee> findEmployeeById(Long id);

	/**
	 *  Method to find Employee using Id and returns object of Employee
	 */
	public Employee getEmployeeById(Long id);

	/**
	 * Method to delete Employee using Id 
	 */
	public void deleteEmployeeById(Long id);

	/**
	 * Method to retrieve all Employee 
	 */
	public List<Employee> getAllEmployee();

	/**
	 * Method to update Employee using Id
	 */
	public Employee updateEmployeeById(Long id, Employee employee);

	/**
	 * Method to create new Employee
	 */
	public Employee createEmployee(Employee employee);
}

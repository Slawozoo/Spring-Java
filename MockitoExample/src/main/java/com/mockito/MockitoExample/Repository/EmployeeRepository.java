package com.mockito.MockitoExample.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mockito.MockitoExample.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	/**
	 * Method to find Employee using name
	 */
	public Employee findByName(String name);
}

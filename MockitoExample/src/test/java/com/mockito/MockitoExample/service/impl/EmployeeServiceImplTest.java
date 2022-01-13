package com.mockito.MockitoExample.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mockito.MockitoExample.Repository.EmployeeRepository;
import com.mockito.MockitoExample.model.Employee;

@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {

	@InjectMocks
	private EmployeeServiceImpl employeeService;

	@Mock
	private EmployeeRepository employeeRepository;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Service Test for Creating new Employee
	 */
	@Test
	public void whenSaveEmployee_shouldReturnEmployee() {
		Employee employee = new Employee();
		employee.setName("Test Name");
		employee.setEmail("Test email");
		when(employeeRepository.save(ArgumentMatchers.any(Employee.class))).thenReturn(employee);
		Employee created = employeeService.createEmployee(employee);
		assertThat(created.getName()).isSameAs(employee.getName());
		verify(employeeRepository).save(employee);
	}

	/**
	 * Service Test for retriving Employee using id
	 */
	@Test
	public void whenGivenId_shouldReturnEmployee_ifFound() {
		Employee employee = new Employee();
		employee.setId(1L);
		employee.setName("Name");
		employee.setEmail("Email");
		when(employeeRepository.getById(employee.getId())).thenReturn(employee);
		Employee expected = employeeService.getEmployeeById(employee.getId());
		assertThat(expected).isSameAs(employee);
		verify(employeeRepository).getById(employee.getId());
	}

	/**
	 * Service Test for delete Employee using id
	 */
	@Test
	public void deleteUser_whenDeleteEmployee() {
		Employee employee = new Employee();
		employee.setName("Test Name");
		employee.setId(1L);
//		when(employeeRepository.getById(employee.getId())).thenReturn(employee);
		employeeService.deleteEmployeeById(employee.getId());
		verify(employeeRepository).deleteById(employee.getId());
	}

	/**
	 * Service Test for retriving all employees
	 */
	@Test
	public void shouldReturnAllEmployees() {
		List<Employee> employees = new ArrayList();
		employees.add(new Employee());
		given(employeeRepository.findAll()).willReturn(employees);
		List<Employee> expected = employeeService.getAllEmployee();
		assertEquals(expected, employees);
		verify(employeeRepository).findAll();
	}

	/**
	 * Service Test for updating Existing employee
	 */
	@Test
	public void whenGivenId_shouldUpdateEmployee_ifFound() {
		Employee employee = new Employee();
		employee.setId(1L);
		employee.setName("Test Name");
		employee.setEmail("test email");
		
		Employee newEmployee = new Employee();
		newEmployee.setName("New Test Name");
		newEmployee.setEmail("New Employee email");
		given(employeeRepository.getById(employee.getId())).willReturn(employee);
		employeeService.updateEmployeeById(employee.getId(), newEmployee);
		verify(employeeRepository).save(newEmployee);
		verify(employeeRepository).getById(employee.getId());
	}

}

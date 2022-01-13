package com.mockito.MockitoExample.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mockito.MockitoExample.Repository.EmployeeRepository;
import com.mockito.MockitoExample.model.Employee;
import com.mockito.MockitoExample.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Optional<Employee> findEmployeeById(Long id) {
		return employeeRepository.findById(id);
	}

	@Override
	public Employee getEmployeeById(Long id) {
		return employeeRepository.getById(id);
	}

	@Override
	public void deleteEmployeeById(Long id) {
		employeeRepository.deleteById(id);
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee updateEmployeeById(Long id, Employee employee) {
		employeeRepository.getById(id);
		employee.setName(employee.getName());
		employee.setEmail(employee.getEmail());
		return employeeRepository.save(employee);
	}

	@Override
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

}

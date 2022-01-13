package com.mockito.MockitoExample.controllertest;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mockito.MockitoExample.controller.EmployeeController;
import com.mockito.MockitoExample.model.Employee;
import com.mockito.MockitoExample.service.impl.EmployeeServiceImpl;
import com.mockito.MockitoExample.utils.JsonUtil;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private EmployeeServiceImpl employeeService;

	/**
	 * Method to test POST Mapping in EmployeeController.class
	 * while creating new Employee using uri ("/employee/post")
	 */
	@Test
	public void createEmployee_whenPostMethod() throws Exception {
		Employee employee = new Employee();
		employee.setId(5L);
		employee.setName("Test Name");
		employee.setEmail("Test email");
		given(employeeService.createEmployee(employee)).willReturn(employee);
		byte[] jsonContent = JsonUtil.toJson(employee);
		mvc.perform(post("/employee/post")
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonContent))
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$.name", is("Test Name")));
	}

	
	/**
	 * Method to test POST Mapping in EmployeeController.class
	 * while creating new Employee using uri ("/employee")
	 */
	@Test
	public void shootCreateEmployee_whenPostMethod() throws Exception {
		String body = "{\r\n" + "    \"id\": 7,\r\n" + "    \"name\": \"EmoloyeeName\",\r\n"
				+ "    \"email\": \"EmailEmployee\"\r\n" + "}";

		mvc.perform(MockMvcRequestBuilders.post("/employee").contentType(MediaType.APPLICATION_JSON).content(body))
				.andExpect(MockMvcResultMatchers.status().isCreated());
	}

	/**
	 *Method to test if all employees are retrieved from the DB
	 *GetMapping in ("/employee")
	 */
	@Test
	public void listAllEmployees_whenGetMethod() throws Exception {

		Employee employee = new Employee();
		employee.setName("Test name");
		employee.setEmail("All Email");
		employee.setId(3L);

		List<Employee> allEmployees = Arrays.asList(employee);
		given(employeeService.getAllEmployee()).willReturn(allEmployees);
		mvc.perform(get("/employee").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
//				.andExpect(jsonPath("$", hasSize(1)))
				.andExpect(jsonPath("$[0].name", is(employee.getName())));
	}

	/**
	 * Method to test if employee is retrieved from the DB using Id
	 *GetMapping in ("/employee/{id}")
	 */
	@Test
	public void getEmployeeById_whenGetMethod() throws Exception {
		Employee employee = new Employee();
		employee.setName("Test Name");
		employee.setId(89L);
		employee.setEmail("EmailDump");
		given(employeeService.getEmployeeById(employee.getId())).willReturn(employee);
		mvc.perform(get("/employee/" + employee.getId().toString()).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("name", is(employee.getName())));
	}

	/**
	 * Method to test if Employee is deleted/removed using Id in DeleteMapping
	 */
	@Test
	public void removeEmployeeById_whenDeleteMethod() throws Exception {
		Employee employee = new Employee();
		employee.setName("Test Name");
		employee.setId(89L);
		employee.setEmail("Email Test");

		doNothing().when(employeeService).deleteEmployeeById(employee.getId());

		mvc.perform(delete("/employee/" + employee.getId().toString()).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNoContent());
	}

	/**
	 * Method to test if Employee is updated using Id in PutMapping
	 */
	@Test
	public void updateEmployee_whenPutEmployee() throws Exception {
		Employee employee = new Employee();
		employee.setName("Test Name");
		employee.setEmail("Email new");
		employee.setId(2L);

		Employee emp = employeeService.getEmployeeById(2L);
		given(employeeService.updateEmployeeById(2L,employee)).willReturn(employee);
		ObjectMapper mapper = new ObjectMapper();
		mvc.perform(put("/employee/" + employee.getId().toString()).content(mapper.writeValueAsString(employee))
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
//                .andExpect(jsonPath("name", is(employee.getName())));
	}
}

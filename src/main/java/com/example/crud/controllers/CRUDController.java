package com.example.crud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.models.Employee;
import com.example.crud.models.Response;
import com.example.crud.repositories.EmployeeRepository;

@RestController
public class CRUDController {
	
	
	
	@Autowired
	EmployeeRepository employeeRepository;

	@RequestMapping(path = "/hello", method = RequestMethod.POST)
	public String hello() {
		return "Hello";
	}
	
	@RequestMapping("/add")
	public Response addNewEmployee(@RequestBody Employee employee) {
		Employee savedEmployee = null;
		if(employee!= null &&
			employee.getName() != null && !employee.getName().trim().equals("") &&
			employee.getPhone() != null && !employee.getPhone().trim().equals("") &&
			employee.getCity() != null && !employee.getCity().trim().equals("")) {
			savedEmployee = employeeRepository.save(employee);
			return new Response("Success - Employee saved.", true, savedEmployee);
		}else {
			return new Response("All fields are necessary", false, savedEmployee);
		}
	}
	
	@RequestMapping("getAllEmployees")
	public Response getAllEmployees() {
		return new Response("Success", true, employeeRepository.findAll());
	}
	
	@RequestMapping("/updateEmployee")
	public Response updateEmployee(@RequestBody Employee employee) {
		Employee savedEmployee = null;
		if(employee!= null &&
				employee.getId() != null &&
				employee.getName() != null && !employee.getName().trim().equals("") &&
				employee.getPhone() != null && !employee.getPhone().trim().equals("") &&
				employee.getCity() != null && !employee.getCity().trim().equals("")) {
				savedEmployee = employeeRepository.save(employee);
				return new Response("Success - Employee updated.", true, savedEmployee);
			}else {
				return new Response("All fields are necessary", false, savedEmployee);
			}
	}
	
	@RequestMapping("/deleteEmployee")
	public Response deleteEmployee(@RequestParam("id") Integer id) {
		employeeRepository.deleteById(id);
		return new Response("Employee record Deleted!!!", true, null);
	}
}

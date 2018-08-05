package org.api.resthibernate.controller;

import java.util.List;

import org.api.resthibernate.domain.Employee;
import org.api.resthibernate.service.EmployeeService;
import org.api.resthibernate.to.EmployeeTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService service;
	
	@GetMapping(name = "/getEmployees")
	@ResponseBody
	public List<Employee> getAllEmployees() {
		List<Employee> empList = null;
		try {
			empList = service.retrieveAllEmployees();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return empList;
	}
	
	@PostMapping("/addEmployee")
	public HttpStatus addEmployee(EmployeeTo employee) {
		System.out.println(employee);
		
		Long id = service.addEmployee(employee);		
		return id != null ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
	}
}

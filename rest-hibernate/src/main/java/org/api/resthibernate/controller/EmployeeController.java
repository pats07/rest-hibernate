package org.api.resthibernate.controller;

import java.util.List;

import org.api.resthibernate.domain.Employee;
import org.api.resthibernate.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}

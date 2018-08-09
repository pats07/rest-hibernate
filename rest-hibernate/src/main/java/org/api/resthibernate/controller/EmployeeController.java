package org.api.resthibernate.controller;

import org.api.resthibernate.exception.EmployeNotFoundException;
import org.api.resthibernate.service.EmployeeService;
import org.api.resthibernate.to.EmployeeTo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
public class EmployeeController {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	EmployeeService service;
	
	@PostMapping(path="/employee")
	public ResponseEntity<?> addEmployee(@RequestBody EmployeeTo employee, UriComponentsBuilder uriBuilder) {
		logger.info(employee.toString());;
		Long id = service.addEmployee(employee);		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation( uriBuilder.path("/employee/{id}").buildAndExpand(id).toUri());
		return new ResponseEntity<>(headers,HttpStatus.CREATED);
	}
	
	@GetMapping(path = "/employee/{id}")
	public ResponseEntity<EmployeeTo> getEmployeeById(@PathVariable("id") Long id) {
		EmployeeTo emp = service.getEmployeeById(id);
		if(emp == null) {
			throw new EmployeNotFoundException();
		}
		return new ResponseEntity<>(emp, HttpStatus.OK);
	}
	
	/*@GetMapping(name = "/all")
	@ResponseBody
	public List<Employee> getAllEmployees() {
		List<Employee> empList = null;
		try {
			empList = service.retrieveAllEmployees();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return empList;
	}*/
	

	/*@PostMapping("/updateEmployeeById")
	public EmployeeTo updateEmployeeById(EmployeeTo employee) {
		return service.updateEmployeeById(employee);
	}
	*/

	
	
}

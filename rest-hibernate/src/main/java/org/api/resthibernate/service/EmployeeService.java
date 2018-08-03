package org.api.resthibernate.service;

import java.util.List;

import org.api.resthibernate.domain.Employee;
import org.api.resthibernate.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	@Autowired
	@Qualifier("employeeRepo")
	EmployeeRepository repository;
	
	public List<Employee> retrieveAllEmployees() {
		return  repository.retrieveAllEmployee();
	}

}

package org.api.resthibernate.repository;

import java.util.List;

import org.api.resthibernate.domain.Employee;

public interface EmployeeRepository {

	public List<Employee> retrieveAllEmployee();
	
}

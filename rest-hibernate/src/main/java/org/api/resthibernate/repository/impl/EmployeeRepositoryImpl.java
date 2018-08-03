package org.api.resthibernate.repository.impl;

import java.util.List;

import org.api.resthibernate.domain.Employee;
import org.api.resthibernate.repository.EmployeeRepository;
import org.springframework.stereotype.Repository;

@Repository("employeeRepo")
public class EmployeeRepositoryImpl  implements EmployeeRepository{

	@Override
	public List<Employee> retrieveAllEmployee() {

		return null;
	}
	
}

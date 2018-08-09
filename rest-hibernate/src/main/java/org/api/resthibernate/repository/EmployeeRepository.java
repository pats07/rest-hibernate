package org.api.resthibernate.repository;

import java.util.List;

import org.api.resthibernate.domain.Department;
import org.api.resthibernate.domain.Employee;
import org.api.resthibernate.to.EmployeeTo;

public interface EmployeeRepository {

	public List<Employee> retrieveAllEmployee();

	public Long saveEmployee(Employee employee);

	public Department getDepartmentById(Long deptId);

	public Employee updateEmployeeById(Employee emp);

	public Employee getEmployeeById(Long id);

	public Employee deleteEmployeeById(Long id);
	
}

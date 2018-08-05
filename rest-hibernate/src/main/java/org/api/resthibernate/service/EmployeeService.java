package org.api.resthibernate.service;

import java.util.List;

import org.api.resthibernate.domain.Department;
import org.api.resthibernate.domain.Employee;
import org.api.resthibernate.repository.EmployeeRepository;
import org.api.resthibernate.to.EmployeeTo;
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

	public Long addEmployee(EmployeeTo employee) {
		
		Employee emp = new Employee();
		emp.setEmployee_name(employee.getName());
		emp.setSalaryPerAnum(employee.getSalaryPerAnum());
		
		Department dept = repository.getDepartmentById(employee.getDeptId());
		emp.setDept(dept.getDept_name());
				
		return repository.saveEmployee(emp);
	}

}

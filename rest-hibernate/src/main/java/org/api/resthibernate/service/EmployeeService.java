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

	public EmployeeTo updateEmployeeById(EmployeeTo employee) {
		
		Employee emp = new Employee();
		emp.setEmpId(employee.getEmployeeId());
		emp.setEmployee_name(employee.getName());
		emp.setSalaryPerAnum(employee.getSalaryPerAnum());
		
		Employee emp1 = repository.updateEmployeeById(emp);
		
		EmployeeTo to = new EmployeeTo();
		to.setEmployeeId(emp1.getEmpId());
		to.setName(emp1.getEmployee_name());
		to.setSalaryPerAnum(emp1.getSalaryPerAnum());
		
		return to;
	}

	public EmployeeTo getEmployeeById(Long id) {
		
		EmployeeTo to = null;
		Employee employee = repository.getEmployeeById(id);
		if(employee != null) {
			to = new EmployeeTo();
			to.setEmployeeId(employee.getEmpId());
			to.setName(employee.getEmployee_name());
			to.setSalaryPerAnum(employee.getSalaryPerAnum());
		}
		return to;
	}

	public Employee deleteEmployeeById(Long id) {
		return repository.deleteEmployeeById(id);
		
	}

}

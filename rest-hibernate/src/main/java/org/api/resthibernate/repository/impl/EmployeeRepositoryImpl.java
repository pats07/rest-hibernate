package org.api.resthibernate.repository.impl;

import java.util.List;

import org.api.resthibernate.domain.Department;
import org.api.resthibernate.domain.Employee;
import org.api.resthibernate.repository.EmployeeRepository;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("employeeRepo")
public class EmployeeRepositoryImpl implements EmployeeRepository {

	@Autowired
	SessionFactory sfactory;

	@Override
	public List<Employee> retrieveAllEmployee() {

		Session session = sfactory.openSession();
		Query query = session.createQuery("select emp.empId, emp.employee_name, emp.dept, emp.salaryPerAnum from Employee emp");
		List<Employee> list = query.list();
		session.close();
		return list;
	}

	@Override
	public Long saveEmployee(Employee employee) {

		Session session = sfactory.openSession();
		session.beginTransaction();
		Long id = (Long) session.save(employee);
		session.getTransaction().commit();
		session.close();
		return id;
	}

	@Override
	public Department getDepartmentById(Long deptId) {
		Department dept =null;
		try {
			Session session = sfactory.openSession();
			dept = session.get(Department.class, deptId);
			session.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return dept;
	}

	@Override
	public Employee updateEmployeeById(Employee emp) {
		Session  session = sfactory.openSession();
		session.beginTransaction();
		Employee e = session.load(Employee.class, emp.getEmpId());
		e.setEmployee_name(emp.getEmployee_name());
		e.setSalaryPerAnum(emp.getSalaryPerAnum());
		
		session.update(e);
		session.getTransaction().commit();
		session.close();		
		return e;
	}
	
	@Override
	public Employee getEmployeeById(Long id) {
		
		Session session = sfactory.openSession();
		Employee employee = session.get(Employee.class, id);
		return employee;
	}
}

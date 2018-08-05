package org.api.resthibernate.repository.impl;

import java.util.List;

import org.api.resthibernate.domain.Department;
import org.api.resthibernate.domain.Employee;
import org.api.resthibernate.repository.EmployeeRepository;
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

		return null;
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
}

package org.api.resthibernate.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.api.resthibernate.reference.Department;

@Entity(name="Employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long empId;

	@Column(name = "employee_name")
	private String employee_name;
	
	@Column(name="department")
	public Department dept;
	
	@Column(name="salary_pa")
	public BigDecimal salaryPerAnnum;
			
}

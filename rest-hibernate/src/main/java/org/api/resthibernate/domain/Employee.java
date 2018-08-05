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
	public String dept;
	
	@Column(name="salary_pa")
	public BigDecimal salaryPerAnum;
	
	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public BigDecimal getSalaryPerAnum() {
		return salaryPerAnum;
	}

	public void setSalaryPerAnum(BigDecimal salaryPerAnum) {
		this.salaryPerAnum = salaryPerAnum;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", employee_name=" + employee_name
				+ ", dept=" + dept + ", salaryPerAnnum=" + salaryPerAnum + "]";
	}

	
	
}

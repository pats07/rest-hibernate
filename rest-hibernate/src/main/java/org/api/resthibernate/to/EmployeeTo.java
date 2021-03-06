package org.api.resthibernate.to;

import java.math.BigDecimal;

public class EmployeeTo {

	private Long employeeId;
	private String name;
	private Long deptId;
	private BigDecimal salaryPerAnum;

	
	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public BigDecimal getSalaryPerAnum() {
		return salaryPerAnum;
	}

	public void setSalaryPerAnum(BigDecimal salaryPerAnum) {
		this.salaryPerAnum = salaryPerAnum;
	}

	@Override
	public String toString() {
		return "EmployeeTo [name=" + name + ", deptId=" + deptId
				+ ", salaryPerAnum=" + salaryPerAnum + "]";
	}

}

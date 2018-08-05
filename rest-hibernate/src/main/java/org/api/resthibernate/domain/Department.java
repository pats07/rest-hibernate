package org.api.resthibernate.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Department {

	@Id
	@Column(name = "dept_id")
	private Long id;

	@Column(name = "dept_name")
	private String dept_name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", dept_name=" + dept_name + "]";
	}

}

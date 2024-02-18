package com.psl.employee;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee {
	
	@Id
	private Long empId;
	private String empName;
	private String designation;
	private String department;
	private Long salary;
	
	public Employee() {
		super();
	}

	public Employee(Long empId, String empName, String designation, String department, Long salary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.designation = designation;
		this.department = department;
		this.salary = salary;
	}

	public Long getEmpId() {
		return empId;
	}
	
	public void setEmpId(Long empId) {
		this.empId = empId;
	}
	
	public String getEmpName() {
		return empName;
	}
	
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	public String getDesignation() {
		return designation;
	}
	
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public Long getSalary() {
		return salary;
	}
	
	public void setSalary(Long salary) {
		this.salary = salary;
	}
}

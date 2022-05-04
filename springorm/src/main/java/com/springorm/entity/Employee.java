package com.springorm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee_details")
public class Employee {
	
	@Id
	@Column(name="employee_id")
	private int employeeId;
	
	@Column(name="employee_name")
	private String employeeName;
	
	@Column(name="employee_city")
	private String employeeCity;
	
	public Employee() {}
	
	public Employee(int employeeId, String employeeName, String employeeCity) {
		super();
		this.setEmployeeId(employeeId);
		this.setEmployeeName(employeeName);
		this.setEmployeeCity(employeeCity);
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeCity() {
		return employeeCity;
	}
	public void setEmployeeCity(String employeeCity) {
		this.employeeCity = employeeCity;
	}
	
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeCity="
				+ employeeCity + "]";
	}	
	
}

package com.springorm.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.springorm.entity.Employee;

public class EmployeeDao {
	private HibernateTemplate hibernateTemp;
	
	//save Employee
	@Transactional
	public int insert(Employee employee) {
		//Parsing to Integer Object bcoz this.hibernateTemp.save(Object) returns serializable
		Integer result =(Integer) this.hibernateTemp.save(employee);
		return result;
	}
	
	//Read single employee
	public Employee getEmployee(int studentId) {
		Employee emp = this.hibernateTemp.get(Employee.class, studentId);
		return emp;
	}
	
	//Read list of employee
	public List<Employee> getAllEmployees() {
		List<Employee> emps = this.hibernateTemp.loadAll(Employee.class);
		return emps;
	}
	
	//Update Employee
	@Transactional
	public void update(Employee employee) {
		this.hibernateTemp.update(employee);
		
	}
	
	//delete Employee
	@Transactional
		public void delete(int employeeId) {
			Employee e = this.hibernateTemp.get(Employee.class, employeeId);
			this.hibernateTemp.delete(e);
		}

	public HibernateTemplate getHibernateTemp() {
		return hibernateTemp;
	}

	public void setHibernateTemp(HibernateTemplate hibernateTemp) {
		this.hibernateTemp = hibernateTemp;
	}
	
	
}

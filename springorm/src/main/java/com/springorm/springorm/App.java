package com.springorm.springorm;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springorm.dao.EmployeeDao;
import com.springorm.entity.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	System.out.println("starting.........................");
    	ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
    	EmployeeDao employeeDao = context.getBean("employeeDao",EmployeeDao.class);
//    	Employee emp1 = new Employee(1001,"employee1","city1");
    	Employee emp = new Employee(1001,"employee","city");

    	List<Employee> allEmployees = employeeDao.getAllEmployees();
    	
//    	for(Employee e : allEmployees) {
//    		System.out.println(e);
//    	}
    	
    	employeeDao.update(emp);
    	
    	System.out.println("finished.........................");
  
    }

}

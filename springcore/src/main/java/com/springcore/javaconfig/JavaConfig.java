package com.springcore.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.springcore.javaconfig")
public class JavaConfig {
	
	@Bean
	public Address getAddress() {
		Address add = new Address();
		return add;
	}
	
	//array of names
	@Bean(name = {"getEmployee", "temp"})
	public Employee getEmployee() {
		Employee emp = new Employee(getAddress());
		emp.name = "batman";
		return emp;
	}
}

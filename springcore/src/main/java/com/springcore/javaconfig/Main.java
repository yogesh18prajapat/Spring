package com.springcore.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
		public static void main(String[] args) {
			ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
			Employee emp = context.getBean("temp",Employee.class);
			System.out.println(emp);
			emp.getMessage();
		}

}

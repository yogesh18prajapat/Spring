package com.springcore.collectiontype;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpMain {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/collectiontype/collectionconfig.xml");
		Employee emp1 = (Employee)context.getBean("emp1");
		System.out.println(emp1);
		System.out.println(emp1.getProps());
	}
}

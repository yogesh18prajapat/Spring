package com.springcore.stereotype;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springcore.Student;

public class StereotypeMain {
	public static void main(String[] args) {
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext(
					"com/springcore/stereotype/stereoconfig.xml");
			System.out.println("-------------------------------------------------");
			Person person =(Person)context.getBean("person");
			System.out.println(person);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
}

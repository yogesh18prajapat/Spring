package com.springcore.standalone.collections;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StandaloneMain {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/springcore/standalone/collections/standalone.xml");
		Person person1 = (Person)context.getBean("person1");
		System.out.println(person1);
		System.out.println("-------------------------------------------------");
		System.out.println(person1.getLanguage().getClass().getName());
		System.out.println(person1.getLanguage());
		System.out.println("-------------------------------------------------");
		System.out.println(person1.getCoursfee().getClass().getName());
		System.out.println(person1.getCoursfee());
		System.out.println("-------------------------------------------------");


	}
}
